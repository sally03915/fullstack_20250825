package com.company.java009_ex;

import java.util.Scanner;

//1. 클래스는 부품객체
//2. 클래스는 상태와 행위
class Calc{
	//상태-멤버변수  :  
	int num1, num2;  char op;  double result;
	//행위-멤버함수  :  void input()   입력받기
	//	            void opcalc() +더하기계산, -라면 -계산  , *라면 *계산 , /라면 /계산 
	//              void show()    연산출력   
	void input()  {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\n\n숫자1> "); this.num1 = scanner.nextInt();
		System.out.print("숫자2> ");     this.num2 = scanner.nextInt();
		System.out.print("연산자>");      this.op  = scanner.next().charAt(0); 
	}
	void opcalc() {
		     if(this.op == '+') {  this.result = this.num1 + this.num2; }
		else if(this.op == '-') {  this.result = this.num1 - this.num2; }
		else if(this.op == '*') {  this.result = this.num1 * this.num2; }
		else if(this.op == '/') {  this.result = this.num1 / (double)this.num2; }
	}
	void show()   {
		this.opcalc();  //##  계산기처리
		if(this.op == '/') {
			System.out.printf("%d %c %d = %.2f" , this.num1 , this.op, this.num2 , this.result);
		}else {
			System.out.printf("%d %c %d = %d"   , this.num1 , this.op, this.num2 ,(int)this.result);
		}
	} 
	public Calc() { super(); }
	public Calc(int num1, int num2, char op) { super(); this.num1 = num1; this.num2 = num2; this.op = op; }
}

public class ClassEx007 {
	public static void main(String[] args) {
		Calc  c1= new Calc(10,3,'+');   //1. 1번지- 객체생성  2. 생성자불러서 초기화  3. c1 주소값
		c1.show();   // 10+3=3               
		
		Calc  c2= new Calc();    //1. 2번지- 객체생성  2. 생성자불러서 초기화  3. c1 주소값
		c2.input(); //##
		c2.show();  // 10/3=3.33
	}
}
/*
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]  Calc.class , public ClassEx007.class       클래스( 설계도)
------------------------------------
[heap: 동적]            				| [stack : 잠깐빌리기]
										  c2.show(){}
										  c2.input();	
2번지{num1=3, num2=4, op=*, result=12}    ← c2[2번지]
										  c1.show(){}
1번지{num1=10, num2=3, op='+', result=13} ← c1[1번지]   Calc  c1= new Calc(10,3,'+')
				       				| main
------------------------------------
객체(new)   / 인스턴스- c2(2번지의).num1 ,  c1(1번지의).num1
*/



/*

연습문제7)  class
패키지명 : com.company.java009_ex
클래스명 :  ClassEx007
-- 생성자 작성하시오.
class Calc{
	//상태-멤버변수  :  int num1, num2;  char op;  double result;
	//행위-멤버함수  :  void input()   입력받기
	//	            void opcalc() +더하기계산, -라면 -계산  , *라면 *계산 , /라면 /계산 
	//              void show()    연산출력   
}
public class ClassEx007{
   public static void main(String[] args) {
	Calc  c1= new Calc(10,3,'+');  
	c1.show();
	
	Calc  c2= new Calc();  
	c2.input();   
	c2.show(); 
	 
   }
}

출력내용)
10+3=3

숫자1> 10
숫자2> 3
연산자> /
10/3=3.33

*/