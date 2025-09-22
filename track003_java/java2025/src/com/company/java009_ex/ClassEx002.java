package com.company.java009_ex;
import java.util.Scanner;
//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수)와 행위(멤버함수)
class MyPrice001{
	//상태 - 멤버변수 : 
	String name;  int price;  
	//행위 - 멤버함수 : void input()  입력받는 기능 / void show()  출력해주는 기능
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("상품이름 입력 >");  this.name  = scanner.next();
		System.out.print("상품가격 입력 >");  this.price = scanner.nextInt();
	}
	void  show() {
		System.out.println("\n\n🍎상품정보입니다");
		System.out.printf("상품이름 : %s  / 상품가격 : %d" , this.name , this.price); 
	}
}
//////////////////////////////////////////////////
public class ClassEx002 {
	public static void main(String[] args) {
        MyPrice001   p1 = new MyPrice001();
        //1) new (번지, 객체생성)  2) 생성자 MyPrice001() 초기화  3) p1 = 1번지
        p1.input();
        p1.show();
	}
}
//////////////////////////////////////////////////
/*  ■ MyPrice001   p1 = new MyPrice001();
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보] 
  MyPrice001.class ,   ClassEx002.class          클래스( 설계도 )
---------------------------------------------    객체 (p1)   인스턴스(p1.name="apple" /p1.price=1500)
[heap: 동적]                     | [stack : 잠깐빌리기] 
										   p1.show(){    }
1번지										   p1.input(){ 	 }
{ name=null, price=0, input(), show()}   ← p1 [1번지]

								| main
---------------------------------------------
*/





/*
연습문제2)  class
패키지명 : com.company.java009_ex
클래스명 :  ClassEx002
class MyPrice001{
  멤버변수 : String name;  int price;
  멤버함수 : void input()  입력받는 기능 / void show()  출력해주는 기능
}
public class ClassEx002{
   public static void main(String[] args) {
        MyPrice001   p1 = new MyPrice001();
        p1.input();
        p1.show();
   }
}
출력내용 : 
  상품이름 입력 >  apple
  상품가격 입력 >  1500

  상품정보입니다
  상품이름 : apple  / 상품가격 : 1500
*/