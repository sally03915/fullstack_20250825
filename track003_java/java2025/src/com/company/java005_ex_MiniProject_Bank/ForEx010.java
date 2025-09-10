package com.company.java005_ex_MiniProject_Bank;

public class ForEx010 {
	public static void main(String[] args) {
	 /*
	  for , while , do while 3가지 버젼으로 
		ABCDE   
		FGHIJ
		KLMNO
		PQRST
		UVWXY
		Z 
	  */
	  //ver-1  눈에 보이는그대로
		//		System.out.println();
		//		System.out.print('A');65  System.out.print('B'); System.out.print('C'); System.out.print('D'); System.out.print('E');69
		//		System.out.println();
		//		System.out.print('F');70 System.out.print('G'); System.out.print('H'); System.out.print('I'); System.out.print('J');

       //ver-2  구조 {  반복 System.out.println();   System.out.print('A');65 }  {  변수 }  for(시작; 종료; 변화)
	   //ver-3  특별한 문제풀이 조건	
		System.out.println("\nfor-ver");
		for(char i='A'; i<='Z'; i++){  if( i%5==0 ){System.out.println(); }  System.out.print(i);    }
		
		System.out.println("\nwhile-ver");
		char i='A';  while(i<='Z'){  if( i%5==0 ){System.out.println(); }  System.out.print(i);    i++;}
		
		System.out.println("\ndo while-ver");
		     i='A';  do{  if( i%5==0 ){System.out.println(); }  System.out.print(i);    i++;}while(i<='Z');
	}
}

/*
연습문제10)  for/while/do while
패키지명 : com.company.java005_ex
클래스명 :  RepeatEx010
for , while , do while 3가지 버젼으로 
ABCDE   
FGHIJ
KLMNO
PQRST
UVWXY
Z 

ver-1 보이는 그대로 출력
System.out.print('A'); System.out.print('B'); System.out.print('C'); System.out.print('D'); System.out.print('E');
System.out.println();
System.out.print('F'); System.out.print('G'); System.out.print('H'); System.out.print('I'); System.out.print('J');
System.out.println();

ver-2  구조확인
1. 해야할일 { System.out.print('A');  System.out.println();  }   알파벳 출력(A~Z) 또는 줄바꿈 출력(5번째마다 출력)
System.out.println();
//				  65                     66                      67                    68                    69     
System.out.print('A'); System.out.print('B'); System.out.print('C'); System.out.print('D'); System.out.print('E');

System.out.println();
				  70
System.out.print('F'); System.out.print('G'); System.out.print('H'); System.out.print('I'); System.out.print('J');

 
ver-3 코드작성
 for(char a='A'; a<='Z'; a++){ 5번째 마다 줄바꿈-숫자카운트,문자가 갖고 있는 숫자로 체크     System.out.print( a );        }
 for(char a='A'; a<='Z'; a++){ a를 5로 나눴을때 0이라면                     줄바꿈     System.out.print( a );        }

*/