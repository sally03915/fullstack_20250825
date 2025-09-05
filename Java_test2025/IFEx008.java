package com.company.java004_ex;

import java.util.Scanner;

public class IFEx008 {
	public static void main(String[] args) {
		/*
		패키지명 : com.company.java004_ex
		클래스명 :  IfEx008
		출력내용 :  성적처리 프로그램입니다.

		1. 총점 구하기
		2. 평균 구하기
		3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
		4. 평균이 95점이상이면 장학생
		5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

		학번 입력 > std111
		국어점수 입력 > 100
		수학점수 입력 > 100
		영어점수 입력 > 99
		=================================================================================== 
		학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
		=================================================================================== 
		std111   100   100   99   299   99.67   합격   수   장학생
		
		*/
		
		//변수
		String hak="", pass ="", level="", elite = "";
		int kor, eng, math, total;
		double avg =0.0;

		
		//입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("학번 입력: ");
		hak = scanner.next().toString();
		
		
		System.out.print("국어점수 입력: ");
		kor = scanner.nextInt();
		
		System.out.print("영어점수 입력: ");
		eng = scanner.nextInt();
		
		System.out.print("수학점수 입력: ");
		math = scanner.nextInt();
		
		
		//처리
		total = kor+eng+math;
		avg = (double)total/3;
		
		// pass
		// 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
		if(avg>=60 && kor>40 && eng >40 && math>40) {
			pass="합격";
		}
		else {pass="불합격";}
		
		// elite
		// 평균이 95점이상이면 장학생
		if(avg>=95) {elite="장학생";}
		else {elite="일반";}
		
		// level
		// 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 
		if(avg>=90) {level="수";}
		else if(avg>=80) {level="우";}
		else if(avg>=70) {level="미";}
		else if(avg>=60) {level="양";}
		else {level="가";}
		
		
		// 평균 소수점 처리
		String resAvg = String.format("%.2f", avg);
		
		
		//출력
		System.out.println("===================================================================================");
		System.out.println("학번   	국어    영어   수학   	총점   평균    합격여부   레벨   장학생");
		System.out.println("===================================================================================");
		System.out.println(hak+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+resAvg+"\t"+pass+"\t"+level+"\t"+elite);
				
		
	}
}
