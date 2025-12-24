package com.thejoa703.dto;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "토큰 갱신 요청")
@Getter @Setter
public class RefreshRequest {

    @NotBlank
    @Schema(description = "리프레시 토큰", example = "eyJhbGciOiJIUzUxMiJ9...")
    private String refreshToken;
}
