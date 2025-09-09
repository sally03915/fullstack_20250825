package com.company.java005_ex_MiniProject_Bank; 
import java.util.Scanner;

public class Bank_ver1_Step1_1 {
	public static void main(String[] args) {
		//변수
		int num;
		Scanner scanner = new Scanner(System.in);
		//입력+처리+ 출력
		for(;;) {
			System.out.print("\n\n====== BANK ======\n*"
			+ " 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료\n입력>>> ");
			num = scanner.nextInt();
			
			if(num == 9 ) {  System.out.println("ATM을 종료합니다."); break;}
			switch(num){
				case 1 : System.out.println("1.추가기능입니다."); break;
				case 2 : System.out.println("2.조회기능입니다."); break;
				case 3 : System.out.println("3.입금입니다."); break;
				case 4 : System.out.println("4.출금입니다."); break;
				case 5 : System.out.println("5.삭제입니다."); break;
			}
		}// end for
		
	}// end main
}//end class



/*  하루에 하나씩 힌트나가요~~~!
	천천히 정리하면서 익히면서 도전이요~~!  이번주~ 다음해서 숙제~!

Step1. 무한반복으로 만드는 메뉴만들기	
	for(;;){ //1-1 무한반복
		//1-2 빠져나올조건 9
		//1-3 입력받은번호가   if   or  switch
		1을 입력하면 추가기능입니다. 출력구문까지만
		2를 입력하면 조회기능입니다. 출력구문까지만
		3을 입력하면 입금기능입니다. 출력구문까지만
		4를 입력하면 출금기능입니다. 출력구문까지만
		5를 입력하면 삭제기능입니다. 출력구문까지만
		9를 입력하면 종료합니다.    출력구문까지만
	}
	
	■ 힌트
	for(;;) { 
		System.out.println("숫자1을 입력하세요.");
		int a = scanner.nextInt();
		if(a == 1) { break;}
	}
			
*/