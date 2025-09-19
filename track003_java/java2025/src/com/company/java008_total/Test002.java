package com.company.java008_total;

public class Test002 {

	public static void main(String[] args) {
		int [][] arr = new int[2][3];   // 00 01 02 / 10 11 12
		int data = 101;
		
		
		for(int ch = 0;  ch<arr.length; ch++) {  //1. 층
			for(int kan = 0;  kan<arr[ch].length; kan++) { //2. 칸
				arr[ch][kan] =  data++;
			}	
			// 3.각층마다 끝나고 해야할일
			data = 201;
		}
		
	
		for (int ch = 0; ch < arr.length; ch++) { // 1. 층
			for (int kan = 0; kan < arr[ch].length; kan++) { // 2. 칸
				System.out.print( arr[ch][kan] + "\t");
			}System.out.println();
		}

	}
}
/*
	101	102  103
	201 202  203

*/