package com.thejoa703.service;

import com.thejoa703.dto.SignupRequest;
import com.thejoa703.dto.UserResponse;
import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Follow;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 사용자 관련 서비스 로직
 * - 회원가입, 닉네임 변경, 팔로우/언팔로우, 팔로워 차단, 회원탈퇴
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final AppUserRepository appUserRepository;
    private final FollowRepository followRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    /** 회원가입 */
    public void signup(SignupRequest request) {
        // 🔹 email + provider 중복 검증
        if (appUserRepository.findByEmailAndProvider(request.getEmail(), request.getProvider()).isPresent()) {
            throw new IllegalArgumentException("Email already exists for provider: " + request.getProvider());
        }

        AppUser user = new AppUser();
        user.setEmail(request.getEmail());
        user.setNickname(request.getNickname());
        user.setProvider(request.getProvider()); // 🔹 provider 저장
        user.setCreatedAt(LocalDateTime.now());

        // local 계정만 password 저장
        if ("local".equalsIgnoreCase(request.getProvider())) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        } else {
            user.setPassword(null);
        }

        appUserRepository.save(user);
    }
    /** 사용자 조회 */
    public UserResponse getUser(Long userId) {
        AppUser user = appUserRepository.findById(userId).orElseThrow();
        return toResponse(user);
    }

    /** 닉네임 변경 (중복 검증 최적화) */
    public UserResponse updateNickname(Long userId, String nickname) {
        // 닉네임 중복 검증 (existsByNickname 메서드 활용 권장)
        if (appUserRepository.existsByNickname(nickname)) {
            throw new IllegalArgumentException("Nickname already exists");
        }
        AppUser user = appUserRepository.findById(userId).orElseThrow();
        user.setNickname(nickname);
        appUserRepository.save(user);
        return toResponse(user);
    }

    /** 회원탈퇴 (소프트 삭제 + RefreshToken 삭제) */
    public void deleteUser(Long userId) {
        AppUser user = appUserRepository.findById(userId).orElseThrow();
        user.setDeleted(true);
        appUserRepository.save(user);
        // Redis RefreshToken 삭제
        tokenService.deleteRefreshToken(userId.toString());
    }

    /** 팔로우 */
    public void followUser(Long followerId, Long followeeId) {
        if (followerId.equals(followeeId)) {
            throw new IllegalArgumentException("Cannot follow yourself");
        }
        AppUser follower = appUserRepository.findById(followerId).orElseThrow();
        AppUser followee = appUserRepository.findById(followeeId).orElseThrow();

        Follow relation = followRepository.findByFollowerIdAndFolloweeId(followerId, followeeId)
                .orElseGet(() -> {
                    Follow f = new Follow();
                    f.setFollower(follower);
                    f.setFollowee(followee);
                    return f;
                });

        relation.setBlocked(false); // 팔로우 시 차단 해제
        followRepository.save(relation);
    }

    /** 언팔로우 */
    public void unfollowUser(Long followerId, Long followeeId) {
        followRepository.findByFollowerIdAndFolloweeId(followerId, followeeId)
                .ifPresent(followRepository::delete);
    }

    /** 내가 팔로우한 사람 목록 */
    public List<UserResponse> getFollowings(Long userId) {
        return followRepository.findByFollowerIdAndBlockedFalse(userId).stream()
                .map(f -> toResponse(f.getFollowee()))
                .toList();
    }

    /** 나를 팔로우한 사람 목록 */
    public List<UserResponse> getFollowers(Long userId) {
        return followRepository.findByFolloweeIdAndBlockedFalse(userId).stream()
                .map(f -> toResponse(f.getFollower()))
                .toList();
    }

    /** 팔로워 차단 */
    public void blockFollower(Long userId, Long followerId) {
        Follow relation = followRepository.findByFollowerIdAndFolloweeId(followerId, userId)
                .orElseThrow(() -> new IllegalStateException("Relation not found"));
        relation.setBlocked(true);
        followRepository.save(relation);
    }

    /** 변환 메서드: AppUser → UserResponse */
    private UserResponse toResponse(AppUser user) {
        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setEmail(user.getEmail());
        res.setNickname(user.getNickname());
        return res;
    }
}
