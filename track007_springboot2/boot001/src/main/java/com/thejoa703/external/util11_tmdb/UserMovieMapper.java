//package com.company.project001.tmdb;
//import com.company.project001.domain.User;
//import com.company.project001.domain.Movie;
//import org.apache.ibatis.annotations.Mapper;
//
//import java.util.List;
//import java.util.Map;
//
//@Mapper
//public interface UserMovieMapper {
//
//    // 🔐 기능 1: 회원가입
//    void insertUser(User user);
//
//    // 🔑 기능 2: 로그인
//    User login(Map<String, String> map);
//
//    // 🔎 기능 3: 비밀번호 찾기
//    User verifyUserInfoForReset(Map<String, Object> map);
//
//    // 🛠 기능 4: 비밀번호 변경
//    void updatePassword(Map<String, String> map);
//
//    // ✳️ 추가: username 기반 유저 찾기
//    User findByUsername(String username);
//
//    // 🎬 기능 5-1: 영화 저장
//    void insertMovie(Movie movie);
//
//    // 🎬 기능 5-2: 영화 조회 (유저별)
//    List<Movie> findMoviesByUserId(Long userId);
//    
//    public void updateMbti(Map<String, Object> map);
//    
//    // 📦 생년월일 + 나이 같이 조회
//    Map<String, Object> findByUsernameWithAge(String username);
//}
