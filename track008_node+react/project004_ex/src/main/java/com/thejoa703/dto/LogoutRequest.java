package com.thejoa703.dto;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "로그아웃 요청")
@Getter @Setter
public class LogoutRequest {

    @NotBlank
    @Schema(description = "Refresh Token", example = "eyJhbGciOiJIUzUxMiJ9...")
    private String refreshToken;
}
