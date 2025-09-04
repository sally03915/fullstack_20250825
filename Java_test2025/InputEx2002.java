package com.company.java002_ex;

import java.util.Scanner;

public class InputEx2002 {
	public static void main(String[] args) {
		
		/*
		 * 연습문제2)
		패키지명 : com.company.java002_ex
		클래스명 : InputEx2002
		출력내용 :  Scanner이용해서  성적처리를 입력받고 출력하시오.
	   	국어점수를 입력하시오.  _입력받기    100 
	   	영어점수를 입력하시오.  _입력받기    100 
	   	수학점수를 입력하시오.  _입력받기    99
	
	   	총점 :  299
	   	평균 :  99
		 * 
		 * */
		
		//변수
		int kor, eng, math, total=0;
		double avg = 0.0;
		//입력
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어점수를 입력하세요: ");
		kor = scanner.nextInt();
		
		System.out.print("영어점수를 입력하세요: ");
		eng = scanner.nextInt();
		
		System.out.print("수학점수를 입력하세요: ");
		math = scanner.nextInt();
		
		//처리
		total = kor+eng+math;
		avg = total/3;
		
		
		//출력
		System.out.println("국어점수 : "+kor+"\n영어점수: "+eng+"\n"
				+ "수학점수: "+math+"\n 총점: "+total+"\n 평균: "+avg);
		
	}
}
