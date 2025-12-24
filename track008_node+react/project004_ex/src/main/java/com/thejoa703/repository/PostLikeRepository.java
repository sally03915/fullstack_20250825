package com.thejoa703.repository;

import com.thejoa703.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 좋아요 엔티티(PostLike)용 Repository
 * - 특정 사용자/게시글 좋아요 여부 확인
 * - 게시글 좋아요 수 집계
 */
public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Optional<PostLike> findByUserIdAndPostId(Long userId, Long postId); // 특정 사용자-게시글 좋아요 여부
    long countByPostId(Long postId); // 게시글 좋아요 수
}
