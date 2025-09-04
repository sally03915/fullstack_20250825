package com.company.java004_ex;

import java.util.Scanner;

public class IfEx003 {
	public static void main(String[] args) {
		
		/*
		연습문제3)
		패키지명 : com.company.java004_ex
		클래스명 :  IfEx003
		출력내용 : 숫자한개를 입력받아 
		   만약 1을 입력했다면   one ,   
		   만약 2을 입력했다면   two ,
		   만약 3을 입력했다면   three ,
		   1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.
		 */
		
		//변수
		int num = 0;
		//입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자 입력받기: ");
		//처리
		//출력
		
		System.out.println(">> else if문 ");
		if(num==1) {System.out.println("one");}
		else if(num==2) {System.out.println("two");}
		else if(num==3) {System.out.println("three");}
		else {System.out.println("1,2,3이 아니다.");}
		
		
		/*
		연습문제4)
		패키지명 : com.company.java004_ex
		클래스명 :  IfEx004
		출력내용 : 문자한개를 입력받아 
		   대문자인지,  소문자인지 판별하는 프로그램을 작성하시오.
	   ※  대문자  ch>='A' && ch<='Z' / 소문자  ch>='a'  &&  ch<='z'  
			
		*/
		
	}
}
