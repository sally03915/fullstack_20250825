package com.company.java005_ex_MiniProject_Bank;

public class ForEx008 {
	public static void main(String[] args) { 
		//	1.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5
		System.out.println("\nQ1. 1 2 3 4 5");
		System.out.println("java-ver");  // { 반복  }   {변수}  for(시작; 종료; 변화)
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + "\t");
		}
		
		System.out.println("\nwhile-ver"); 
		int i = 1;
		while (i <= 5) {
			System.out.print(i + "\t");
			i++;
		}
		
		System.out.println("\ndo while-ver"); 
		i = 1;
		do {
			System.out.print(i + "\t");
			i++;
		} while (i <= 5);
			
		    
		//	2.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1
		System.out.println("\n\nQ2. 5 4 3 2 1");
		System.out.println("java-ver");   // { 반복  }   {변수}  for(시작; 종료; 변화)
		for (i = 5; i >= 1; i--) {
			System.out.print(i + "\t");
		}
		
		System.out.println("\nwhile-ver"); 
		i = 5;
		while (i >= 1) {
			System.out.print(i + "\t");
			i--;
		}
		
		System.out.println("\ndo while-ver"); 
		i = 5;
		do {
			System.out.print(i + "\t");
			i--;
		} while (i >= 1);
		
			
		//	3.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3
		System.out.println("\n\nQ3. JAVA1   JAVA2  JAVA3");
		System.out.println("java-ver"); 
		for (i = 1; i <= 3; i++) {
			System.out.print("JAVA" + i + "\t");
		}
		
		System.out.println("\nwhile-ver"); 
		i = 1;
		while (i <= 3) {
			System.out.print("JAVA" + i + "\t");
			i++;
		}
		
		System.out.println("\ndo while-ver"); 
		i = 1;
		do {
			System.out.print("JAVA" + i + "\t");
			i++;
		} while (i <= 3);

	}// end main
}// end class

/*
연습문제8)  for, while, do while
패키지명 : com.company.java005_ex
클래스명 :  ForEx008 
1.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5
2.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1
3.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3

*/