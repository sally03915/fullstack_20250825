package com.company.java004_ex;

import java.util.Scanner;

public class IfEx002 {
	public static void main(String[] args) {
		//변수
		int num;
		Scanner scanner = new Scanner(System.in);
		
		//입력  - 숫자 한개를 입력받아 
		System.out.print("숫자한개 입력해주세요 > ");
		num = scanner.nextInt();
		
		//처리 +출력 - 양수라면 양수  , 음수라면 음수  ,0이라면 zero를 출력하는 프로그램
		if(num > 0) {
			System.out.println("양수");
		}else if(num < 0) {
			System.out.println("음수");
		}else if(num == 0) {
			System.out.println("zero");
		}
	}
}
/*
연습문제2)
패키지명 : com.company.java004_ex
클래스명 :  IfEx002
출력내용 : 숫자 한개를 입력받아 
   양수라면 양수  , 음수라면 음수  ,0이라면 zero를 출력하는 프로그램을 작성하시오.

*/