package com.company.java002_ex;

import java.util.Scanner;

public class InputEx2002 {
	public static void main(String[] args) {
		//변수
		int kor, eng, mat, total;
		double avg;
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("국어점수를 입력하시오. "); 
		kor = scanner.nextInt();
		System.out.print("영어점수를 입력하시오. "); 
		eng = scanner.nextInt();
		System.out.print("수학점수를 입력하시오. "); 
		mat = scanner.nextInt();
		//처리
		total = kor + eng + mat;   // A=B
		avg   = total/3.0;   //정수 = 정수/정수  →  실수 = 정수/실수
		//출력
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg); 
	}
}

/*
연습문제2)
패키지명 : com.company.java002_ex
클래스명 : InputEx2002
출력내용 :  Scanner이용해서  성적처리를 입력받고 출력하시오.
   국어점수를 입력하시오.  _입력받기    100 
   영어점수를 입력하시오.  _입력받기    100 
   수학점수를 입력하시오.  _입력받기    99

   총점 :  299
   평균 :  99
*/