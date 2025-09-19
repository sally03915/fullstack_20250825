package com.company.java008_total;

public class Test006_007 {
	// 7 메서드오버로딩
	// 비슷한기능의 메서드의 이름을 같게하고 파라미터의 자료형과 갯수를 다르게해서 구분
	int add(int x, int y) {  return x+y; }
	
	int  add(byte  a , byte  b) {  return a+b; }  //a
	int  add(short a , short b) {  return a+b; }  //b
	//long add(int   a , int   b) {  return a+b; }  //c
	long add(long  a , long b) {  return a+b; }   //d
	
	public static void main(String[] args) {
		//6 이차원배열
		char [][] arr = new char[2][3];
		char data='A';
		for(int ch=0; ch<arr.length; ch++) {//층
			for(int kan=0; kan<arr[ch].length; kan++) {//칸
				arr[ch][kan] = data++; 
			}	
			data = 'a';
			// 한층이 끝나면해야할일
		}
		
		for(int ch=0; ch<arr.length; ch++) {//층
			for(int kan=0; kan<arr[ch].length; kan++) {//칸
				System.out.print(arr[ch][kan] +"\t");
			}	
			System.out.println(); 
		} 
	}
}

/*
6. 이차원배열
A  B  C
a  b  c


7. 메서드 오버로딩

*/