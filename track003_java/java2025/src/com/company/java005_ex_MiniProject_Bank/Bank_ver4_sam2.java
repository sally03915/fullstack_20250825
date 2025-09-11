package com.company.java005_ex_MiniProject_Bank;

import java.util.Scanner;

public class Bank_ver4_sam2 {
	public static void main(String[] args) {

		// 변수
		Scanner scanner = new Scanner(System.in);
		int num = -1;
		String id = "", pass = "";
		int balance = 0;
		int money = 0;
		String tempid = "";
		String temppass = "";

		/*
			for(;;){
				if(9라면){빠져나올조건}
				else if(1이라면){ 사용자에게 정보 입력받기 }
				else if(2이라면,3,4,5){ 
				
					1. 사용자 정보조회
					2. 각파트별 처리
					     if(2라면){해야할처리 }
					else if(3라면){해야할처리 }
					else if(4라면){해야할처리 }
					else if(5라면){해야할처리 }
					
				}// end if
			}// end for

		 */
		
		// 입력+처리+출력
		// 1-1
		for (;;) {
			System.out.println("====== BANK ======\n*" + "1.추가\n*2.조회\n*3.입금\n*4.출금\n*5.삭제\n*9.종료\n*입력>>>");
			num = scanner.nextInt();

			if (num == 9) {
				System.out.println("ATM 종료");
				break;
			} else if (num == 1) {
				if (id.equals(tempid) && pass.equals(temppass))
					;
				System.out.println("추가");
				System.out.println("id입력 >");
				id = scanner.next();
				System.out.println("pass입력 >");
				pass = scanner.next();
				System.out.println("잔액입력 >");
				balance = scanner.nextInt();

			} else if (num == 2 || num == 3 || num == 4 || num == 5) {
				//1. 사용자 정보조회
				System.out.println("id 입력");
				tempid = scanner.next();
				System.out.println("pass 입력");
				temppass = scanner.next();
				
				if(  !( id.equals(tempid) && pass.equals(temppass) )) {
					System.out.println("정보확인");
					continue;
				}
				
				// 2. 각파트별 처리
				if (num == 2) {
					System.out.println("사용자 정보");
					System.out.println("id >" + id);
					System.out.println("pass >" + pass);
					System.out.println("잔액 >" + balance);

				}
				else if (num == 3) {
					System.out.println("입금할 금액 >");
					money = scanner.nextInt();
					System.out.println("잔액 >" + (balance += money) + "원");

				} else if (num == 4) {
					System.out.println("출금할 금액 >");
					money = scanner.nextInt();
					if (money > balance) {
						System.out.println("잔액부족");
					} else {
						balance -= money;
						System.out.println("잔액 >" + (balance -= money) + "원");
					}
				}else if (num == 5) {
					id = "";
					pass = "";
					balance = 0;
					System.out.println("삭제완료");
				}
			}  
			

		}
	

	}// for end

}
