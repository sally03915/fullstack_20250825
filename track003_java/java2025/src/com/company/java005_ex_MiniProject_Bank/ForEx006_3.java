package com.company.java005_ex_MiniProject_Bank;

import java.util.Scanner;

public class ForEx006_3 {
	public static void main(String[] args) {
		// 변수
		int num1=-1, num2=-1;  char op=' '; double result = ' ';
		Scanner scanner = new Scanner(System.in);
		// 입력
		/*  break ( 빠져나와!) / continue (밑에꺼 skip)
		 for(;;){  // 1-1. 무한반복
		 	//#todo1  if(잘못썼으면){ 숫자1입력받기  }->if(!(0<=num1 && num1<=100)){ 숫자1입력받기  }
		 	//#todo2  else if(잘못썼으면){ 숫자2입력받고  }  
		 	//#todo3  else if(잘못썼으면){ 연산자입력받고  }  
		 	//1-2.    else{ 빠져나올조건-빠져나오기 break}
		 }
		 */
		// num=-1, num2=-1 , num=' ' 
		for(;;) {
			if(!(0<=num1 && num1<=100)){  // 잘쓴범위가 아니라면 입력시도 / 잘쓴범위면 입력 X
				System.out.print("숫자1 입력>"); num1 = scanner.nextInt();  //10
			}else if(  0>num2  ||  num2>100 ){ //-1   ||  101      
				System.out.print("숫자2 입력>"); num2 = scanner.nextInt();  //-3
			} else if(!( op=='+' || op == '-' || op =='*' || op=='/')){  
				System.out.print("연산자 입력>");   op = scanner.next().charAt(0); continue;
			}else{ break; } // num1, num2, op 잘쓴경우 
		}
		// 처리  만약 +  더하기연산/ -라면 빼기연산 / *라면 곱하기연산 /   /라면 나누기연산
		// 처리  if(만약 +){더하기연산} else if(-라면){ 빼기연산} else if(*라면){ 곱하기연산}
		     if(op == '+') { result = num1 + num2;        }
		else if(op == '-') { result = num1 - num2;        }
		else if(op == '*') { result = num1 * num2;        }
		else if(op == '/') { result = num1 / (double)num2;}
		
		// 출력				""+  정수   문자(저장시 숫자)   정수 
		//                       10+3=13       ,   10/3=3.33
		//					     13.0 -> 13         3.33 -> 소수점둘째자리
		//	        			(int)result        String.format("%.2f",result)
		//				(op!='/'?   ""+(int)result :    String.format("%.2f",result))
		System.out.println( ""+ num1 + op + num2 +"=" +   
		     (op!='/'  ?  ""+ (int)result :  String.format("%.2f",result))  
		); 
		
//	2)  숫자1, 숫자2는 0~100사이만 입력가능하게 아니면 무한반복
//	3)  연산자는 +, - ,*, /만 입력가능하게 아니면 무한반복
	}// end main
}// end class


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