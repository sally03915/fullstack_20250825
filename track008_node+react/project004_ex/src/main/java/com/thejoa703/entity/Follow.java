package com.thejoa703.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 팔로우 관계 엔티티
 */
@Entity
@Table(
    name = "FOLLOWS",
    uniqueConstraints = @UniqueConstraint(columnNames = {"FOLLOWER_ID", "FOLLOWEE_ID"})
)
@Getter @Setter
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follow_seq")
    @SequenceGenerator(name = "follow_seq", sequenceName = "FOLLOW_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FOLLOWER_ID", nullable = false)
    private AppUser follower;

    @ManyToOne
    @JoinColumn(name = "FOLLOWEE_ID", nullable = false)
    private AppUser followee;

    @Column(nullable = false)
    private boolean blocked = false;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() { this.createdAt = LocalDateTime.now(); }
}
