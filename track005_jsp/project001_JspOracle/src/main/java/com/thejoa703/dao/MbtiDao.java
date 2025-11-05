package com.thejoa703.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.thejoa703.dto.MbtiDto;

public class MbtiDao {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott" , pass="tiger";
	
//	create :  
//	insert into mbtitype ( MBTI_TYPE_ID ,name,  description)  values ( mbtitype_seq.nextval , ?,?);
	public int insert(MbtiDto dto){
		int result = -1;
		String sql = "insert into mbtitype ( MBTI_TYPE_ID ,name,  description) "
				    + " values ( mbtitypeid_seq.nextval , ?,?)";
		Connection conn = null; PreparedStatement pstmt = null;  ResultSet rset = null;
		
		/////////////////////////
		try {
			//1. 드라이브연동 
			Class.forName(driver);
			//2. 커넥션 
			conn = DriverManager.getConnection(url, user, pass);
			//3. PreparedStatement
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getDescription());
			//4. 결과
			result = pstmt.executeUpdate();
			
		}catch(Exception e) { e.printStackTrace();
		}finally {
			if( rset  != null ) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( pstmt != null ) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( conn  != null ) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		/////////////////////////
		
		return result;
	}

//	read   :  
//	select * from mbtitype;        
	public ArrayList<MbtiDto> selectAll(){
	   ArrayList<MbtiDto> result = new ArrayList<MbtiDto>();
	   String sql = "select * from mbtitype";
	   Connection conn = null; PreparedStatement pstmt = null;  ResultSet rset = null;
		/////////////////////////
		try {
			//1. 드라이브연동 
			Class.forName(driver);
			//2. 커넥션 
			conn = DriverManager.getConnection(url, user,pass);
			//3. PreparedStatement
			pstmt = conn.prepareStatement(sql);
			//4. 결과
			rset = pstmt.executeQuery();
			while(rset.next()) { //int mbtiTypeId, String name, String description
				result.add(new MbtiDto( 
						rset.getInt("mbti_type_id") ,  
						rset.getString("name") , 
						rset.getString("description")));
			}
			
		}catch(Exception e) { e.printStackTrace();
		}finally {
			if( rset  != null ) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( pstmt != null ) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( conn  != null ) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		/////////////////////////
	   
	   return result;
	}
    
    
//    select * from mbtitype  where MBTI_TYPE_ID =?;
    public  MbtiDto select(int id){
    	MbtiDto result = new MbtiDto();
		Connection conn = null; PreparedStatement pstmt = null;  ResultSet rset = null;
		String sql = "select * from mbtitype  where MBTI_TYPE_ID =?";
		/////////////////////////
		try {
			//1. 드라이브연동 
			Class.forName(driver);
			//2. 커넥션 
			conn = DriverManager.getConnection(url, user,pass);
			//3. PreparedStatement
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1 , id);
			//4. 결과
			rset = pstmt.executeQuery();
			while(rset.next()) { //int mbtiTypeId, String name, String description
				result = new MbtiDto( rset.getInt("mbti_type_id") ,  rset.getString("name") , rset.getString("description"));
			}
		}catch(Exception e) { e.printStackTrace();
		}finally {
			if( rset  != null ) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( pstmt != null ) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( conn  != null ) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		/////////////////////////
    	
    	return result;
    }       
            
            
//update : update mbtitype   set name=?,  description=? where MBTI_TYPE_ID =?;  
	public int update(MbtiDto dto){
		int result = -1;
		String sql = "update mbtitype   set name=?,  description=? where MBTI_TYPE_ID =?";
		Connection conn = null; PreparedStatement pstmt = null;  ResultSet rset = null;
		/////////////////////////
		try {
			//1. 드라이브연동 
			Class.forName(driver);
			//2. 커넥션 
			conn = DriverManager.getConnection(url, user,pass);
			//3. PreparedStatement
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getDescription());
			pstmt.setInt(   3, dto.getMbtiTypeId());
			//4. 결과
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e) { e.printStackTrace();
		}finally {
			if( rset  != null ) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( pstmt != null ) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( conn  != null ) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		/////////////////////////
		
		return result;
	}

//delete  : 
//	delete  from  mbtitype   where MBTI_TYPE_ID =?;  
	public int delete(int id){
		int result = -1;
		String sql = "delete  from  mbtitype   where MBTI_TYPE_ID =?";
		Connection conn = null; PreparedStatement pstmt = null;  ResultSet rset = null;
		/////////////////////////
		try {
			//1. 드라이브연동 
			Class.forName(driver);
			//2. 커넥션 
			conn = DriverManager.getConnection(url, user,pass);
			//3. PreparedStatement
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(   1, id);
			//4. 결과
			result = pstmt.executeUpdate();
			
		}catch(Exception e) { e.printStackTrace();
		}finally {
			if( rset  != null ) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( pstmt != null ) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( conn  != null ) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		/////////////////////////
		
		return result;
	}

}


/*  insert/update/delete  -1/1  executeUpdate  , select - executeQuery 
 
create :  
	insert into mbtitype ( MBTI_TYPE_ID ,name,  description)  values ( mbtitype_seq.nextval , ?,?);
	public int insert(MbtiDto dto){
		int result = -1;
		String sql = "insert into mbtitype ( MBTI_TYPE_ID ,name,  description)  values ( mbtitype_seq.nextval , ?,?)";
		return result;
	}

read   :  
	select * from mbtitype;        
	public ArrayList<MbtiDto> selectAll(){
	   ArrayList<MbtiDto> result = new ArrayList<MbtiDto>();
	   String sql = "select * from mbtitype";
	   return result;
	}
    
    
    select * from mbtitype  where MBTI_TYPE_ID =?;
    public  MbtiDto select(int id){
    	MbtiDto result = new MbtiDto();
    	return result;
    }       
            
            
update : update mbtitype   set name=?,  description=? where MBTI_TYPE_ID =?;  
	public int update(MbtiDto dto){
		int result = -1;
		String sql = "update mbtitype   set name=?,  description=? where MBTI_TYPE_ID =?";
		return result;
	}

delete  : 
	delete  from  mbtitype   where MBTI_TYPE_ID =?;  
	public int delete(int id){
		int result = -1;
		String sql = "delete  from  mbtitype   where MBTI_TYPE_ID =?";
		return result;
	}

*/