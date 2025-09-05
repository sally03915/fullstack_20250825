package com.company.java004_ex;

import java.util.Scanner;

public class IfEx007 {
	public static void main(String[] args) {
		/*
		 *  1. 정수를 하나 입력해주세요 > 10
			2. 정수를 하나 입력해주세요 > 3
			3. 연산자를 입력해주세요(+,-,*,/) > +
			10+3=13
			
			1. 정수를 하나 입력해주세요 > 10
			2. 정수를 하나 입력해주세요 > 3
			3. 연산자를 입력해주세요(+,-,*,/) > -
		 */
		
		//변수
		int num1,num2,res;
		double avg;
		char oper = '\u0000';
		
		//입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자입력1: ");
		num1 = scanner.nextInt();
		
		System.out.print("연산자 입력 (+,-,*,/): ");
		oper = scanner.next().charAt(0);
		
		System.out.print("숫자입력2: ");
		num2 = scanner.nextInt();
		
		// 처리
		// 출력
		if(oper=='+') {
			System.out.println(num1+"+"+num2+"="+(num1+num2));}
		else if(oper=='-') {
			System.out.println(num1+"-"+num2+"="+(num1-num2));}
		else if(oper=='*') {
			System.out.println(num1+"*"+num2+"="+(num1*num2));}
		else if(oper=='/') { 
			avg = num1 / (double)num2;
			String resavg = String.format("%.2f", avg);
			System.out.println(num1+"/"+num2+"="+resavg);
		}
		
		
		

		
		
		
	}
}
