package com.thejoa703.dto;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "닉네임 변경 요청")
@Getter @Setter
public class NicknameRequest {

    @NotBlank
    @Schema(description = "새 닉네임", example = "coolUser123")
    private String nickname;
}
