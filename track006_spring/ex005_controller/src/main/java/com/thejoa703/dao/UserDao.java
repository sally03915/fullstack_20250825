package com.thejoa703.dao;

import java.util.List;
import com.thejoa703.dto.UserVO;
 
@MyDao
public interface UserDao {
	public  int     insert(UserVO vo);
	public  UserVO  select(    int no );
	public  List<UserVO>  selectAll( );
	public  int     update(UserVO vo);
	public  int     delete(  int no );
}
