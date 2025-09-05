package com.company.java004_ex;
import java.util.Scanner;

public class IfEx007_2 {
	public static void main(String[] args) {
		//변수
		int num1, num2; String result ="";
		char op;
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("1. 정수를 하나 입력해주세요 >");
		num1 = scanner.nextInt();
		System.out.print("2. 정수를 하나 입력해주세요 >");
		num2 = scanner.nextInt();
		System.out.print("3. 연산자를 입력해주세요(+,-,*,/) >");
		op = scanner.next().charAt(0);
		//처리    출력  숫자   연산자  숫자    = 
		
		result = "" + num1 + op + num2 + "="; 
		result +=  op == '+'?  (num1+num2): 
				   op == '-'?   num1-num2 : 
				   op == '*'?   num1*num2 : 
				   op == '/'?   String.format("%.2f"  , (double)num1/num2): "";
		     
		//출력
		System.out.println(result);
	}
}

/*
연습문제7)   
패키지명 : com.company.java004_ex
클래스명 :  IfEx007
출력내용 :  계산기

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > -
10-3=7 
*/