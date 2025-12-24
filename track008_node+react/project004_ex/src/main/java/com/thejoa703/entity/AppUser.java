package com.thejoa703.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
    name = "APPUSER",
    // 🔹 변경: unique 제약을 email 단독 → (email, provider) 복합 unique로 변경
    uniqueConstraints = @UniqueConstraint(
        name = "UK_APPUSER_EMAIL_PROVIDER",
        columnNames = {"email", "provider"}
    )
)
@Getter
@Setter
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_seq")
    @SequenceGenerator(
        name = "appuser_seq",
        sequenceName = "APPUSER_SEQ",
        allocationSize = 1
    )
    @Column(name = "app_user_id")
    private Long id;

    @Column(length = 120, nullable = false)
    private String email; // 🔹 변경: unique 속성 제거 (복합 unique로 이동)

    
    
    @Column(length = 200)
    private String password; // 🔹 변경: 소셜 로그인 계정은 password가 필요 없을 수 있어 nullable 허용
    
    @Column(length = 50, nullable = false)
    private String nickname;

    @Column(name = "mbti_type_id")
    private int mbtitype;

    private String ufile;
    private String mobile;

    // 🔹 추가: provider 필드 (local 기본값, 소셜 로그인 시 google/kakao/naver 등)
    @Column(nullable = false, name = "provider", length = 50)
    private String provider = "local";

    // 🔹 추가: 소셜 provider가 주는 고유 식별자 (sub/id 등)
    @Column(name = "provider_id")
    private String providerId;    
    
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;

    // 🔹 소프트 삭제 플래그
    @Column(nullable = true)
    private boolean deleted = false;

    // 🔹 권한(Role) 필드 추가
    @Column(nullable = false, length = 50)
    private String role = "ROLE_USER"; // 회원가입 시 기본값

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        if (this.role == null) {
            this.role = "ROLE_USER"; // 안전장치
        }
        if (this.provider == null) {
            this.provider = "local"; // 🔹 추가: provider 기본값 설정
        }
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // 관계 매핑
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostLike> likes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Retweet> retweets;

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Follow> followings;

    @OneToMany(mappedBy = "followee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Follow> followers;
}
