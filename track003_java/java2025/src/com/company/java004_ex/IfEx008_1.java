package com.company.java004_ex;

import java.util.Scanner;

public class IfEx008_1 {
	public static void main(String[] args) {
		//변수
		String std;
		int kor, eng, mat , total;
		double avg;
		String pass="불합격", lv="가", jang="-";
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("학번 입력 >");     std = scanner.next();
		System.out.print("국어점수 입력 > "); kor = scanner.nextInt();
		System.out.print("영어점수 입력 > "); eng = scanner.nextInt();
		System.out.print("수학점수 입력 > "); mat = scanner.nextInt(); 
		
		//처리
		//1. 총점 구하기
		total = kor + eng + mat;
		//2. 평균 구하기
		avg   = total/3.0;
		//3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
		if(avg>=60 && kor>=40 && eng>=40 && mat>=40 ) { pass="합격"; }
		//4. 평균이 95점이상이면 장학생
		if(avg>=95) { jang = "장학생";}
		//		5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 
		     if(avg>=90) { lv="수";}
		else if(avg>=80) { lv="우";}
		else if(avg>=70) { lv="미";}
		else if(avg>=60) { lv="양";}
		
		//출력
		System.out.println("=========================================================");
		System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\n" ,"학번","국어","영어","수학","총점", "평균" ,"합격여부","레벨","장학생");
		System.out.println("=========================================================");
		System.out.printf("%-5s\t%-5d\t%-5d\t%-5d\t%-5d\t%.2f\t%-5s\t%-5s\t%-5s\n" ,std,kor,eng,mat,total, avg , pass, lv, jang);
	}
}

/*
연습문제8)  
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