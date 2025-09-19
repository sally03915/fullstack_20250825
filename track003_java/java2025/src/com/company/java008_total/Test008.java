package com.company.java008_total;

import java.util.Arrays;

public class Test008 {
	
	public static void print(int[]arr) { for(int i=0; i<arr.length; i++) { arr[i]+=10; } }
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		// call by value -   파라미터 ( 기본값 ) - 값을 복사해서 사용
		// public static int   print( int a ) {}
		System.out.println(print(arr[1]));  //2
		

		// call by reference -        파라미터 ( 주소값 ) -  주소를 참조해서(따라가서) 원본의 값을 바꿈
		// public static void   print(     int[] arr ) {}
		print(arr);
		System.out.println(Arrays.toString(arr)); 
	}
	
	public static int print(int i) { return i; }  //###
}

/*
6. 이차원배열
A  B  C
a  b  c


7. 메서드 오버로딩

*/