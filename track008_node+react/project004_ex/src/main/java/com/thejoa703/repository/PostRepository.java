package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thejoa703.entity.Post;

/**
 * 게시글 엔티티(Post)용 Repository
 * - 기본 CRUD 제공
 * - Oracle 네이티브 페이징 지원
 * - 소프트 삭제된 게시글(deleted=true)은 제외
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * Oracle 11g 네이티브 페이징 쿼리
     * - 최신 작성일(created_at) 기준 내림차순 정렬
     * - deleted=false 조건으로 소프트 삭제된 게시글 제외
     * - startRow ~ endRow 범위만 조회
     */
    @Query(
      value = "SELECT * FROM ( " +
              "SELECT p.*, ROWNUM AS rnum " +
              "FROM (SELECT * FROM posts WHERE deleted = 0 ORDER BY created_at DESC) p " +
              ") " +
              "WHERE rnum BETWEEN :start AND :end",
      nativeQuery = true
    )
    List<Post> findPostsWithPaging(@Param("start") int start, @Param("end") int end);

    /**
     * 삭제되지 않은 게시글 전체 조회
     */
    List<Post> findByDeletedFalse();
}
