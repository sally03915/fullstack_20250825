package com.company.java004_ex;

import java.util.Scanner;

public class IfEx006 {
	public static void main(String[] args) {
		//변수
		int num;  String result = "남자";
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("숫자를 입력해주세요 > ");
		num = scanner.nextInt();
		//처리
		//ver-1
		// if(num%2 == 0) {  result = "여자";}
		
		result = num%2 == 0? "여자" : "남자";
		//출력
		System.out.println(result);
	}
}

/*
연습문제6)
패키지명 : com.company.java004_ex
클래스명 :  IfEx006
출력내용 : 숫자를입력을받아
   홀수면 남자, 짝수면 여자를 출력하는 프로그램을 작성하시오.
   ※  num%2==0  짝수
*/