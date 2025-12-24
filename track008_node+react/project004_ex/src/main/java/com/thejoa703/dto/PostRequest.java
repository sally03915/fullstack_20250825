package com.thejoa703.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "게시글 작성 요청")
@Getter @Setter
public class PostRequest {

    @NotBlank
    @Schema(description = "게시글 내용", example = "첫 번째 게시글입니다!")
    private String content;
    

    private List<String> hashtags;
}
