package com.company.java005_ex;

public class ForEx004_2 {
	public static void main(String[] args) {
		//변수
		String result="";
		int cnt = 0;  //1~10까지의 3의 배수의 갯수 카운트 담을 변수
		//입력 + 처리(1) 문제파악
		// 1이 3의 배수라면 카운트
		// 2가 3의 배수라면 카운트
		// 3이 3의 배수라면 카운트
		//입력 + 처리(2) 구조
		// if(1이 3의 배수라면){ 카운트 , 화면에 출력부분}   // ()3  ,6   ,9
		// if(2가 3의 배수라면){ 카운트 , 화면에 출력부분}
		// if(3이 3의 배수라면){ 카운트 , 화면에 출력부분}
		//입력 + 처리(3) 코드변환
		// if(1%3== 0){ cnt++; }
		// if(2%3== 0){ cnt++; }
		// if(3%3== 0){ cnt++; }
		
		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) { cnt++;   result +=  (i==3? "" : ",") + i ;    }   // ()3  ,6   ,9
		}
		//출력
		System.out.println("3의배수 : " + result);
		System.out.println("갯수 : " + cnt);
	}
}  //3의배수 : 3,6,9  


/*
연습문제4)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx004
출력내용 :   for 이용
1~10까지 3의 배수 갯수를 출력   

upgrade)  시간나면 도전!
3의배수 : 3,6,9    
갯수 : 3개
*/