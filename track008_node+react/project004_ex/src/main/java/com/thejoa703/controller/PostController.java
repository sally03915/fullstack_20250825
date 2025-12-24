package com.thejoa703.controller;

import com.thejoa703.dto.CommentRequest;
import com.thejoa703.dto.CommentResponse;
import com.thejoa703.dto.PostRequest;
import com.thejoa703.dto.PostResponse;
import com.thejoa703.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시글 관련 REST 컨트롤러
 * - 게시글 CRUD
 * - 댓글 작성/수정/삭제
 * - 좋아요/리트윗 기능
 * - 해시태그 검색
 */
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * 게시글 목록 조회
     * - Oracle 11g 네이티브 페이징 적용
     * - page, size 파라미터로 페이징 처리
     */
    @Operation(summary = "게시글 목록 조회", description = "Oracle 11g 네이티브 페이징 적용")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping
    public List<PostResponse> getPosts(
        @Parameter(name = "page", description = "페이지 번호", example = "1")
        @RequestParam(name = "page", defaultValue = "1") int page,
        @Parameter(name = "size", description = "페이지 크기", example = "10")
        @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return postService.getPosts(page, size);
    }

    /**
     * 게시글 작성
     * - 특정 사용자(userId)가 새로운 게시글 작성
     */
    @Operation(summary = "게시글 작성", description = "새 게시글 작성")
    @ApiResponse(responseCode = "200", description = "작성 성공")
    @PostMapping("/users/{userId}")
    public PostResponse createPost(
        @Parameter(name = "userId", description = "게시글 작성자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @RequestBody PostRequest request
    ) {
        return postService.createPost(userId, request);
    }

    /**
     * 게시글 수정
     * - 작성자가 자신의 게시글을 수정
     */
    @Operation(summary = "게시글 수정", description = "작성자가 게시글 수정")
    @ApiResponse(responseCode = "200", description = "수정 성공")
    @PutMapping("/{postId}/users/{userId}")
    public PostResponse updatePost(
        @Parameter(name = "userId", description = "작성자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @Parameter(name = "postId", description = "수정할 게시글 ID", required = true, example = "10")
        @PathVariable("postId") Long postId,
        @RequestBody PostRequest request
    ) {
        return postService.updatePost(userId, postId, request);
    }

    /**
     * 게시글 삭제
     * - 작성자가 자신의 게시글을 소프트 삭제
     */
    @Operation(summary = "게시글 삭제", description = "작성자가 게시글 삭제 (소프트 삭제)")
    @ApiResponse(responseCode = "200", description = "삭제 성공")
    @DeleteMapping("/{postId}/users/{userId}")
    public void deletePost(
        @Parameter(name = "userId", description = "작성자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @Parameter(name = "postId", description = "삭제할 게시글 ID", required = true, example = "10")
        @PathVariable("postId") Long postId
    ) {
        postService.deletePost(userId, postId);
    }

    /**
     * 댓글 작성
     * - 특정 게시글에 댓글 작성
     */
    @Operation(summary = "댓글 작성", description = "게시글에 댓글 작성")
    @ApiResponse(responseCode = "200", description = "작성 성공")
    @PostMapping("/{postId}/users/{userId}/comments")
    public CommentResponse addComment(
        @Parameter(name = "userId", description = "댓글 작성자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @Parameter(name = "postId", description = "댓글을 작성할 게시글 ID", required = true, example = "10")
        @PathVariable("postId") Long postId,
        @RequestBody CommentRequest request
    ) {
        return postService.addComment(userId, postId, request);
    }

    /**
     * 댓글 수정
     * - 작성자가 자신의 댓글을 수정
     */
    @Operation(summary = "댓글 수정", description = "작성자가 댓글 수정")
    @ApiResponse(responseCode = "200", description = "수정 성공")
    @PutMapping("/{postId}/users/{userId}/comments/{commentId}")
    public CommentResponse updateComment(
        @Parameter(name = "userId", description = "댓글 작성자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @Parameter(name = "postId", description = "게시글 ID", required = true, example = "10")
        @PathVariable("postId") Long postId,
        @Parameter(name = "commentId", description = "수정할 댓글 ID", required = true, example = "100")
        @PathVariable("commentId") Long commentId,
        @RequestBody CommentRequest request
    ) {
        return postService.updateComment(userId, postId, commentId, request);
    }

    /**
     * 댓글 삭제
     * - 작성자가 자신의 댓글을 소프트 삭제
     */
    @Operation(summary = "댓글 삭제", description = "작성자가 댓글 삭제 (소프트 삭제)")
    @ApiResponse(responseCode = "200", description = "삭제 성공")
    @DeleteMapping("/{postId}/users/{userId}/comments/{commentId}")
    public void deleteComment(
        @Parameter(name = "userId", description = "댓글 작성자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @Parameter(name = "postId", description = "게시글 ID", required = true, example = "10")
        @PathVariable("postId") Long postId,
        @Parameter(name = "commentId", description = "삭제할 댓글 ID", required = true, example = "100")
        @PathVariable("commentId") Long commentId
    ) {
        postService.deleteComment(userId, postId, commentId);
    }

    /**
     * 게시글 좋아요
     * - 특정 사용자가 게시글에 좋아요 표시
     */
    @Operation(summary = "좋아요", description = "게시글 좋아요")
    @ApiResponse(responseCode = "200", description = "좋아요 성공")
    @PostMapping("/{postId}/users/{userId}/like")
    public void likePost(
        @Parameter(name = "userId", description = "좋아요를 누른 사용자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @Parameter(name = "postId", description = "좋아요 대상 게시글 ID", required = true, example = "10")
        @PathVariable("postId") Long postId
    ) {
        postService.likePost(userId, postId);
    }

    /**
     * 게시글 좋아요 취소
     * - 특정 사용자가 게시글 좋아요를 취소
     */
    @Operation(summary = "좋아요 취소", description = "게시글 좋아요 취소")
    @ApiResponse(responseCode = "200", description = "취소 성공")
    @DeleteMapping("/{postId}/users/{userId}/like")
    public void unlikePost(
        @Parameter(name = "userId", description = "좋아요 취소 사용자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @Parameter(name = "postId", description = "좋아요 취소 대상 게시글 ID", required = true, example = "10")
        @PathVariable("postId") Long postId
    ) {
        postService.unlikePost(userId, postId);
    }

    /**
     * 게시글 리트윗
     * - 특정 사용자가 게시글을 리트윗
     */
    @Operation(summary = "리트윗", description = "게시글 리트윗")
    @ApiResponse(responseCode = "200", description = "리트윗 성공")
    @PostMapping("/{postId}/users/{userId}/retweet")
    public PostResponse retweet(
        @Parameter(name = "userId", description = "리트윗 사용자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @Parameter(name = "postId", description = "리트윗 대상 게시글 ID", required = true, example = "10")
        @PathVariable("postId") Long postId
    ) {
        return postService.retweet(userId, postId);
    }

    /**
     * 리트윗 취소
     * - 특정 사용자가 게시글 리트윗을 취소
     */
    @Operation(summary = "리트윗 취소", description = "리트윗 취소")
    @ApiResponse(responseCode = "200", description = "취소 성공")
    @DeleteMapping("/{postId}/users/{userId}/retweet")
    public void cancelRetweet(
        @Parameter(name = "userId", description = "리트윗 취소 사용자 ID", required = true, example = "1")
        @PathVariable("userId") Long userId,
        @Parameter(name = "postId", description = "리트윗 취소 대상 게시글 ID", required = true, example = "10")
        @PathVariable("postId") Long postId
    ) {
        postService.cancelRetweet(userId, postId);
    }

    /**
     * 해시태그 검색
     * - 특정 해시태그로 게시글 목록 조회
     */
    @Operation(summary = "해시태그 검색", description = "특정 해시태그로 게시글 목록 조회")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping("/hashtags/{name}")
    public List<PostResponse> getPostsByHashtag(
        @Parameter(name = "name", description = "검색할 해시태그 이름", required = true, example = "springboot")
        @PathVariable("name") String name
    ) {
        return postService.getPostsByHashtag(name);
    }
    
    /**
     * 댓글 목록 조회
     * - 특정 게시글의 삭제되지 않은 댓글 목록 반환
     */
    @Operation(summary = "댓글 목록 조회", description = "특정 게시글의 댓글 목록을 조회합니다 (삭제된 댓글 제외)")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping("/{postId}/comments")
    public List<CommentResponse> getComments(
        @Parameter(name = "postId", description = "댓글을 조회할 게시글 ID", required = true, example = "10")
        @PathVariable("postId") Long postId
    ) {
        return postService.getComments(postId);
    }
}
