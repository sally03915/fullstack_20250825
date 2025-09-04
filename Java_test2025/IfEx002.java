package com.company.java004_ex;

import java.util.Scanner;

public class IfEx002 {
	public static void main(String[] args) {
		/*
		연습문제2)
		패키지명 : com.company.java004_ex
		클래스명 :  IfEx002
		출력내용 : 숫자 한개를 입력받아 
		   양수라면 양수  , 음수라면 음수  ,0이라면 zero를 출력하는 프로그램을 작성하시오.
		
		*/
		
		//변수
		int num;
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수로 숫자 입력받기: ");
		num = sc.nextInt();
		//처리
		//출력
		System.out.println(">>> if문");
		if(num%2==0) {System.out.println("양수 입니다.");}
		else if(num%3==0) {System.out.println("음수 입니다.");}
		else {System.out.println("Zero 입니다.");}
		
		System.out.println(">>> 삼항식");
		//:: 삼항식
		System.out.println( (num%2==0)?"양수":(num%3==0)?"음수":"ZERO");
		
		
		/*
		연습문제3)
		패키지명 : com.company.java004_ex
		클래스명 :  IfEx003
		출력내용 : 숫자한개를 입력받아 
		   만약 1을 입력했다면   one ,   
		   만약 2을 입력했다면   two ,
		   만약 3을 입력했다면   three ,
		   1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.
		 
		
		   
		연습문제4)
		패키지명 : com.company.java004_ex
		클래스명 :  IfEx004
		출력내용 : 문자한개를 입력받아 
		   대문자인지,  소문자인지 판별하는 프로그램을 작성하시오.
	   ※  대문자  ch>='A' && ch<='Z' / 소문자  ch>='a'  &&  ch<='z'  
			
		*/

		
	}
}
