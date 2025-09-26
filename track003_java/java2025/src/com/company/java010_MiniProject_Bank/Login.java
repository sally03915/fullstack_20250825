package com.company.java010_MiniProject_Bank;

import java.util.Scanner;

public class Login {
	//상태 : 멤버변수
	UserInfo userinfo;
	
	//행위 : 멤버함수
	public Login() { super(); } 
	public Login(UserInfo userinfo) { super(); this.userinfo = userinfo; }

	public int exec() {
		// setter / getter이용해서  유저정보 확인
		//변수   
		Scanner scanner = new Scanner(System.in);
		//입력 - 사용자에게 아이디입력받기 / 비밀번호 입력받기
		System.out.print("[1]아이디입력 > ");    String tempid = scanner.next();
		System.out.print("[2]비밀번호입력 > ");  String temppass = scanner.next();
		//처리 - 
		// 입력한 아이디와 userinfo.id가 같고 입력한 비밀번호와 userinfo.pass가 같다면     찾으면 1
		//출력 - 
		return  tempid.equals(     this.userinfo.getId()  ) &&
				temppass.equals( this.userinfo.getPass()  )       ?  1: -1  ;
	}
}
 
/* 기능 : 유저정보 확인 */ 