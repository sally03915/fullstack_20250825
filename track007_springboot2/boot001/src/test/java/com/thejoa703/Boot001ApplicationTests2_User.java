package com.thejoa703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AppUserDto;
import com.thejoa703.dto.AuthDto;
import com.thejoa703.service.AppUserService;


@SpringBootTest 
class Boot001ApplicationTests2_User {

	  @Autowired private AppUserDao         dao;
	  @Autowired private AppUserService    service;

	  @Disabled @Test
	  void testCrudAppUserService() throws Exception {
	      String email = UUID.randomUUID().toString() + "@test.com";

	      AppUserDto user = new AppUserDto();
	      user.setEmail(email);
	      user.setPassword("pw123");
	      user.setMobile("01012345678");
	      user.setNickname("nickname");
	      user.setProvider("local");
	      user.setProviderId("local_" + UUID.randomUUID());

	      MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "data".getBytes());

	      int insertResult = service.insert(file, user);
	      assertEquals(1, insertResult);
/////////////////////////
	      AppUserAuthDto authDto = service.readAuth(email, "local");
	      assertNotNull(authDto);
	      assertEquals(email, authDto.getEmail());
	      assertTrue(authDto.getAuthList().stream().anyMatch(a -> "ROLE_USER".equals(a.getAuth())));
 
	      AppUserDto dbUser = service.selectEmail(email, "local");
	      assertNotNull(dbUser);
	      assertEquals("nickname", dbUser.getNickname());
/////////////////////////
	      AppUserDto updateDto = new AppUserDto();
	      updateDto.setEmail(email);
	      updateDto.setPassword("pw123");
	      updateDto.setNickname("newNickname");
	      updateDto.setProvider("local");

	      int updateResult = service.update(null, updateDto);
	      assertEquals(1, updateResult);

	      AppUserDto updatedUser = service.selectEmail(email, "local");
	      assertEquals("newNickname", updatedUser.getNickname());

	      
	      AppUserDto deleteDto = new AppUserDto();
	      deleteDto.setEmail(email);
	      deleteDto.setPassword("pw123");
	      deleteDto.setProvider("local");

          int deleteResult = service.delete(deleteDto, true);
          assertEquals(1, deleteResult);
          assertNull(service.selectEmail(email, "local"));
	  }


  @Disabled @Test
    void testCrudAppUserAuth() {
        // 1. 회원가입
		 AppUserDto  user = new AppUserDto();
		 user.setEmail("1@1");   user.setPassword("1");  user.setMbtiTypeId(1);
		 user.setUfile("1.png"); user.setMobile("01011");user.setProvider("local");
		 user.setProviderId("local_001");
		 int result    = dao.insertAppUser(user); 
		 System.out.println("....... 1. " + result );   // 수동확인
        assertEquals(1, result); // 회원가입 성공 확인 (자동확인)

		 //2.        - 권한입력
		 AuthDto  auth  =  new AuthDto();
		 auth.setEmail("1@1");
		 auth.setAuth("ROLE_USER");
		 int result_auth    = dao.insertAuth(auth);
		 System.out.println("....... 2. " + result_auth ); 
        assertEquals(1, result_auth); // 권한 입력 성공 확인

        // 3. 로그인 (권한 조회) 
		 AppUserDto  login = new AppUserDto();
		 login.setEmail("1@1");  login.setProvider("local");
		 System.out.println("....... 3. " + dao.readAuthByEmail(login) ); 
        assertNotNull(dao.readAuthByEmail(login)); // 권한 조회 성공 확인

		 //4. 아이디중복
		 AppUserDto  iddouble = new AppUserDto();
		 iddouble.setEmail("1@1");  iddouble.setProvider("local");
		 System.out.println("....... 4. " + dao.iddoubleByEmail(iddouble) ); 
        assertTrue(dao.iddoubleByEmail(iddouble) > 0); // 중복 확인 성공

		 //5. 마이페이지
		 AppUserDto  mypage = new AppUserDto();
		 mypage.setEmail("1@1");  mypage.setProvider("local");
		 AppUserDto  findUser = dao.findByEmail(mypage);
		 int         id       = findUser.getAppUserId();
		 System.out.println("....... 5. " + findUser ); 
	     assertNotNull(findUser); // 사용자 조회 성공

		 //6. 수정
		 AppUserDto  update = new AppUserDto(); 
		 update.setNickname("nickname001");  update.setAppUserId(id);  
		 int  updateResult = dao.updateAppUser(update);
		 System.out.println("....... 6. " +  updateResult); 
        assertEquals(1, updateResult); // 수정 성공 확인

        AppUserDto updatedUser = dao.findByEmail(mypage);
        assertEquals("nickname001", updatedUser.getNickname()); // 닉네임 변경 확인

        // 7. 사용자삭제 
		 AppUserDto  delete = new AppUserDto();   delete.setAppUserId(id);   
        int deleteResult = dao.deleteAppUser(delete);
		 System.out.println("....... 7. " + deleteResult ); 
        assertEquals(1, deleteResult); // 삭제 성공 확인
        assertNull(dao.findByEmail(mypage)); // 삭제 후 조회 불가 확인

        // 8. 권한삭제
		 AuthDto    dauth = new AuthDto();   dauth.setEmail("1@1");
        int deleteAuthResult = dao.deleteAuth(dauth);
		 System.out.println("....... 8. " +  deleteAuthResult );   //1
        assertEquals(1, deleteAuthResult); // 권한 삭제 성공 확인
    }
}