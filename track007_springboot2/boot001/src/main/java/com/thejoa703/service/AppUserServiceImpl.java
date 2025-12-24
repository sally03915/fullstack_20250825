package com.thejoa703.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AppUserDto;
import com.thejoa703.dto.AuthDto;
import com.thejoa703.util.UtilUpload;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired private AppUserDao userDao;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private UtilUpload utilUpload;

    /** 파일 업로드 처리 (공통) */
    private String uploadFile(MultipartFile file, String existingFile) {
        if (file != null && !file.isEmpty()) {
            try {
                return utilUpload.fileUpload(file);
            } catch (IOException e) {
                throw new RuntimeException("파일 업로드 실패", e);
            }
        }
        return existingFile;
    }

    /** 회원가입 */
    @Transactional
    @Override
    public int insert(MultipartFile file, AppUserDto dto) {
        dto.setProvider("local");
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        dto.setUfile(uploadFile(file, null));

        if (userDao.iddoubleByEmail(dto) > 0) {
            throw new IllegalStateException("이미 존재하는 계정입니다.");
        }

        int result = userDao.insertAppUser(dto);
        if (result > 0) {
            userDao.insertAuth(new AuthDto(dto.getEmail(), "ROLE_USER"));
        }
        return result;
    }

    /** 회원정보 수정 */
    @Transactional
    @Override
    public int update(MultipartFile file, AppUserDto dto) {
        dto.setProvider("local");
        AppUserDto dbUser = userDao.findByEmail(dto);
        if (dbUser == null) return 0;

        if (!passwordEncoder.matches(dto.getPassword(), dbUser.getPassword())) return 0;

        dto.setAppUserId(dbUser.getAppUserId());
        dto.setUfile(uploadFile(file, dbUser.getUfile()));
        dto.setNickname(dto.getNickname() == null ? dbUser.getNickname() : dto.getNickname());
        dto.setMobile(dto.getMobile() == null ? dbUser.getMobile() : dto.getMobile());
        dto.setPassword(dbUser.getPassword());

        return userDao.updateAppUser(dto);
    }

    /** 회원 탈퇴 */
    @Transactional
    @Override
    public int delete(AppUserDto dto, boolean requirePasswordCheck) {
        AppUserDto dbUser = userDao.findByEmail(dto);
        if (dbUser == null) return 0;

        if (requirePasswordCheck) {
            if (dto.getPassword() == null || !passwordEncoder.matches(dto.getPassword(), dbUser.getPassword())) {
                return 0;
            }
        }

        dto.setAppUserId(dbUser.getAppUserId());
        userDao.deleteAuth(new AuthDto(dto.getEmail(), "ROLE_USER"));
        return userDao.deleteAppUser(dto);
    }

    /** 권한 조회 */
    @Override
    public AppUserAuthDto readAuth(String email, String provider) {
        return userDao.readAuthByEmail(new AppUserDto(email, provider));
    }

    @Override
    public AppUserDto selectEmail(String email, String provider) {
        return userDao.findByEmail(new AppUserDto(email, provider));
    }

    @Override
    public int iddouble(String email, String provider) {
        return userDao.iddoubleByEmail(new AppUserDto(email, provider));
    }

    @Override
    public boolean matchesPassword(String email, String provider, String rawPassword) {
        AppUserDto dbUser = userDao.findByEmail(new AppUserDto(email, provider));
        return dbUser != null && dbUser.getPassword() != null &&
               passwordEncoder.matches(rawPassword, dbUser.getPassword());
    }
}
