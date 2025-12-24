package com.thejoa703.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.AppUser;

/**
 * 사용자 엔티티(AppUser)용 Repository
 * - 기본 CRUD 제공
 * - 이메일로 사용자 조회 기능 포함
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    // 🔹 local 계정 전용 조회 (provider = "local"일 때만 사용)
    Optional<AppUser> findByEmail(String email);

    // 🔹 변경/추가: email + provider로 사용자 조회
    Optional<AppUser> findByEmailAndProvider(String email, String provider);

    // 🔹 닉네임 중복 검증
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM AppUser u WHERE u.nickname = :nickname")
    boolean existsByNickname(@Param("nickname") String nickname);
}
