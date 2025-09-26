package com.company.java010_MiniProject_Bank;

import java.util.Scanner;

//1. 클래스는 부품객체
//2. 상태와 행위

public class Bank_Main {
	// 상태 : 멤버변수
	UserInfo userinfo; // 정보보관용도 - model - db
	Add      add; Show     show;
	Deposit  deposit; Withdraw withdraw; Delete   delete; Login    login;  //## 추가1
	
	// 행위 : 멤버함수 ( 초기화 ) 
	public Bank_Main() {
		this.userinfo = new UserInfo("","",0);  //##
		this.add      = new Add( this.userinfo );
		this.show     = new Show( this.userinfo );
		this.deposit  = new Deposit( this.userinfo );  // Q1. Deposit  deposit  입금기능   ## 추가2
		this.withdraw = new Withdraw( this.userinfo ); // Q2. Withdraw withdraw 출금기능
		this.delete   = new Delete( this.userinfo );   // Q3. Delete   delete   삭제기능
		this.login    = new Login(this.userinfo);      // Q4. Login    run 메서드안에 기능
	} 
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int num = -1;
		while(num != 9) {
			//System.out.println("Main :" + this.userinfo + "\t" +   System.identityHashCode(this.userinfo));
	    	System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\n" + 
	    		"\n[1] ➕ 계좌 추가" + "\n[2] 🔍 계좌 조회" + "\n[3] 💵 입금하기" + "\n[4] 💸 출금하기" + "\n[5] 🗑️ 계좌 삭제  "
	    		+"\n\n👉 번호를 선택하세요:");
	    	num=scanner.nextInt();
	    	switch(num) {
		    	case 1 : this.add.exec();  break;
		    	case 2: case  3: case 4: case 5:
		    		//1. 유저정보확인
		    		if(this.login.exec()==-1) { System.out.println("유저정보를 확인해주세요."); break; }
		    		//2. 각각의 처리
		    		switch(num) {
				    	case 2 : this.show.exec();  break;
				    	case 3 : this.deposit.exec();  break;   
				    	case 4 : this.withdraw.exec();  break;
				    	case 5 : this.delete.exec();  break;
		    		}
		    	break;	
	    	}
		}
	} 
	public static void main(String[] args) { Bank_Main  bank = new Bank_Main(); bank.run(); }
}
 
 