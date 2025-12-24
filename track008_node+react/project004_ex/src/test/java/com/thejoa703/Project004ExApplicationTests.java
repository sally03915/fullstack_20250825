package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Comment;
import com.thejoa703.entity.Follow;
import com.thejoa703.entity.Hashtag;
import com.thejoa703.entity.Image;
import com.thejoa703.entity.Post;
import com.thejoa703.entity.PostLike;
import com.thejoa703.entity.Retweet;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.CommentRepository;
import com.thejoa703.repository.FollowRepository;
import com.thejoa703.repository.HashtagRepository;
import com.thejoa703.repository.ImageRepository;
import com.thejoa703.repository.PostLikeRepository;
import com.thejoa703.repository.PostRepository;
import com.thejoa703.repository.RetweetRepository;

/**
 * 전체 Repository 테스트 (Oracle 환경)
 * - CRUD, 쿼리 메서드, 삭제, 페이징, 경계 케이스 검증
 */
@SpringBootTest
class Project004ExApplicationTests {

    @Autowired private AppUserRepository appUserRepository;
    @Autowired private PostRepository postRepository;
    @Autowired private CommentRepository commentRepository;
    @Autowired private ImageRepository imageRepository;
    @Autowired private HashtagRepository hashtagRepository;
    @Autowired private FollowRepository followRepository;
    @Autowired private PostLikeRepository postLikeRepository;
    @Autowired private RetweetRepository retweetRepository;

    private AppUser userA;
    private AppUser userB;
    private Post post1;

    @BeforeEach
    void init() {
        // 🔹 DB 초기화 (중복 방지)
        retweetRepository.deleteAll();
        postLikeRepository.deleteAll();
        followRepository.deleteAll();
        hashtagRepository.deleteAll();
        imageRepository.deleteAll();
        commentRepository.deleteAll();
        postRepository.deleteAll();
        appUserRepository.deleteAll();

        // 🔹 사용자 A 생성 (local provider)
        userA = new AppUser();
        userA.setEmail("a@a");
        userA.setPassword("a");
        userA.setNickname("aa");
        userA.setProvider("local"); // ✅ provider 지정
        userA.setCreatedAt(LocalDateTime.now());
        userA = appUserRepository.save(userA);

        // 🔹 사용자 B 생성 (local provider)
        userB = new AppUser();
        userB.setEmail("b@b");
        userB.setPassword("b");
        userB.setNickname("bb");
        userB.setProvider("local"); // ✅ provider 지정
        userB.setCreatedAt(LocalDateTime.now());
        userB = appUserRepository.save(userB);

        // 🔹 게시글 1 생성 (userA 작성)
        post1 = new Post();
        post1.setUser(userA);
        post1.setContent("Hello JPA Test with Oracle!");
        post1.setCreatedAt(LocalDateTime.now());
        post1 = postRepository.save(post1);
    }

    // ---- AppUserRepository ----
    @Test
    @DisplayName("AppUserRepository: local 계정 이메일 조회")
    void appUser_findByEmail_local() {
        assertThat(appUserRepository.findByEmailAndProvider(userA.getEmail(), "local")).isPresent();
        assertThat(appUserRepository.findByEmailAndProvider("none@test.com", "local")).isEmpty();
    }

    @Test
    @DisplayName("AppUserRepository: 소셜 계정 이메일+provider 조회")
    void appUser_findByEmailAndProvider_social() {
        AppUser socialUser = new AppUser();
        socialUser.setEmail("social@test.com");
        socialUser.setPassword(null); // 소셜 로그인은 password 없음
        socialUser.setNickname("socialNick");
        socialUser.setProvider("google"); // ✅ provider 지정
        socialUser.setCreatedAt(LocalDateTime.now());
        socialUser = appUserRepository.save(socialUser);

        assertThat(appUserRepository.findByEmailAndProvider("social@test.com", "google")).isPresent();
        assertThat(appUserRepository.findByEmailAndProvider("social@test.com", "local")).isEmpty();
    }

    @Test
    @DisplayName("AppUserRepository: 닉네임 중복 검증 existsByNickname")
    void appUser_existsByNickname() {
        assertTrue(appUserRepository.existsByNickname("aa"));
        assertFalse(appUserRepository.existsByNickname("ccc"));
    }

