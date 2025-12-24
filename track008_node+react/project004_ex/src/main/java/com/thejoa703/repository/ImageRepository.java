package com.thejoa703.repository;

import com.thejoa703.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 이미지 엔티티(Image)용 Repository
 * - 기본 CRUD 제공
 */
public interface ImageRepository extends JpaRepository<Image, Long> {}
