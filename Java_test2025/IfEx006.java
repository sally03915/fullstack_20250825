package com.company.java004_ex;

import java.util.Scanner;

public class IfEx006 {
	public static void main(String[] args) {
		
		/* 출력내용 : 숫자를입력을받아
		   홀수면 남자, 짝수면 여자를 출력하는 프로그램을 작성하시오.
		   ※  num%2==0  짝수
		 */
		
		//변수
		int num=0;
		//입력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("짝수나 홀수 입력받기: ");
		num = sc.nextInt();
		//처리
		//출력
		if(num%2!=0) {System.out.println("남자 입니다.");}
		else if(num%2==0) {System.out.println("여자 입니다.");}
		else {System.out.println("짝수나 홀수를 입력하세요.");}
		
		
	}
}
