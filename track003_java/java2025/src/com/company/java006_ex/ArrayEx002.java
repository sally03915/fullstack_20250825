package com.company.java006_ex;

public class ArrayEx002 {
	public static void main(String[] args) {
		//변수
		char [] arr = {'A' , 'B' , 'C' , 'D'};
		//입력
		//처리
		//출력
		//		System.out.print(arr[0]);
		//		System.out.print(arr[1]);
		for(int i=0; i<arr.length; i++){
 
			System.out.print(  ( i==0? "":",") +       arr[i]); 

		}
	}
}

/*
연습문제2)  array
패키지명 : com.company.java006_ex
클래스명 :  ArrayEx002
    1. 배열명 : arr
    2. 값 넣기 : 'A' , 'B' , 'C' , 'D'
    3. for + length 로 출력


*/