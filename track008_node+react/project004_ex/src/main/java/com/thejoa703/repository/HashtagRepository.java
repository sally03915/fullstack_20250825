package com.thejoa703.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thejoa703.entity.Hashtag;

/**
 * 해시태그 엔티티(Hashtag)용 Repository
 * - 해시태그 이름으로 조회 기능 제공
 */
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
	
    Optional<Hashtag> findByName(String name);
	
    @Query("SELECT h FROM Hashtag h JOIN FETCH h.posts WHERE h.name = :name")
    Optional<Hashtag> findByNameWithPosts(@Param("name") String name);
}
