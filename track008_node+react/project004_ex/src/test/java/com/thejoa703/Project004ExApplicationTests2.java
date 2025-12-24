package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import com.thejoa703.dto.CommentRequest;
import com.thejoa703.dto.CommentResponse;
import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.PostRequest;
import com.thejoa703.dto.PostResponse;
import com.thejoa703.dto.RefreshRequest;
import com.thejoa703.dto.SignupRequest;
import com.thejoa703.dto.TokenResponse;
import com.thejoa703.dto.UserResponse;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.service.AuthService;
import com.thejoa703.service.PostService;
import com.thejoa703.service.TokenService;
import com.thejoa703.service.UserService;

/**
 * Service 계층 통합 테스트 (Oracle 11g 환경)
 * - UserService, PostService, AuthService, TokenService 전체 커버
 * - provider 필드(local/social) 반영
 */
@SpringBootTest
class Project004ExApplicationTests2 {

    @Autowired private UserService userService;
    @Autowired private PostService postService;
    @Autowired private AuthService authService;
    @Autowired private TokenService tokenService;
    @Autowired private AppUserRepository appUserRepository;

    private Long userAId;
    private Long userBId;

    @BeforeEach
    void setup() {
        appUserRepository.deleteAll();

        // 🔹 사용자 A 회원가입 (local)
        SignupRequest signupA = new SignupRequest();
        signupA.setEmail("userA@test.com");
        signupA.setPassword("1234");
        signupA.setNickname("userA");
        signupA.setProvider("local"); // ✅ provider 지정
        userService.signup(signupA);
        userAId = appUserRepository.findByEmailAndProvider("userA@test.com", "local").orElseThrow().getId();

        // 🔹 사용자 B 회원가입 (local)
        SignupRequest signupB = new SignupRequest();
        signupB.setEmail("userB@test.com");
        signupB.setPassword("5678");
        signupB.setNickname("userB");
        signupB.setProvider("local"); // ✅ provider 지정
        userService.signup(signupB);
        userBId = appUserRepository.findByEmailAndProvider("userB@test.com", "local").orElseThrow().getId();

        // 🔹 소셜 사용자 회원가입 (google)
        SignupRequest signupSocial = new SignupRequest();
        signupSocial.setEmail("social@test.com");
        signupSocial.setPassword(null); // 소셜은 password 없음
        signupSocial.setNickname("socialUser");
        signupSocial.setProvider("google");
        userService.signup(signupSocial);
    }

    // ---- UserService ----
    @Test
    @DisplayName("회원가입 후 사용자 조회")
    void testSignupAndGetUser() {
        UserResponse response = userService.getUser(userAId);
        assertThat(response.getEmail()).isEqualTo("userA@test.com");
        assertThat(response.getNickname()).isEqualTo("userA");
    }

