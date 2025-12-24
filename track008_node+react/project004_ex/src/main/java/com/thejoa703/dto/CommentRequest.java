package com.thejoa703.dto;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "게시글 작성 요청")
@Getter @Setter
public class CommentRequest {
    @NotBlank
    private String content;
}
