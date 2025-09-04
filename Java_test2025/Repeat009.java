package com.company.java003_ex;

import java.util.Scanner;

public class Repeat009 {
	public static void main(String[] args) {
		
		//변수
		int num1, num2;
		double avg;
		
		//입력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력받기1: ");
		num1 = sc.nextInt();
		
		System.out.print("숫자 입력받기2: ");
		num2 = sc.nextInt();
		
		//처리
		avg = num1/(double)num2;
		String res = String.format("%.2f", avg);
		
		
		//출력
		System.out.println(num1+"/"+num2+"="+res);
		
		
	}
}
