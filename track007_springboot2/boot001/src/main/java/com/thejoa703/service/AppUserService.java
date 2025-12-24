package com.thejoa703.service;

import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AppUserDto;

public interface AppUserService {

    /** 회원가입 */
    int insert(MultipartFile file, AppUserDto dto);

    /** 회원정보 수정 */
    int update(MultipartFile file, AppUserDto dto);

    /** 회원 탈퇴 
     * @param dto 사용자 정보
     * @param requirePasswordCheck local 계정일 경우 true, 소셜 계정일 경우 false
     */
    int delete(AppUserDto dto, boolean requirePasswordCheck);

    /** 권한 조회 */
    AppUserAuthDto readAuth(String email, String provider);

    /** 이메일/프로바이더로 사용자 조회 */
    AppUserDto selectEmail(String email, String provider);

    /** 중복 체크 */
    int iddouble(String email, String provider);

    /** 비밀번호 검증 */
    boolean matchesPassword(String email, String provider, String rawPassword);
}
