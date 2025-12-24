package com.thejoa703.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.dto.CommentRequest;
import com.thejoa703.dto.CommentResponse;
import com.thejoa703.dto.PostRequest;
import com.thejoa703.dto.PostResponse;
import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Comment;
import com.thejoa703.entity.Hashtag;
import com.thejoa703.entity.Post;
import com.thejoa703.entity.PostLike;
import com.thejoa703.entity.Retweet;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.CommentRepository;
import com.thejoa703.repository.HashtagRepository;
import com.thejoa703.repository.PostLikeRepository;
import com.thejoa703.repository.PostRepository;
import com.thejoa703.repository.RetweetRepository;

import lombok.RequiredArgsConstructor;

/**
 * 게시글 서비스
 * - 게시글 CRUD (소프트 삭제)
 * - 댓글 CRUD (소프트 삭제)
 * - 댓글 목록 조회
 * - 좋아요/리트윗
 * - 해시태그 검색
 * 
 * 보완 포인트:
 * 1. @Transactional 적용 (쓰기 작업 기본, 조회는 readOnly)
 * 2. 소프트 삭제된 데이터는 목록/검색에서 제외
 * 3. 해시태그/댓글 컬렉션은 가변 리스트로 처리
 * 4. content는 null-safe 처리
 */
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final AppUserRepository appUserRepository;
    private final CommentRepository commentRepository;
    private final PostLikeRepository postLikeRepository;
    private final RetweetRepository retweetRepository;
    private final HashtagRepository hashtagRepository;

    /** 게시글 목록 조회 (Oracle 네이티브 페이징) */
    @Transactional(readOnly = true)
    public List<PostResponse> getPosts(int page, int size) {
        int safePage = Math.max(page, 1);
        int safeSize = Math.max(size, 1);
        int startRow = (safePage - 1) * safeSize + 1;
        int endRow = safePage * safeSize;

        List<Post> posts = postRepository.findPostsWithPaging(startRow, endRow);
        return posts.stream()
                    .filter(p -> !p.isDeleted()) // 소프트 삭제 제외
                    .map(PostResponse::fromEntity)
                    .toList();
    }

    /** 게시글 작성 */
    @Transactional
    public PostResponse createPost(Long userId, PostRequest request) {
        AppUser user = appUserRepository.findById(userId).orElseThrow();
        Post post = new Post();
        post.setUser(user);
        post.setContent(safeContent(request.getContent()));

        List<Hashtag> tags = resolveTags(request.getHashtags());
        post.getHashtags().clear();
        post.getHashtags().addAll(tags);

        Post saved = postRepository.save(post);
        return PostResponse.fromEntity(saved);
    }

    /** 게시글 수정 (작성자만 가능) */
    @Transactional
    public PostResponse updatePost(Long userId, Long postId, PostRequest request) {
        Post post = postRepository.findById(postId).orElseThrow();

        if (post.isDeleted()) {
            throw new IllegalStateException("Cannot update deleted post");
        }
        if (!post.getUser().getId().equals(userId)) {
            throw new IllegalStateException("No permission to update");
        }

        post.setContent(safeContent(request.getContent()));

        List<Hashtag> tags = resolveTags(request.getHashtags());
        post.getHashtags().clear();
        post.getHashtags().addAll(tags);

        Post updated = postRepository.save(post);
        return PostResponse.fromEntity(updated);
    }

    /** 게시글 삭제 (소프트 삭제) */
    @Transactional
    public void deletePost(Long userId, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        if (!post.getUser().getId().equals(userId)) {
            throw new IllegalStateException("No permission to delete");
        }
        post.setDeleted(true);
        postRepository.save(post);
    }

    /** 댓글 작성 */
    @Transactional
    public CommentResponse addComment(Long userId, Long postId, CommentRequest request) {
        AppUser user = appUserRepository.findById(userId).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setContent(safeContent(request.getContent()));

        Comment saved = commentRepository.save(comment);
        return toCommentResponse(saved);
    }

    /** 댓글 수정 (작성자만 가능) */
    @Transactional
    public CommentResponse updateComment(Long userId, Long postId, Long commentId, CommentRequest request) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        if (comment.isDeleted()) {
            throw new IllegalStateException("Cannot update deleted comment");
        }
        if (!comment.getUser().getId().equals(userId) || !comment.getPost().getId().equals(postId)) {
            throw new IllegalStateException("No permission to update comment");
        }

        comment.setContent(safeContent(request.getContent()));
        Comment updated = commentRepository.save(comment);
        return toCommentResponse(updated);
    }

    /** 댓글 삭제 (소프트 삭제) */
    @Transactional
    public void deleteComment(Long userId, Long postId, Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        if (!comment.getUser().getId().equals(userId) || !comment.getPost().getId().equals(postId)) {
            throw new IllegalStateException("No permission to delete comment");
        }
        comment.setDeleted(true);
        commentRepository.save(comment);
    }

    /** 댓글 목록 조회 (삭제되지 않은 댓글만) */
    @Transactional(readOnly = true)
    public List<CommentResponse> getComments(Long postId) {
        List<Comment> comments = commentRepository.findByPostIdAndDeletedFalse(postId);
        return comments.stream()
                       .map(this::toCommentResponse)
                       .toList();
    }

    /** 좋아요 */
    @Transactional
    public void likePost(Long userId, Long postId) {
        if (postLikeRepository.findByUserIdAndPostId(userId, postId).isPresent()) return;
        AppUser user = appUserRepository.findById(userId).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();

        PostLike like = new PostLike();
        like.setUser(user);
        like.setPost(post);
        postLikeRepository.save(like);
    }

    /** 좋아요 취소 */
    @Transactional
    public void unlikePost(Long userId, Long postId) {
        postLikeRepository.findByUserIdAndPostId(userId, postId)
                .ifPresent(postLikeRepository::delete);
    }

    /** 리트윗 */
    @Transactional
    public PostResponse retweet(Long userId, Long postId) {
        AppUser user = appUserRepository.findById(userId).orElseThrow();
        Post original = postRepository.findById(postId).orElseThrow();

        Retweet rt = new Retweet();
        rt.setUser(user);
        rt.setOriginalPost(original);
        retweetRepository.save(rt);

        Post retweetPost = new Post();
        retweetPost.setUser(user);
        retweetPost.setContent("RT: " + safeContent(original.getContent()));

        Post saved = postRepository.save(retweetPost);
        return PostResponse.fromEntity(saved);
    }

    /** 리트윗 취소 */
    @Transactional
    public void cancelRetweet(Long userId, Long postId) {
        retweetRepository.findByUserIdAndOriginalPostId(userId, postId)
                .ifPresent(retweetRepository::delete);
    }

    /** 해시태그 검색 (삭제된 글 제외) */
    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByHashtag(String name) {
        Hashtag tag = hashtagRepository.findByNameWithPosts(name)
                .orElseThrow(() -> new IllegalArgumentException("Hashtag not found"));

        return tag.getPosts().stream()
                .filter(p -> !p.isDeleted())
                .map(PostResponse::fromEntity)
                .toList();
    }

    /** 해시태그 처리 공통화 */
    private List<Hashtag> resolveTags(List<String> names) {
        if (names == null || names.isEmpty()) return new ArrayList<>();
        List<Hashtag> resolved = new ArrayList<>();
        for (String n : names) {
            Hashtag h = hashtagRepository.findByName(n)
                    .orElseGet(() -> {
                        Hashtag created = new Hashtag();
                        created.setName(n);
                        return hashtagRepository.save(created);
                    });
            resolved.add(h);
        }
        return resolved;
    }
 
    /** 댓글 응답 변환 */
    private CommentResponse toCommentResponse(Comment comment) {
        CommentResponse res = new CommentResponse();
        res.setId(comment.getId());
        res.setContent(comment.getContent());
        res.setAuthor(comment.getUser().getNickname());
        res.setAuthorId(comment.getUser().getId()); // 작성자 id 추가
        return res;
    }

    /** content 방어: null → 빈 문자열, trim 처리 */
    private String safeContent(String content) {
        return content == null ? "" : content.trim();
    }
}
