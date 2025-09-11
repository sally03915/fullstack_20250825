package com.company.java006_ex;

public class ArrayEx005 {
	public static void main(String[] args) {
		//변수 
		int upper=0, lower=0;
		//입력
		char [] ch = {'B' , 'a' , 'n' , 'a', 'n' , 'a'};
		//처리 
		// ver-1. 만약 'B'가 대문자라면 대문자 카운드, 소문자라면 소문자카운트 
		// ver-2. if(만약 'B'가 대문자라면){ 대문자 카운드} else if(소문자라면){ 소문자카운트}
		// ver-3.      if(ch[0]>='A' && ch[0]<='Z'){ upper++;} 
		//		  else if(ch[0]>='a' && ch[0]<='z'){ lower++;} 
		for(int i=0; i<ch.length; i++)
		{        if(ch[i]>='A' && ch[i]<='Z'){ upper++;} 
		    else if(ch[i]>='a' && ch[i]<='z'){ lower++;} }
		
		//출력 -  대문자의 갯수카운트, 소문자의 갯수 카운트
		System.out.println("대문자>" + upper + ",소문자>" + lower);
	}
}

/*
연습문제5)  array
패키지명 : com.company.java006_ex
클래스명 :  ArrayEx005
    1. 배열명 : ch
    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
    3. ch 배열에서 대문자의 갯수카운트, 소문자의 갯수 카운트


*/