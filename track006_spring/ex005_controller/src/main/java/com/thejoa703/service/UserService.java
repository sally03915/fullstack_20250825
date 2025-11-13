package com.thejoa703.service;

import java.util.List;
import com.thejoa703.dto.UserVO;
 
public interface UserService {
	public  int     insert(UserVO vo);
	public  UserVO  read(    int no );
	public  List<UserVO>  readAll( );
	public  int     update(UserVO vo);
	public  int     delete(  int no );
}
