package com.thejoa703.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "로그인 요청")
@Getter @Setter
public class LoginRequest {

    @Email
    @NotBlank
    @Schema(description = "사용자 이메일", example = "user@test.com")
    private String email;

    @NotBlank
    @Schema(description = "비밀번호", example = "password1234")
    private String password;

    // 🔹 추가: provider 필드 (local 기본값)
    @NotBlank
    @Schema(description = "로그인 제공자", example = "local")
    private String provider = "local";
}
