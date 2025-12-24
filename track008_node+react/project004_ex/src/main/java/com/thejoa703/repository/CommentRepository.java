package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thejoa703.entity.Comment;

/**
 * 댓글 엔티티(Comment)용 Repository
 * - 기본 CRUD 제공
 * - 소프트 삭제된 댓글(deleted=true)은 제외
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    /**
     * 특정 게시글의 삭제되지 않은 댓글 목록 조회
     */
    List<Comment> findByPostIdAndDeletedFalse(Long postId);
}
