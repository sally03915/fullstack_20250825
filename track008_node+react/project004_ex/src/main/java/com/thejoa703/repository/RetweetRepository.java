package com.thejoa703.repository;

import com.thejoa703.entity.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 리트윗 엔티티(Retweet)용 Repository
 * - 특정 사용자/게시글 리트윗 여부 확인
 */
public interface RetweetRepository extends JpaRepository<Retweet, Long> {
    Optional<Retweet> findByUserIdAndOriginalPostId(Long userId, Long postId); // 리트윗 여부 확인
}
