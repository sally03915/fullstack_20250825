package com.company.java006_ex;

public class ArrayEx003 {
	public static void main(String[] args) {
		//변수
		String []arr = {"아이언맨" , "헐크" , "캡틴"};
		//입력
		//처리
		//출력
		//		System.out.println(arr[0]);
		//		System.out.println(arr[1]); 
		for (int i = 0; i < arr.length; i++) {
			System.out.print(  (  arr[i].equals("아이언맨")? "" :",") +   arr[i]);
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(  (  i==0? "" :",") +   arr[i]);
		}
	}
}

/*
연습문제3)  array
패키지명 : com.company.java006_ex
클래스명 :  ArrayEx003
    1. 배열명 : arr
    2. 값 넣기 : "아이언맨" , "헐크" , "캡틴"
    3. for + length 로 출력


*/