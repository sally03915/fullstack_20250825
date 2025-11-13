package ex004_db;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.UserDao;
import com.thejoa703.dto.UserVO;
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/root-context.xml")
public class Test3_UserDao {
	@Autowired  ApplicationContext context;
	@Autowired  UserDao dao;
	
	@Test   @Ignore 
	public void test0() { System.out.println(context); } 
	
	@Test  //@Ignore 
	public void test1() {
		//ver-2-  insert
		//		UserVO vo = new UserVO();
		//		vo.setEmail("2@2"); vo.setPassword("22"); vo.setMbtiTypeId(1);
		//		dao.insert(vo);
		//ver-3   read
		//dao.select(41);		
		//ver-4   update
		//		UserVO vo = new UserVO();
		//		vo.setEmail("2@2");  vo.setMbtiTypeId(2); vo.setAppUserId(41);
		//		System.out.println(dao.update(vo)); 
		//ver-5 
		//System.out.println(dao.delete(41)); 
		//test1-  readAll
		for(UserVO u : dao.selectAll()) { System.out.println(u); }
	}
}
