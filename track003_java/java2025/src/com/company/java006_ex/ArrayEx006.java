package com.company.java006_ex;

public class ArrayEx006 {
	public static void main(String[] args) {
		//변수
		double [] arr = new double[5];  //0~4
		double data = 1.1;
		//입력+처리  1.1  , 1.2  , 1.3  , 1.4  , 1.5   
		//ver-1		arr[0] = 1.1;
		//			arr[1] = 1.2;
		//ver-2
		//		arr[0] = data;  data+=0.1;  //1.1대입  0.1증가(1.2)
		//		arr[1] = data;  data+=0.1;  //1.2대입  0.1증가(1.3)
		for(int i=0; i<arr.length; i++){ arr[i] = data;  data+=0.1;  }
		//출력
		for(int i=0; i<arr.length; i++){ System.out.printf("%.1f ",arr[i]); }
	}
}

/*
연습문제6)  array
패키지명 : com.company.java007_ex
클래스명 :  ArrayEx006
    new 연산자 이용해서 배열만들기
    1. 배열명 : arr     
    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5    
       for+length 이용해보기
    3. for + length 로 출력
*/