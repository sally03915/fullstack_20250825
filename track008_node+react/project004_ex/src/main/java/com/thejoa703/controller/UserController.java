package com.thejoa703.controller;

import com.thejoa703.dto.UserResponse;
import com.thejoa703.dto.NicknameRequest;
import com.thejoa703.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 사용자 관련 REST 컨트롤러
 * - 조회, 닉네임 변경, 회원탈퇴, 팔로우/언팔로우/차단
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @Operation(summary = "사용자 조회", description = "ID로 사용자 정보 조회")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping("/{userId}")
    public UserResponse getUser(
        @Parameter(name = "userId", description = "조회할 사용자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId
    ) {
        return userService.getUser(userId);
    }

    @Operation(summary = "닉네임 변경", description = "사용자 닉네임 변경")
    @ApiResponse(responseCode = "200", description = "변경 성공")
    @PutMapping("/{userId}/nickname")
    public UserResponse updateNickname(
        @Parameter(name = "userId", description = "닉네임을 변경할 사용자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @RequestBody NicknameRequest request
    ) {
        return userService.updateNickname(userId, request.getNickname());
    }

    @Operation(summary = "회원탈퇴", description = "사용자 계정을 소프트 삭제 처리")
    @ApiResponse(responseCode = "200", description = "회원탈퇴 성공")
    @DeleteMapping("/{userId}")
    public void deleteUser(
        @Parameter(name = "userId", description = "탈퇴할 사용자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId
    ) {
        userService.deleteUser(userId);
    }

    @Operation(summary = "팔로우", description = "다른 사용자 팔로우")
    @ApiResponse(responseCode = "200", description = "팔로우 성공")
    @PostMapping("/{followerId}/follow/{followeeId}")
    public void followUser(
        @Parameter(name = "followerId", description = "팔로우를 하는 사용자 ID", required = true, example = "1")
        @PathVariable("followerId") Long followerId,
        @Parameter(name = "followeeId", description = "팔로우 당하는 사용자 ID", required = true, example = "2")
        @PathVariable("followeeId") Long followeeId
    ) {
        userService.followUser(followerId, followeeId);
    }

    @Operation(summary = "언팔로우", description = "팔로우 취소")
    @ApiResponse(responseCode = "200", description = "언팔로우 성공")
    @DeleteMapping("/{followerId}/follow/{followeeId}")
    public void unfollowUser(
        @Parameter(name = "followerId", description = "언팔로우를 하는 사용자 ID", required = true, example = "1")
        @PathVariable("followerId") Long followerId,
        @Parameter(name = "followeeId", description = "언팔로우 당하는 사용자 ID", required = true, example = "2")
        @PathVariable("followeeId") Long followeeId
    ) {
        userService.unfollowUser(followerId, followeeId);
    }

    @Operation(summary = "팔로잉 목록", description = "내가 팔로우한 사용자 목록 조회")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping("/{userId}/followings")
    public List<UserResponse> getFollowings(
        @Parameter(name = "userId", description = "팔로잉 목록을 조회할 사용자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId
    ) {
        return userService.getFollowings(userId);
    }

    @Operation(summary = "팔로워 목록", description = "나를 팔로우한 사용자 목록 조회")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping("/{userId}/followers")
    public List<UserResponse> getFollowers(
        @Parameter(name = "userId", description = "팔로워 목록을 조회할 사용자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId
    ) {
        return userService.getFollowers(userId);
    }

    @Operation(summary = "팔로워 차단", description = "나를 팔로우한 특정 사용자 차단")
    @ApiResponse(responseCode = "200", description = "차단 성공")
    @PostMapping("/{userId}/block/{followerId}")
    public void blockFollower(
        @Parameter(name = "userId", description = "차단을 수행하는 사용자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @Parameter(name = "followerId", description = "차단할 팔로워 사용자 ID", required = true, example = "2")
        @PathVariable("followerId") Long followerId
    ) {
        userService.blockFollower(userId, followerId);
    }
}
