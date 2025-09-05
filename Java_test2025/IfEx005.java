package com.company.java004_ex;

import java.util.Scanner;

public class IfEx005 {
	public static void main(String[] args) {
		
		/* 출력내용 : 문자한개를 입력받아 
		   대문자인지 이면 소문자로,  소문자이면 대문자로 변경하는 
		   프로그램을 작성하시오.
		   ※  a = 'A' + 32  
		 */
		
		//변수
		char ch = '\u0000';
		//입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("알파벳 하나 입력받기: ");
		ch = scanner.next().charAt(0);
		System.out.println("입력받은 문자: "+ch);
		
		//처리
		if(ch>='a' && ch<='z') { ch-=32;}
		else if(ch>='A' && ch<='Z') {ch+=32;}
		else {System.out.println("알파벳 하나만 입력하세요.");}
		
		//출력
		System.out.println("바뀐 문자: "+ch);

		
	}
}
