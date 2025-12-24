package com.thejoa703.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 댓글 응답 DTO
 * - 댓글 ID, 내용, 작성자 닉네임, 작성자 ID 포함
 */
@Schema(description = "댓글 응답")
@Getter @Setter
public class CommentResponse {

    @Schema(description = "댓글 ID", example = "501")
    private Long id;

    @Schema(description = "댓글 내용", example = "좋은 글 잘 읽었습니다!")
    private String content;

    @Schema(description = "작성자 닉네임", example = "thejoa703")
    private String author; // AppUser.nickname

    @Schema(description = "작성자 ID", example = "1001")
    private Long authorId; // 🔹 AppUser.id
}
