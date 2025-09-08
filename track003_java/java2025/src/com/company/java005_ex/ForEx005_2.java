package com.company.java005_ex;

public class ForEx005_2 {
	public static void main(String[] args) {
		//변수
		int cnt=0;   // 소문자 a~z까지 모음의 갯수를 카운트
		//입력 + 처리(1) 문제파악
		//a가 모음이라면(a,e,i,o,u)  카운트
		//b가 모음이라면(a,e,i,o,u)  카운트
		//c가 모음이라면(a,e,i,o,u)  카운트
		
		//입력 + 처리(2) 구조
		//if( a가 모음이라면(a,e,i,o,u) ){  카운트}
		//if( b가 모음이라면(a,e,i,o,u) ){  카운트}
		//if( c가 모음이라면(a,e,i,o,u) ){  카운트}
		
		//입력 + 처리(3) 코드 작성    {반복}  {변수}
		//if( 'a' == 'a' || 'a' =='e' || 'a' == 'i' || 'a' == 'o' || 'a' == 'u'){ cnt++; }
		//if( 'b' == 'a' || 'b' =='e' || 'b' == 'i' || 'b' == 'o' || 'b' == 'u'){ cnt++; }
		//if( 'c' == 'a' || 'c' =='e' || 'c' == 'i' || 'c' == 'o' || 'c' == 'u'){ cnt++; }
		
		for (char i = 'a'; i <= 'z'; i++) {
			switch(i) { case 'a' : case 'e' : case 'i' : case 'o' : case 'u' : cnt++; }
		}
		//출력
		System.out.println("소문자 a~z까지 모음의 갯수 > " + cnt);
	}
}
/*
연습문제5)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx005
출력내용 :   for 이용
소문자 a~z까지 모음의 갯수를 출력하시오. 
*/