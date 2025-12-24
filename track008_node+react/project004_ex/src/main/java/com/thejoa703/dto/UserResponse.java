package com.thejoa703.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "사용자 응답")
@Getter @Setter
public class UserResponse {

    @Schema(description = "사용자 ID", example = "1")
    private Long id;

    @Schema(description = "사용자 이메일", example = "user@test.com")
    private String email;

    @Schema(description = "사용자 닉네임", example = "thejoa703")
    private String nickname;
}
