package com.company.java004;
import java.util.Scanner;

public class Switch001 {
	public static void main(String [] args) {
		// 변수
		int  a=0;
		Scanner scanner = new Scanner(System.in);
		// 입력
		System.out.print("숫자 한개 입력 > ");
		a = scanner.nextInt();
		// 처리+출력 (1)  if (조건식이 복잡하고 여러개일때  && >= )
		     if( a == 1) {  System.out.println("1이다");}  //else 부분 안봄
		else if( a == 2) {  System.out.println("2이다");}
		else if( a == 3) {  System.out.println("3이다");}
		
		System.out.println();
		// 처리+출력 (2)  switch case  break (처리대상 1,2,3)
		     switch(a) {  // 처리대상 
		     case 1 : /* a==1 */System.out.println("1이다"); break;
		     case 2 : /* a==2 */System.out.println("2이다"); break; 
		     case 3 : /* a==3 */System.out.println("3이다"); break;
	     }  
	}
}
