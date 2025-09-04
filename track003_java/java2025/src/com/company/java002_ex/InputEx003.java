package com.company.java002_ex;

import java.util.Scanner;

public class InputEx003 {
	public static void main(String[] args) {
		//변수
		int num=0;
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.println("태어난 년도를 입력하세요. >");
		num = scanner.nextInt();
		//처리
		num = 2025 - num;   //2025-2000
		//출력
		System.out.println("당신의 나이는 "+num+"살 입니다.");
	}
}
/*
연습문제3)
패키지명 : com.company.java002_ex
클래스명 : InputEx002
출력내용 :  Scanner이용해서 태어난 년도를 입력받아 나이 계산하기
태어난 년도를 입력하세요. >
2000
당신의 나이는 25살 입니다.

*/
