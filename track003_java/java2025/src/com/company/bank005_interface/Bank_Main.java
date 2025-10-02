package com.company.bank005_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank_Main {
	//멤버변수
	private List<UserInfo>  users;  // add, get, size, remove, contains
	private BankController [] controller;
	
	// 생성자 - 멤버변수를 초기화해서 사용가능하게
	public Bank_Main() { 
		users      = new ArrayList<>(); 
		controller = new BankController[]{
			new Login() , new Add(), new Show(),   new Deposit() ,new WithDraw(), new Delete()
		};  //0                1          2           3                 4            5
	}
	//멤버함수 (메뉴판)
	public void menu() {
		//변수
		Scanner scanner =new Scanner(System.in);
		int num=-1; 
		//입력 + 처리 
		//1.메뉴판 무한반복 - 입력
		//2.메뉴가 1 - 사용자추가 Add()   controller[1].exec(users);  
		//3.메뉴가 2,3,4,5 - 로그인한 후에 Login()   controller[0].exec(users);  
		//		각각의 기능 2 Show(),   		3 Deposit() ,       4  WithDraw(), 5  Delete()
		//  controller[2].exec(users);  controller[3].exec(users);
		while(num!=9) {
			System.out.println(  users  );  // 테스트용도
			System.out.print("🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
					+ "[1] ➕ 계좌 추가\r\n" + "[2] 🔍 계좌 조회\r\n" + "[3] 💵 입금하기\r\n" + "[4] 💸 출금하기\r\n" + "[5] 🗑️ 계좌 삭제  \r\n" + "\r\n"
					+ "👉 번호를 선택하세요:");
			num = scanner.nextInt(); 
			int find=1;  // 찾은 유저번호 or 0 로그인 or 1 계좌추가
			// add, get(유저번호), size, remove(유저번호), contains()
			// Add     : users.add(   new  UserInfo("id","pw",1) );	
			// Show    : users.get(유저번호)	
			// Deposit : users.get(유저번호)
			//1.  parameter  - 넘겨받아야할 데이터 users,  유저번호 
			//2.  리턴값       - 위의 사용방법에서 show, deposit부분등에서 유저번호가 필요한데....... 
			//				    로그인시 찾은 유저의 번호를 넘겨주려고.
			//3.   int (찾은 유저번호)   exec(users, index);
 			if(num >=2 && num <=5) {  
 				find =controller[0].exec(users , 0 );
 				if(find == -1) {System.out.println("유저정보를 확인해주세요~!"); continue;}
 			}
 			controller[num].exec(users , find);  // 찾은 유저번호 or 0 로그인 or 1 계좌추가
		}
	}
	public static void main(String[] args) {  new Bank_Main().menu();  }
}
/*
	while( 9가 아니라면 계속하기 ){
		// 메뉴판출력
		if( 입력받은 번호가 1번이면 ){유저추가}  controller[1].exec(users); 
		else {입력받은 번호가  2,3,4,5 번이면
			1) Login처리                controller[0].exec(users); 
			2) 2,3,4,5 각각에서 처리해야할일
			switch(번호 ){
				2라면 : 조회처리 break    controller[2].exec(users); 
				3라면 : 입금처리 break    controller[3].exec(users);  
				4라면 : 출금리 break      controller[4].exec(users); 
				5라면 : 삭제처리 break    controller[5].exec(users); 
			}
		} 
	} 
*/
/*

🌟💰 WELCOME TO BANK SYSTEM 💰🌟
[1] ➕ 계좌 추가
[2] 🔍 계좌 조회
[3] 💵 입금하기
[4] 💸 출금하기
[5] 🗑️ 계좌 삭제  

👉 번호를 선택하세요:

Q1. 무한반복 + 각번호 입력받으면 ~ 기능입니다 출력    ㅠㅠ

Q2. 입력받은 번호가 1번이면 유저추가
Q3. 입력받은 번호가  2,3,4,5 이면
*/