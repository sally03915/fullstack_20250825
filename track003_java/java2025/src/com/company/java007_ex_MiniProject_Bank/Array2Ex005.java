package com.company.java007_ex_MiniProject_Bank;

public class Array2Ex005 {
	public static void main(String[] args) {
		 //변수 + 입력
		 int[][] arr = {
			{ 1, 1, 1,}, { 2, 2, 2,}, { 3, 3, 3,}, { 4, 4, 4,},
		 };
		 int total=0;  double avg=0.0;
		 
		 // 처리1 (총점구하기) 
		 // total += arr[0][0];
		 // total += arr[0][0];   데이터 누적
		 for(int ch=0; ch<arr.length; ch++) {
			 for(int kan=0; kan<arr[ch].length; kan++) {
				 total += arr[ch][kan]; 
			 }	
		 } 
		// 처리2 (평균구하기)   12 = 층*칸 =  arr.length * arr[0].length
		// avg = total/12;
		 avg = (double)total/( arr.length * arr[0].length);
		 // 출력
		 System.out.println("총점 > " + total);
		 System.out.println("평균 > " + avg);
	}
}


/*

연습문제5)  array
패키지명 : com.company.java007_ex
클래스명 :  Array2Ex005
배열을 이용하여 다음의 프로그램을 작성하시오.   
1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.

 int[][] arr = {
	{ 1, 1, 1,},
	{ 2, 2, 2,},
	{ 3, 3, 3,},
	{ 4, 4, 4,},
 };
 int total=0;  double avg=0.0;

출력내용:
총점 : 30
평균 : 2.5



*/
