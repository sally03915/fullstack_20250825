package com.company.java005_ex;

public class ForEx003_1 {
	public static void main(String[] args) {
		//변수  1~10까지의 합 
		int hap=0;    //hap을 담을 변수
		
		//입력+처리
		//hap변수에 1담기
		//hap변수에 2담기
		//		hap = hap+1;   // hap[1]     0+1
		//		hap = hap+2;   // hap[3]     1+2
		//		hap = hap+3;   // hap[6]     3+3
		//  { 반복 }   { 변수 }   for(시작; 종료; 변화)
		for(int i=1; i<=10; i++){  hap = hap+i;  }
		
		//출력
		System.out.println("1~10까지의 합 > " + hap);
	}
}

/*

연습문제3)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx003
출력내용 :   for 이용
1~10까지의 합을 구하시오.

upgrade)  시간나면 도전!
1+2+3+4+5+6+7+8+9+10=55
*/