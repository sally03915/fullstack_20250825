package com.thejoa703.dto;

import java.time.LocalDateTime;

import com.thejoa703.entity.Post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "게시글 응답")
@Getter @Setter
public class PostResponse {

    @Schema(description = "게시글 ID", example = "101")
    private Long id;

    @Schema(description = "게시글 내용", example = "첫 번째 게시글입니다!")
    private String content;

    @Schema(description = "작성자 닉네임", example = "thejoa703")
    private String nickname; // AppUser.nickname
    
    @Schema(description = "작성일시", example = "2025-12-06T00:52:00")
    private LocalDateTime createdAt; // 🔹 추가
    
    // 🔹 엔티티 → DTO 변환 메서드
    public static PostResponse fromEntity(Post post) {
        PostResponse dto = new PostResponse();
        dto.setId(post.getId());
        dto.setContent(post.getContent());
        dto.setNickname(post.getUser().getNickname());
        dto.setCreatedAt(post.getCreatedAt());
        return dto;
    }
}
