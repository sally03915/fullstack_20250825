package com.company.java005_ex_MiniProject_Bank;

import java.util.Scanner;

public class Bank_ver3_level {

	public static void main(String[] args) {

		int num1 = 0;
		int add = 0;
		String id = null, pass = null, tempid = null, temppass = null, lev = null;
		double balance = 0;
		char yn = '\u0000';
		Scanner scanner = new Scanner(System.in);

		lev = balance>=0 && balance<10000? "BRONZ": balance>=10000 && balance<100000? "SILVER": balance>=100000 && balance<1000000? "GOLD":"VIP";

		
		for (;;) {
			System.out.print(
					"_____________________\n (주)CODEJOHNS BANK   \n______*WELCOME*______\n\n* 1.추가 \n* 2.조회 \n* 3.입금 \n* 4.출금 \n* 5.삭제 \n* 9.종료\n_____________________\n");
			System.out.print("메뉴를 선택해 주세요> ");
			num1 = scanner.nextInt();

			if (num1 == 9) {
				System.out.println("종료합니다.");
				break;

			} else if (num1 == 1) {
				System.out.print("ID를 생성해 주세요 : ");
				id = scanner.next();
				System.out.print("비밀번호를 생성해 주세요 : ");
				pass = scanner.next();
				System.out.print("개설 초기 금액을 입금해 주세요 : ");
				balance = scanner.nextDouble();
				System.out.println("축하합니다!\n계좌가 성공적으로 생성되었습니다");

			} else if (num1 == 2 || num1 == 3 || num1 == 4 || num1 == 5) {

				System.out.print("ID : ");
				tempid = scanner.next();
				System.out.print("비밀번호 : ");
				temppass = scanner.next();

				if (!(tempid.equals(id) && temppass.equals(pass))) {
					System.out.println("ID와 비밀번호를 확인해 주세요");
					continue;
				}
				

				if (num1 == 2) {
					System.out.printf("%s \nID : %s \nPASS : %s \n잔액 : %d \n등급 : %s\n", "==계좌 조회", id, pass, (int) balance, lev);
					
				} else if (num1 == 3) {
					
					System.out.printf("입금 : ");
					add = scanner.nextInt();
					System.out.println("==입금 완료 \n잔액:" + (int) (balance += add));
					
					String newlev = balance>=0 && balance<10000? "BRONZ": balance>=10000 && balance<100000? "SILVER": balance>=100000 && balance<1000000? "GOLD":"VIP";
					double newbalance = (int)(balance*0.05);
					
					if(!newlev.equals(lev)) 
					{System.out.println("축하합니다! 등급이 올랐습니다!" + "\n" + lev + "->" + newlev + "\n승급 축하 이자 5%가 지급됩니다 : +" + (int)newbalance);}
					
					lev = newlev;
					balance = balance+newbalance;
					

				} else if (num1 == 4) {
					System.out.printf("출금 : ");
					add = scanner.nextInt();
					System.out.println(add > balance ? "출금할 수 없습니다" : "==출금 완료 \n잔액:" + (int) (balance -= add));


				} else if (num1 == 5) {
					System.out.print("계좌를 삭제하시겠습니까?(Y/N) : ");
					yn = scanner.next().charAt(0);
					if (yn == 'N' || yn == 'n') {
					} else if (yn == 'Y' || yn == 'y') {
						id = null;
						pass = null;
						balance = 0;
						System.out.println("계좌를 성공적으로 삭제했습니다");
					} else {
						System.out.println("Y 혹은 N을 입력해 주세요");
					}
				} else {
					System.out.println("다시 확인해 주세요");
				}

			} else {
				System.out.println("존재하지 않는 메뉴입니다");
			}

		} // for

	}

}
