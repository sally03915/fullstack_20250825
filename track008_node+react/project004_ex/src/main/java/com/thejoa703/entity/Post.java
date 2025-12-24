package com.thejoa703.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 게시글 엔티티
 */
@Entity
@Table(name = "POSTS")
@Getter @Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    @SequenceGenerator(name = "post_seq", sequenceName = "POST_SEQ", allocationSize = 1)
    private Long id;

    @Column(columnDefinition = "CLOB", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "APP_USER_ID", nullable = false)
    private AppUser user;

    /** 게시글에 연결된 이미지 목록 (가변 리스트로 초기화) */
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    /** 게시글에 연결된 댓글 목록 (가변 리스트로 초기화) */
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    /** 게시글에 연결된 해시태그 목록 (가변 리스트로 초기화) */
    @ManyToMany
    @JoinTable(
        name = "POST_HASHTAG",
        joinColumns = @JoinColumn(name = "POST_ID"),
        inverseJoinColumns = @JoinColumn(name = "HASHTAG_ID")
    )
    private List<Hashtag> hashtags = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean deleted = false;

    @PrePersist
    void onCreate() { this.createdAt = LocalDateTime.now(); }

    @PreUpdate
    void onUpdate() { this.updatedAt = LocalDateTime.now(); }
}
