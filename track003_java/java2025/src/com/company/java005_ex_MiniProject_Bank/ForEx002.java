package com.company.java005_ex_MiniProject_Bank;
import java.util.Scanner;
public class ForEx002 {
	public static void main(String[] args) {
		//변수
		int dan=0;
		Scanner scanner = new Scanner(System.in);
		
		//입력
		System.out.print("구구단 중 원하는 단을 입력하세요 > ");
		dan = scanner.nextInt();
		
		//처리+출력 (1)
		// 2*1=2		
		// 2*2=4
		// 2*3=6
		//		System.out.println( 2 + "*" + 1 + "=" + 2*1);
		//		System.out.println( 2 + "*" + 2 + "=" + 2*2);
		//		System.out.println( 2 + "*" + 3 + "=" + 2*3);
		
		//처리+출력 (2) 2단말고 사용자에게 입력받은 단  { 반복}  {변수}  for(시작;종료;변화)
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + "*" + i + "=" + dan * i);
		}
	}
}


/*
연습문제2)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx002
출력내용 :   for 이용

   사용자에게 단을 입력받아 해당하는 
   단을 출력해주는 프로그램을 작성하시오. FOR문을 이용하시오.
*/