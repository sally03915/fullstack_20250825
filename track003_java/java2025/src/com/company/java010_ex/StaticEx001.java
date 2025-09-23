package com.company.java010_ex;

//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수)와 행위(멤버함수)
class Area1{
	//멤버변수
	static double pi=3.141592;
	//멤버함수
	static  double rect(int a, int b){  return a*b ;  }
	static  double triangle(int a, int b) { return a*b*0.5; }
}
/////////////////////////////////////////////////////////
public class StaticEx001 {
	public static void main(String[] args) {
	   System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);   // 클래스명.변수   , 클래스변수    ,method , (static)
	   // public static  리턴값   메서드명(파라미터) {  해야할일 }
	   // public static  double rect(int a, int b){  return a*b ;  }
	   System.out.println("사각형의 면적 : " + Area1.rect(10, 5));    // 클래스명.메서드  , 클래스메서드  ,method , (static)
	   // public static  double triangle(int a, int b) { return a*b*0.5; }
	   System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));// 클래스명.메서드  , 클래스메서드  ,method , (static)
	}
}
/////////////////////////////////////////////////////////
/*
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
     Area1.pi  , Area1.rect()  , Area1.triangle()
------------------------------------
[heap: 동적]            | [stack : 잠깐빌리기]
------------------------------------
*/


/*
연습문제1)  static
패키지명 : com.company.java010_ex
클래스명 :  StaticEx001
-- class Area1 작성해주세요   ※ pi값은 3.14159
public class StaticEx001{
  public static void main(String[] args) {  
   System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);
   System.out.println("사각형의 면적 : " + Area1.rect(10, 5));
   System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));
  }
} 

출력내용 : 
원의 면적    : 314.159
사각형의 면적 : 50.0
삼각형의 면적 : 25.0
*/