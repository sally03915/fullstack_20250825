package com.company.java005_ex_MiniProject_Bank;

import java.util.Scanner;

public class bank {

	private static final int Y = 0;

	public static void main(String[] args) {
		// 변수 int num
		int select = 0, age = 0, money = 0, input = 0;

		String id = "", pass = ""; 

		double balance = 0.0;

		String menu = "\n======BANK======\n* 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료\n입력 >>> ";

		Scanner sc = new Scanner(System.in);
		// 입력 + 처리+ 출력

		System.out.println("WELCOME! (주)CODEJOHNS BANK");


		

		for (;;) {
			
			System.out.print(menu); select = sc.nextInt();
			
			switch (select) {

			case 1:
				System.out.println("추가기능입니다.");System.out.print("아이디 입력: >");id = sc.next();
				System.out.print("비밀번호 입력: >");pass = sc.next();
				System.out.print("나이 입력 : >");age = sc.nextInt();
				System.out.print("잔액 입력 : >");balance = sc.nextDouble();
			break;
			
			case 2: case 3: case 4: case 5 :   {
				/////// 사용자정보인증
				String tempid, temppass;

				// 입력 2-1. 사용자에게 임시 아이디와 임시 비밀번호 입력받기
				System.out.print("아이디를 입력해주세요 >");
				tempid = sc.next();
				System.out.print("비밀번호를 입력해주세요 >");
				temppass = sc.next();

				// 2-2. 아이디와 임시아이디가 같아야하고 비번과 임시비밀번호가 같다면 사용자정보출력
				if (  !(tempid.equals(id) && pass.equals(temppass))) { 
					System.out.println("정보를 확인해주세요.");
					continue; 
				} 
				
				/////// 각번호에 맞는 처리 다시
				switch(select) {
					case 2 :  
						System.out.print("🧨🧨🧨🧨🧨🧨\n아이디 : " + id + "\n비밀번호 : " + pass);
						System.out.printf("\n나이 : %d\n잔액 : %.2f", age, balance);
					 break; 
					case 3 : 
					    System.out.println("입금하실 금액을 입력해주세요"); balance += sc.nextInt();
					    System.out.println("현재 잔액은 : " + balance + "입니다");  
					break; 
					case 4 :   
						 System.out.print("현재 잔액은 : "
								+ ""+balance+"원 입니다.\n출금하실 금액을 입력해주세요");
						 balance -= sc.nextDouble();
						 System.out.println("남은 금액은 : " + balance + "원 입니다."); 
					break;
			
					case 5:  
						System.out.println("정말로 삭제하겠습니까? (Y/N)"); 
						String delete = sc.next();
						if (delete.equals("Y") || delete.equals("y") ) { 
						id = "";
						pass= "";
						balance = 0.0;
						tempid = "";
						temppass = "";
						age = 0;
						delete = "N";
						System.out.println("삭제되었습니다.");}
						else if (delete.equals("n") || delete.equals("N")) 
						{System.out.println("취소되었습니다.");} 
					break;
				}
				
			} break;	
			case 9: {
				System.out.println("9을 입력하면 종료 입니다. 출력구문 까지만");
				break;

			}
			default:
				break;
			}
		} // end for
 
	}// end main

} // end class
