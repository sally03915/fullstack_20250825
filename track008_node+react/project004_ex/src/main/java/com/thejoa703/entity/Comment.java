package com.thejoa703.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 댓글 엔티티
 */
@Entity
@Table(name = "COMMENTS")
@Getter @Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    @SequenceGenerator(name = "comment_seq", sequenceName = "COMMENT_SEQ", allocationSize = 1)
    private Long id;

    @Column(columnDefinition = "CLOB", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "APP_USER_ID", nullable = false)
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "POST_ID", nullable = false)
    private Post post;

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
