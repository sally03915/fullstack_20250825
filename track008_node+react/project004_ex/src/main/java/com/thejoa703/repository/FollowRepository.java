package com.thejoa703.repository;

import com.thejoa703.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * 팔로우 관계 엔티티(Follow)용 Repository
 * - 팔로우/언팔로우/차단 관련 조회 기능 제공
 */
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByFollowerIdAndFolloweeId(Long followerId, Long followeeId); // 특정 관계 조회

    List<Follow> findByFollowerIdAndBlockedFalse(Long followerId); // 내가 팔로우한 사람들(차단 제외)
    List<Follow> findByFolloweeIdAndBlockedFalse(Long followeeId); // 나를 팔로우한 사람들(차단 제외)

    List<Follow> findByFollowerId(Long followerId); // 내가 팔로우한 전체 목록
    List<Follow> findByFolloweeId(Long followeeId); // 나를 팔로우한 전체 목록
}
