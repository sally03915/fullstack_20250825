package com.company.bank004_Class;

import java.util.Scanner;

public class Withdraw {
	//상태 : 멤버변수
	UserInfo userinfo;
	
	//행위 : 멤버함수
	public Withdraw() { super(); } 
	public Withdraw(UserInfo userinfo) { super(); this.userinfo = userinfo; }

	public void exec() {

		Scanner scanner = new Scanner(System.in);
		// setter / getter이용해서 사용자에게 출금받기  ### 
		//변수
		//입력 - 사용자에게 출금할 금액입력받기
		//처리 - setter를 이용해서 출금한 금액 셋팅하기
		//출력 - 출금이 완료되었습니다. 출력
		System.out.print("출금할 금액 > ");  double output = scanner.nextDouble();
		this.userinfo.setBalance(this.userinfo.getBalance() - output);  
		System.out.println("출금을 완료했습니다.");
	}
}

/* 기능 : 사용자에게 출금받기
 */