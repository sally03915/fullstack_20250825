package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx001 {
	public static void main(String[] args) {
		
		/*
		
		형변환연습문제

		연습문제1)
		패키지명 : com.company.java003_ex
		클래스명 : CastingEx001
		출력내용 :  Scanner이용해서 나누기 프로그램만들기 
		   숫자입력1>  _입력받기  10   ( ☆자료형을 int )
		   숫자입력2>  _입력받기  3     ( ☆자료형을 int )              
		   
		   10 / 3 = 3.33
		
		   1단계)  변수 - 입력- 처리 - 출력
		   2단계)  정수/정수 = 정수
		              정수/실수 = 실수
		              실수/정수 = 실수
		              실수/실수 = 실수    
		      ※  형변환법 :    by = (byte) in;   나 잠깐만 byte할게.... 데이터 누수있을수 있음!
		*/
		
		//변수
		int num1, num2;
		double avg;
		
		//입력
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자 10 입력받기: ");
		num1 = scanner.nextInt();
		
		System.out.print("숫자 3 입력받기: ");
		num2 = scanner.nextInt();
		
		
		//처리
		avg = (double)num1/num2;
		
		//출력
		System.out.println("double로 처리받은 값 : "+avg);
		
		avg = (float)num1/(float)num2; 
		System.out.println("float로 처리받은 값 : "+avg);
		
		

		
	}
}
