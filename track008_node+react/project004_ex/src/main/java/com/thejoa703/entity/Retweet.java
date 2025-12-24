package com.thejoa703.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 리트윗 엔티티 - 특정 사용자가 특정 게시글을 리트윗한 기록
 */
@Entity
@Table(
    name = "RETWEETS",
    uniqueConstraints = @UniqueConstraint(
        name = "UK_RETWEET_USER_ORIG",
        columnNames = {"APP_USER_ID", "ORIGINAL_POST_ID"}
    )
)
@Getter @Setter
public class Retweet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "retweet_seq")
    @SequenceGenerator(name = "retweet_seq", sequenceName = "RETWEET_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "APP_USER_ID", nullable = false) // 리트윗한 사용자
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "ORIGINAL_POST_ID", nullable = false) // 원본 게시글
    private Post originalPost;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() { this.createdAt = LocalDateTime.now(); }
}
