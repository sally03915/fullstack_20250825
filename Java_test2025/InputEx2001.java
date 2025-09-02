package com.company.java002_ex;

import java.util.Scanner;

public class InputEx2001 {
	public static void main(String[] args) {
		
		/*연습문제1)
			패키지명 : com.company.java002_ex
			클래스명 : InputEx2001
			출력내용 :  Scanner이용해서 파이값을 입력받고 출력하시오. 
			파이값을 입력하시오 > _입력받기    3.141592    ( 자료형선택 )
     		파이값은 **입니다.
     		
     	연습문제2)
		패키지명 : com.company.java002_ex
		클래스명 : InputEx2002
		출력내용 :  Scanner이용해서  성적처리를 입력받고 출력하시오.
	   	국어점수를 입력하시오.  _입력받기    100 
	   	영어점수를 입력하시오.  _입력받기    100 
	   	수학점수를 입력하시오.  _입력받기    99
	
	   	총점 :  299
	   	평균 :  99
		 * */
		
		//변수
		float f = 0.0f;
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("파이값을 입력하세요(3.141592):");
		f = sc.nextFloat();
		
		//처리
		//출력
		System.out.println("입력받은 파이 값은 "+f+" 입니다. ");
	}
}
