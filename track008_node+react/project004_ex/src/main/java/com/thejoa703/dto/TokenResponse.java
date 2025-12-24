package com.thejoa703.dto;

//ALTER USER scott IDENTIFIED BY tiger ACCOUNT UNLOCK;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Schema(description = "토큰 응답")
@Getter
@AllArgsConstructor
public class TokenResponse {

    @Schema(description = "액세스 토큰", example = "eyJhbGciOiJIUzUxMiJ9...")
    private final String accessToken;

    @Schema(description = "리프레시 토큰", example = "eyJhbGciOiJIUzUxMiJ9...")
    private final String refreshToken;
}