    // ---- PostRepository ----
    @Test
    @DisplayName("PostRepository: 게시글 저장/조회/페이징/삭제")
    void post_crud_and_paging() {
        assertThat(postRepository.findAll()).hasSize(1);

        // ✅ JPA 기본 PageRequest 대신 네이티브 페이징 메서드 사용
        List<Post> page = postRepository.findPostsWithPaging(1, 10);
        assertThat(page.size()).isEqualTo(1);

        postRepository.delete(post1);
        assertThat(postRepository.findById(post1.getId())).isEmpty();
    }

    // ---- CommentRepository ----
    @Test
    @DisplayName("CommentRepository: 댓글 저장/조회/삭제")
    void comment_crud() {
        Comment c = new Comment();
        c.setPost(post1);
        c.setUser(userB);
        c.setContent("Nice post from Beta!");
        c.setCreatedAt(LocalDateTime.now());
        c = commentRepository.save(c);

        assertThat(commentRepository.findById(c.getId())).isPresent();

        commentRepository.delete(c);
        assertThat(commentRepository.findById(c.getId())).isEmpty();
    }

    // ---- ImageRepository ----
    @Test
    @DisplayName("ImageRepository: 이미지 저장/조회/삭제")
    void image_crud() {
        Image img = new Image();
        img.setPost(post1);
        img.setSrc("https://cdn.test/image-" + System.currentTimeMillis() + ".png");
        img = imageRepository.save(img);

        assertThat(imageRepository.findById(img.getId())).isPresent();

        imageRepository.delete(img);
        assertThat(imageRepository.findById(img.getId())).isEmpty();
    }

    // ---- HashtagRepository ----
    @Test
    @DisplayName("HashtagRepository: 해시태그 저장/조회/삭제")
    void hashtag_crud() {
        Hashtag tag = new Hashtag();
        tag.setName("springboot" + System.currentTimeMillis());
        tag = hashtagRepository.save(tag);

        assertThat(hashtagRepository.findByName(tag.getName())).isPresent();

        hashtagRepository.delete(tag);
        assertThat(hashtagRepository.findByName(tag.getName())).isEmpty();
    }

    // ---- FollowRepository ----
    @Test
    @DisplayName("FollowRepository: 팔로우 생성/조회/삭제")
    void follow_crud() {
        Follow relation = new Follow();
        relation.setFollower(userA);
        relation.setFollowee(userB);
        relation.setBlocked(false);
        relation.setCreatedAt(LocalDateTime.now());
        relation = followRepository.save(relation);

        assertThat(followRepository.findByFollowerIdAndFolloweeId(userA.getId(), userB.getId())).isPresent();

        followRepository.delete(relation);
        assertThat(followRepository.findByFollowerIdAndFolloweeId(userA.getId(), userB.getId())).isEmpty();
    }

    // ---- PostLikeRepository ----
    @Test
    @DisplayName("PostLikeRepository: 좋아요 생성/조회/삭제/집계")
    void postLike_crud() {
        PostLike like = new PostLike();
        like.setUser(userA);
        like.setPost(post1);
        like.setCreatedAt(LocalDateTime.now());
        like = postLikeRepository.save(like);

        assertThat(postLikeRepository.findByUserIdAndPostId(userA.getId(), post1.getId())).isPresent();
        assertThat(postLikeRepository.countByPostId(post1.getId())).isEqualTo(1);

        postLikeRepository.delete(like);
        assertThat(postLikeRepository.findByUserIdAndPostId(userA.getId(), post1.getId())).isEmpty();
    }

    // ---- RetweetRepository ----
    @Test
    @DisplayName("RetweetRepository: 리트윗 생성/조회/삭제")
    void retweet_crud() {
        Retweet rt = new Retweet();
        rt.setUser(userA);
        rt.setOriginalPost(post1);
        rt.setCreatedAt(LocalDateTime.now());
        rt = retweetRepository.save(rt);

        assertThat(retweetRepository.findByUserIdAndOriginalPostId(userA.getId(), post1.getId())).isPresent();

        retweetRepository.delete(rt);
        assertThat(retweetRepository.findByUserIdAndOriginalPostId(userA.getId(), post1.getId())).isEmpty();
    }
}
