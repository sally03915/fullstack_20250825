package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx002 {
	public static void main(String[] args) {
		
		/*
		연습문제2)
		패키지명 : com.company.java003_ex
		클래스명 : CastingEx002
		출력내용 :  Scanner이용해서  성적처리를 입력받고 출력하시오.
		 1.  국어, 영어, 수학, 총점☆자료형을 int 
		 2.  레벨 - 평균이 90점대이면 레벨 9, 80점대면 8, 70점대면 7, 60점대면 6,,,,
		
		국어점수 입력 > 100
		영어점수 입력 > 100
		수학점수 입력 > 99
		
		::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		:: GOOD  IT SCORE ::
		::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		국어   영어   수학   총점   평균   레벨
		100   100   99   299   99.67   9
		
		*/
		
		//변수
		int kor, eng, math, total;
		double avg;
		
		//입력
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어점수를 입력하시오: ");
		kor = scanner.nextInt();
		
		System.out.print("영어점수를 입력하시오: ");
		eng = scanner.nextInt();
		
		System.out.print("수학점수를 입력하시오: ");
		math = scanner.nextInt();
		
		//처리
		
		//총점
		total = kor+eng+math;
		
		//평균
		avg = (double)total/3;
		
		//레벨
		int level = (int) avg/10;
		
		//출력
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":: GOOD  IT SCORE ::");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("국어   	영어     수학     총점     평균    			레벨 \n"
						+ kor+"\t" + eng+"\t" + math+"\t" + total+"\t" +avg+"\t"+ level );
		
		
			
				
		
	}
}
