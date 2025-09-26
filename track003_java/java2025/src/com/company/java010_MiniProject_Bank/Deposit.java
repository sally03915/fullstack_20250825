package com.company.java010_MiniProject_Bank;

import java.util.Scanner;

//1. 클래스는 부품객체
//2. 상태와 행위
public class Deposit {
	//상태 : 멤버변수
	UserInfo userinfo;
	
	//행위 : 멤버함수
	public Deposit() { super(); } 
	public Deposit(UserInfo userinfo) { super(); this.userinfo = userinfo; }

	public void exec() {
		// setter / getter이용해서 사용자에게 입금받기  ###
		//변수
		Scanner scanner = new Scanner(System.in);
		//입력 - 사용자에게 입금할 금액입력받기
		System.out.print("입금할 금액을 입력해주세요 > "); 
		double balance = scanner.nextDouble();
		//처리 - setter를 이용해서 입금한 금액 셋팅하기
		this.userinfo.setBalance(  this.userinfo.getBalance() + balance  );
		//출력 - 입금이 완료되었습니다. 출력
		System.out.println("✅입금이 완료되었습니다.");
	}
}

/* 기능 : 사용자에게 입금받기
 */