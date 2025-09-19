package com.company.java008_ex_MiniProject_Bank;

import java.util.Arrays;

public class MethodEx008_1 {
	public static void  upper( char[] ch){
		// 'A'(65) = 'a'(97)-32 
		for(int i=0; i<ch.length; i++) {  ch[i]-=32; }
	    System.out.println("upper. 배열값 : "  + ch  +  Arrays.toString(ch)  ); 
	}
	///////////////////////////////////////////////
	public static void main(String[] args) {
	    char[] ch = {'a','b','c'};         
	    upper(ch);     
	    // public static 리턴값 메서드명(파라미터){ 해야할일 }
	    // public static void  upper( char[] ch){ 대문자로변경 }
	    /*   [heap]								[stack]
	     * 								   ←    upper(1000번지)
	         1000번지{ 'a','b','c'  }       ←    ch : 1000번지          	
	     */
	    System.out.println("main. 배열값 : "  +ch  +  Arrays.toString(ch)  );  // [A,B,C]
	}
	///////////////////////////////////////////////
}

/*
연습문제8)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx008

public class MethodEx008{ 
    char[] ch = {'a','b','c'};
    upper(ch);     
    System.out.println("main. 배열값 : "      +  Arrays.toString(ch)          );  // [A,B,C]
}
 
*/