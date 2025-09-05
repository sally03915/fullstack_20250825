package com.company.java004_ex;
import java.util.Scanner;
public class IfEx005_2 {
	public static void main(String[] args) {
		//변수
		char ch='\u0000';
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("영문소문자 또는 대문자를 입력해주세요 > ");
		ch = scanner.next().charAt(0);

		/*
		     if( ch>='A' && ch<='Z' ) {ch+=32;}  // ch= (char)(ch+32); 2byte문자+4byte숫자  
		else if( ch>='a' && ch<='z' ) {ch-=32;}
		*/
		// (조건)? 참 : 거짓
		// (조건)? 참 : ((조건)? 참 : 거짓 )       
		ch =  ch>='A' && ch<='Z'  ?   ch+=32 : ch>='a' && ch<='z' ? ch-=32: ch;
		
		//출력
	 	System.out.println("변경된문자 > " + ch);
	}
}

/*
연습문제5)
패키지명 : com.company.java004_ex
클래스명 :  IfEx005
출력내용 : 문자한개를 입력받아 
   대문자인지 이면 소문자로,  소문자이면 대문자로 변경하는 프로그램을 작성하시오.
   ※  a = 'A' + 32  
*/