package com.thejoa703.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.LogoutRequest;
import com.thejoa703.dto.RefreshRequest;
import com.thejoa703.dto.SignupRequest;
import com.thejoa703.dto.TokenResponse;
import com.thejoa703.service.AuthService;
import com.thejoa703.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * 인증 관련 REST 컨트롤러
 * - 회원가입, 로그인, 토큰 갱신, 로그아웃 처리
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    /**
     * 회원가입 API
     * - 새로운 사용자 등록
     */
    @Operation(summary = "회원가입", description = "새로운 사용자 등록")
    @ApiResponse(responseCode = "200", description = "회원가입 성공")
    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request) {
        userService.signup(request);
    }

    /**
     * 로그인 API
     * - 사용자 로그인 후 JWT 토큰 발급
     */
    @Operation(summary = "로그인", description = "사용자 로그인 후 JWT 토큰 발급")
    @ApiResponse(responseCode = "200", description = "로그인 성공")
    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    /**
     * 토큰 갱신 API
     * - RefreshToken으로 새 AccessToken 발급
     */
    @Operation(summary = "토큰 갱신", description = "RefreshToken으로 새 AccessToken 발급")
    @ApiResponse(responseCode = "200", description = "토큰 갱신 성공")
    @PostMapping("/refresh")
    public TokenResponse refresh(@RequestBody RefreshRequest request) {
        return authService.refresh(request);
    }

    /**
     * 로그아웃 API
     * - 사용자 로그아웃 및 RefreshToken 삭제
     * - AccessToken은 Swagger Authorize에 등록된 상태로 인증만 처리
     */
    @Operation(summary = "로그아웃", description = "사용자 로그아웃 및 RefreshToken 삭제")
    @ApiResponse(responseCode = "200", description = "로그아웃 성공")
    @PostMapping("/logout/{userId}")
    public void logout(
        @Parameter(name = "userId", description = "로그아웃할 사용자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @RequestBody LogoutRequest logoutRequest
    ) {
        authService.logout(userId, logoutRequest.getRefreshToken());
    }
}