    @Test
    @DisplayName("닉네임 변경 및 중복 검증")
    void testUpdateNickname() {
        UserResponse updated = userService.updateNickname(userAId, "newNick");
        assertThat(updated.getNickname()).isEqualTo("newNick");

        assertThatThrownBy(() -> userService.updateNickname(userBId, "newNick"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("팔로우/언팔로우/차단")
    void testFollowUnfollowBlock() {
        userService.followUser(userAId, userBId);
        List<UserResponse> followings = userService.getFollowings(userAId);
        assertThat(followings).extracting(UserResponse::getNickname).contains("userB");

        userService.unfollowUser(userAId, userBId);
        assertThat(userService.getFollowings(userAId)).isEmpty();

        userService.followUser(userAId, userBId);
        userService.blockFollower(userBId, userAId);
        List<UserResponse> followers = userService.getFollowers(userBId);
        assertThat(followers).isEmpty();
    }

    @Test
    @DisplayName("자기 자신 팔로우 예외")
    void testFollowSelf() {
        assertThatThrownBy(() -> userService.followUser(userAId, userAId))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // ---- PostService ----
    @Test
    @DisplayName("게시글 작성/조회/페이징/해시태그 검색")
    void testPostAndHashtag() {
        PostRequest request = new PostRequest();
        request.setContent("Spring JPA 게시글");
        request.setHashtags(List.of("spring", "jpa"));
        PostResponse post = postService.createPost(userAId, request);

        List<PostResponse> page = postService.getPosts(1, 10);
        assertThat(page).isNotEmpty();

        List<PostResponse> byTag = postService.getPostsByHashtag("spring");
        assertThat(byTag).extracting(PostResponse::getContent).contains("Spring JPA 게시글");
    }

    @Test
    @DisplayName("게시글 수정/삭제")
    void testUpdateAndDeletePost() {
        PostRequest request = new PostRequest();
        request.setContent("원본 게시글");
        PostResponse created = postService.createPost(userAId, request);

        PostRequest updateReq = new PostRequest();
        updateReq.setContent("수정된 게시글");
        PostResponse updated = postService.updatePost(userAId, created.getId(), updateReq);
        assertThat(updated.getContent()).isEqualTo("수정된 게시글");

        postService.deletePost(userAId, created.getId());
        assertThatThrownBy(() -> postService.updatePost(userAId, created.getId(), updateReq))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("댓글 작성/수정/삭제")
    void testCommentCrud() {
        PostRequest request = new PostRequest();
        request.setContent("댓글 테스트 게시글");
        PostResponse post = postService.createPost(userAId, request);

        CommentRequest commentReq = new CommentRequest();
        commentReq.setContent("첫 댓글");
        CommentResponse comment = postService.addComment(userAId, post.getId(), commentReq);
        assertThat(comment.getContent()).isEqualTo("첫 댓글");

        commentReq.setContent("수정 댓글");
        CommentResponse updated = postService.updateComment(userAId, post.getId(), comment.getId(), commentReq);
        assertThat(updated.getContent()).isEqualTo("수정 댓글");

        postService.deleteComment(userAId, post.getId(), comment.getId());
        assertThatThrownBy(() -> postService.updateComment(userAId, post.getId(), comment.getId(), commentReq))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("좋아요/취소")
    void testLikeAndUnlike() {
        PostRequest request = new PostRequest();
        request.setContent("좋아요 테스트 게시글");
        PostResponse post = postService.createPost(userAId, request);

        postService.likePost(userAId, post.getId());
        postService.unlikePost(userAId, post.getId());
    }

    @Test
    @DisplayName("리트윗/취소")
    void testRetweetAndCancel() {
        PostRequest request = new PostRequest();
        request.setContent("리트윗 테스트 게시글");
        PostResponse post = postService.createPost(userAId, request);

        PostResponse rt = postService.retweet(userAId, post.getId());
        assertThat(rt.getContent()).contains("RT:");

        postService.cancelRetweet(userAId, post.getId());
    }

    

 // ---- AuthService & TokenService ----
    @Test
    @DisplayName("로그인/로그아웃/토큰 갱신/잘못된 토큰 예외")
    void testAuthFlow() {
        // 🔹 로그인 요청 (local)
        LoginRequest loginReq = new LoginRequest();
        loginReq.setEmail("userA@test.com");
        loginReq.setPassword("1234");
        loginReq.setProvider("local"); // ✅ provider 지정

        // 🔹 로그인 → 토큰 발급
        TokenResponse tokens = authService.login(loginReq);
        assertThat(tokens.getAccessToken()).isNotBlank();
        assertThat(tokens.getRefreshToken()).isNotBlank();

        // 🔹 Redis에 저장된 RefreshToken 확인
        String stored = tokenService.getRefreshToken(userAId.toString());
        assertThat(stored).isEqualTo(tokens.getRefreshToken());

        // 🔹 RefreshToken으로 새 AccessToken 발급
        RefreshRequest refreshReq = new RefreshRequest();
        refreshReq.setRefreshToken(tokens.getRefreshToken());
        TokenResponse refreshed = authService.refresh(refreshReq);
        assertThat(refreshed.getAccessToken()).isNotBlank();
        assertThat(refreshed.getRefreshToken()).isNotBlank();

        // 🔹 잘못된 RefreshToken 예외 검증
        RefreshRequest badReq = new RefreshRequest();
        badReq.setRefreshToken("malformed.or.expired.token");
        assertThatThrownBy(() -> authService.refresh(badReq))
                .isInstanceOf(ResponseStatusException.class)
                .hasMessageContaining("Invalid");

        // 🔹 로그아웃 → 반드시 최신 RefreshToken 사용
        authService.logout(userAId, refreshed.getRefreshToken());
        assertThat(tokenService.getRefreshToken(userAId.toString())).isNull();
    }

}