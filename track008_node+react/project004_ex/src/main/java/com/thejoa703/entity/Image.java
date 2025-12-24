package com.thejoa703.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 이미지 엔티티
 */
@Entity
@Table(name = "IMAGES")
@Getter @Setter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
    @SequenceGenerator(name = "image_seq", sequenceName = "IMAGE_SEQ", allocationSize = 1)
    private Long id;

    @Column(length = 200, nullable = false)
    private String src;

    @ManyToOne
    @JoinColumn(name = "POST_ID", nullable = false)
    private Post post;
}
