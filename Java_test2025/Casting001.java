package com.company.java003;

public class Casting001 {
	public static void main(String[] args) {
		
		// #1. 형변환 - 자동 타입변환
		// byte < short < int < long < float < double
		// char 문자 (2byte)
		// 큰 값은 작은 값을 자동으로 담을 수 있다. 
		// int a = byte b (0)
		
		byte by=1;
		short sh =2;
		int i = 4;
		long l = 8L;
		float f = 3.14f;
		double d = 3.14;
		boolean bl = true;
		
		sh = by;  	// 정수 (2byte) = (1byte) 	O
		i = by;		// 정수 (4byte) = (1byte) 	O
//		l = f;		// 정수 (8byte) = (4byte)  담는 값이 정수, 담기는 값이 실수라 X
					// Type mismatch: cannot convert from float to long
		
		f = l;		// 실수 (4byte) = 정수 (8byte) 담는 실수가, 정수 보다 큼 O
//		i = bl;		// 논리형은 담기 어려움!
					// Type mismatch: cannot convert from boolean to int
				
		
		//#2. 형변환 - 강제 타입변환
		// 1-1. 정수와 정수인지 확인 
		// 1-2. by는 (1byte) = i (4byte) 작은 값이 큰 값을 담을수 없으나... 
		// 1-3. (빨간줄인 i에 마우스 올리기) 
		//		가장 윗 줄  Add cast to (형변환 값) 으로 변환하기		
		by = (byte) i;  
		
		int i2 = (int) 1.2; 	// 정수 (4byte) - 기본형 실수 double (8byte) 
		float f2 = (float) 1.2; // float가 실수 - 실수여도 기본형이 double (8byte)
		
		//Q1 System.out.println(1.5+2.7); 3으로 나오도록 만들기
		// :: 정수로 형변환 하면, 뒤에 실수값을 무시함.
		System.out.println((int)1.5 + (int)2.7);
		
		
		
	}
}
