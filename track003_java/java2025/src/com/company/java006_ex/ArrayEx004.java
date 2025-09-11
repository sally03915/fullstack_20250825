package com.company.java006_ex;

public class ArrayEx004 {
	public static void main(String[] args) {
		//변수
		int cnt = 0;
		//입력
		char [] ch = {'B' , 'a' , 'n' , 'a', 'n' , 'a'};
		//처리
		// ver-1. 만약 'B'가 'a'라면 카운드 ,  만약 'a'가 'a'라면 카운드
		// ver-2. if('B'가 'a'라면){ 카운드}  if(만약 'a'가 'a'라면){ 카운드}
		// ver-3. if(ch[0]=='a'){ cnt++;}  if(ch[1]=='a'){ cnt++;}
		for(int i=0; i<ch.length; i++)
		{   if(ch[i]=='a'){ cnt++;}   }
		//출력 -  a의 갯수 세기
		System.out.println("ch 배열에서 a의 갯수 > " + cnt);
	}
}

/*
연습문제4)  array
패키지명 : com.company.java006_ex
클래스명 :  ArrayEx004
    1. 배열명 : ch
    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
    3. ch 배열에서 a의 갯수 세기

*/