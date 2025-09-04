package com.company.java004_ex;

import java.util.Scanner;

public class IfEx004 {
public static void main(String[] args) {
		
		
		/*
		연습문제4)
		패키지명 : com.company.java004_ex
		클래스명 :  IfEx004
		출력내용 : 문자한개를 입력받아 
		   대문자인지,  소문자인지 판별하는 프로그램을 작성하시오.
	   ※  대문자  ch>='A' && ch<='Z' / 소문자  ch>='a'  &&  ch<='z'  
			
		*/
		
		//변수
		char ch = '\u0000';
		//입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("알파벳 하나 입력받기: ");
		ch = scanner.next().charAt(0);
		//처리
		//출력
		if(ch>='a' && ch<='z') {System.out.println("소문자 "+ch+" 입니다.");}
		else if( ch>='A' && ch<='Z') { System.out.println("대문자 "+ch+" 입니다.");}
		else {System.out.println("범위 안의 알파벳을 하나만 입력하세요.");}
	
	}
}
