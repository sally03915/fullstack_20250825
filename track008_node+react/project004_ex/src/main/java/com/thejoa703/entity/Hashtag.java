package com.thejoa703.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 해시태그 엔티티
 */
@Entity
@Table(name = "HASHTAGS")
@Getter @Setter
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hashtag_seq")
    @SequenceGenerator(name = "hashtag_seq", sequenceName = "HASHTAG_SEQ", allocationSize = 1)
    private Long id;

    @Column(length = 200, nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "hashtags")
    private List<Post> posts;
}
