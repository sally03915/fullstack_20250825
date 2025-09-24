package com.company.java010_ex;  //##2

import com.company.java010.Milk; //##3

public class ModifierEx002 {
	public static void main(String[] args) {
	      Milk m1 = new Milk();  
	      System.out.println( m1 );  
	      m1.setMprice(2000);       
	      System.out.println( m1 );
	}
}




/*
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
> Milk.class   ,  ModifierEx002.class
------------------------------------
[heap: 동적]            | [stack : 잠깐빌리기]
------------------------------------
*/




/*

연습문제2)  지정접근자
패키지명 : com.company.java010_ex
클래스명 : ModifierEx2
다음과 같이 코드를 작성하시오.
ㅁ출력된화면
   Milk [mno=0, mname=null, mprice=0]
   Milk [mno=0, mname=null, mprice=2000]
   
ㅁ주어진조건
public class Milk{  // java010_ex에 설정해주세요!
   private int  mno;   
   private String mname;  
   private  int mprice;  
}
public class ModifierEx2{ // java010 패키지에 설정해주세요.
   public static void main(String[] args) {
      Milk m1 = new Milk();  
      System.out.println( m1 );  
      m1.setMprice(2000);       
      System.out.println( m1 );
   } // end main
} // end class
*/