package com.company.java007_ex;

public class Array2Ex003 {
	public static void main(String[] args) {
		// 변수 + 대입
		int [][] arr2 = new int [2][3]; // 몇층몇칸     00  01 02 / 10 11 12
	
		int data=101;
		for(int i=0; i<arr2.length; i++) { // 아파트의 층
			for(int j=0; j<arr2[i].length; j++) { //층의 칸
				arr2[i][j] = data++;
			}
		}
		for(int i=0; i<arr2.length; i++) { // 아파트의 층
			for(int j=0; j<arr2[i].length; j++) { //층의 칸
				System.out.print(arr2[i][j]   + "\t");
			}
			System.out.println();
		} 
	}
}
/*
연습문제3)  array
패키지명 : com.company.java007_ex
클래스명 :  Array2Ex003
배열을 이용하여 다음의 프로그램을 작성하시오.   
1. new 연산자 이용하여 다차원배열만들기
2. for + length 이용해서 대입   
3. for + length 이용해서 출력 
	101		102		103
	104 	105 	106

*/
