package spring004_db;

import javax.sql.DataSource;  //##

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.TestDao;
import com.thejoa703.dao.UserInfoDao;
import com.thejoa703.dto.UserInfoDto;

@RunWith(SpringJUnit4ClassRunner.class)  //1. spring 구동테스트
@ContextConfiguration(locations = "classpath:config/root-context.xml")  //2. 설정
public class Test1 {

	@Autowired ApplicationContext context;   //3. Bean (스프링이 관리하는 객체) 생성~소멸
	@Autowired DataSource  datasource;
	@Autowired SqlSession  sqlSession;
	@Autowired  TestDao dao;
	@Autowired  UserInfoDao  userdao;
	
	@Test  
	public void test5(){	
		//5. 삭제
		System.out.println(userdao.delete(2));
		//4. 수정
//		UserInfoDto dto = new UserInfoDto();
//		dto.setEmail("b@b");  dto.setAge(2);   dto.setNo(2);
//		System.out.println(userdao.update(dto));
		//3. 한명검색
		System.out.println(userdao.select(2));
		//2. 삽입
//		UserInfoDto dto = new UserInfoDto();
//		dto.setEmail("a@a");  dto.setAge(1);
//		System.out.println(userdao.insert(dto));
		//1. 전체검색
//		System.out.println(userdao.selectAll());   
	}
	
	
	
	@Ignore   //@Test  
	public void test1(){  System.out.println(context);   }
	@Ignore   //@Test    
	public void test2(){  System.out.println(datasource);   }  // datasource  (connection)
	@Ignore   //@Test     
	public void test3(){  System.out.println(sqlSession);   }  	// 실제 crud
	@Ignore   //@Test  
	public void test4(){  System.out.println(dao.now());   }
}
