package com.thejoa703.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thejoa703.dao.UserDao;
import com.thejoa703.dto.UserVO;
 

@Service("userService")
public class UserServiceImple  implements UserService{
	@Autowired  UserDao dao;

	@Override public int insert(UserVO vo) { return dao.insert(vo); }
	@Override public UserVO read(int no) { return dao.select(no); }
	@Override public List<UserVO> readAll() { return dao.selectAll(); }
	@Override public int update(UserVO vo) { return dao.update(vo); }
	@Override public int delete(int no) { return dao.delete(no); }
	
}
