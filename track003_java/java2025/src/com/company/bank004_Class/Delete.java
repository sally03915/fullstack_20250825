package com.company.bank004_Class;

import java.util.Scanner;

public class Delete {
	//상태 : 멤버변수
	UserInfo userinfo;
	
	//행위 : 멤버함수
	public Delete() { super(); } 
	public Delete(UserInfo userinfo) { super(); this.userinfo = userinfo; }

	public void exec() {

		Scanner scanner = new Scanner(System.in);
		// setter / getter이용해서 유저정보삭제, 초기화  ###
		// setter / getter이용해서 사용자에게 출금받기  ### 
		//변수
		//입력 -  
		//처리 - setter를 이용해서 이름null , 비번null, 잔액0 으로 
		//출력 - 정보를 삭제했습니다 출력
		this.userinfo.setId("");
		this.userinfo.setPass("");
		this.userinfo.setBalance(0);
		System.out.println("유저정보가 삭제 되었습니다. ");
	}
}

/* 기능 : 유저정보삭제, 초기화
 */