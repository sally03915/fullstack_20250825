package com.company.java005_ex_MiniProject_Bank;

import java.util.Scanner;

public class ForEx006_1 {
	public static void main(String[] args) {
		//변수
		int num1, num2; char op;  double result = 0;
		Scanner scanner = new Scanner(System.in);
		//입력  101   -1  무한반복 for(;;){  빠져나올조건    }
		for(;;) {//무한반복
			System.out.print("숫자1 입력 >");  num1 = scanner.nextInt();
			if(0<=num1 && num1<=100) {break; }  //잘썼으면나와!  0~100사이면
		}
		for(;;) { //무한반복
			System.out.print("숫자2 입력 >");  num2 = scanner.nextInt();			
			if(num2>=0 && num2<=100) {break; }  //잘썼으면나와!  0~100사이면
		}
		for(;;) { // 무한반복
			System.out.print("연산자 입력 >");  op   = scanner.next().charAt(0);	
			if(op=='+' || op =='-' || op=='*' || op=='/') {break; }  
		}
		//처리
		switch(op) {
			case '+' : result = num1+num2;  break;
			case '-' : result = num1-num2;  break;
			case '*' : result = num1*num2;  break;
			case '/' : result = num1/(double)num2;  break;
		}
		//출력
		System.out.println("" + num1 + op + num2 + "=" + (op!='/'? "" +(int)result  : String.format("%.2f", result)));
	}
}

/*   마무리 되신분들은~ 개별카톡 파일보내주세요~~!
연습문제6)  for 무한반복
패키지명 : com.company.java006_ex
클래스명 :  ForEx006
출력내용 :  계산기

1)  각 연산자에 맞게 계산처리
2)  숫자1, 숫자2는 0~100사이만 입력가능하게 아니면 무한반복
3)  연산자는 +, - ,*, /만 입력가능하게 아니면 무한반복
     
1. 정수를 하나 입력해주세요 > 10   
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13
*/