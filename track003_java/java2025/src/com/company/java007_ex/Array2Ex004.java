package com.company.java007_ex;

public class Array2Ex004 {
	public static void main(String[] args) {
		// 변수 
		char [][] arr2 = new char[2][3];  // 몇층 몇칸
		// 입력
		char data = 'A';
		for(int ch=0; ch<arr2.length; ch++) { // 아파트층갯수
			for(int kan=0; kan<arr2[ch].length; kan++) { // 칸의 갯수
			    arr2[ch][kan] = data++;
			}
			data= 'B'; // 한층이 끝나면 해야할일
		}
		
		// 출력
		for(int ch=0; ch<arr2.length; ch++) { // 아파트층갯수
			for(int kan=0; kan<arr2[ch].length; kan++) { // 칸의 갯수
				System.out.print( arr2[ch][kan] + "\t");
			}
			System.out.println();  // 한층이 끝나면 해야할일
		}
	}
}


/*

연습문제4)  array
패키지명 : com.company.java007_ex
클래스명 :  Array2Ex004
배열을 이용하여 다음의 프로그램을 작성하시오.   
1. new 연산자 이용하여 다차원배열만들기
2. for + length 이용해서 대입   
3. for + length 이용해서 출력 
	A	B	C
	B	C	D



*/
