package com.company.java008_ex_MiniProject_Bank;

public class MethodEx007 {
    public static int  add(int x, int y) {return x+y;} //1
   
    public static int  add(byte x, byte y)   {return x+y;} //2   
    public static int  add(short x, short y) {return x+y;} //3   
//  public static long add(int  a, int b)    {return x+y;} //4  
    public static long add(long  x, long y)  {return x+y;} //5 
    
	public static void main(String[] args) {
		//Q1. 메서드오버로딩?   - 비슷한 목적의 메서드 이름을 같게하는것.
		//Q2. 왜오류? 이유달기  - 파라미터의 개수와 자료형으로 구분
		//   1,4 번의 파라미터의 자료형이 같음!
	} 
}

/*
연습문제7)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx007
오류나는 메서드는?

public class Method007_ex {
   public static int add(int x, int y) {return x+y;}
   
   public static int  add(byte x, byte y)   {return x+y;}   
   public static int  add(short x, short y) {return x+y;}   
   public static long add(int  x, int y)    {return x+y;}   
   public static long add(long  x, long y)  {return x+y;}   
   
   public static void main(String[] args) { 
   }
}
*/