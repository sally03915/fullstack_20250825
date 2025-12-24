package com.thejoa703.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 좋아요 엔티티
 */
@Entity
@Table(
    name = "POST_LIKES",
    uniqueConstraints = @UniqueConstraint(columnNames = {"APP_USER_ID", "POST_ID"})
)
@Getter @Setter
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_like_seq")
    @SequenceGenerator(name = "post_like_seq", sequenceName = "POST_LIKE_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "APP_USER_ID", nullable = false)
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "POST_ID", nullable = false)
    private Post post;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() { this.createdAt = LocalDateTime.now(); }
}
