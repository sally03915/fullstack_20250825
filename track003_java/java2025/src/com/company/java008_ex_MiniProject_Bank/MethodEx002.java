package com.company.java008_ex_MiniProject_Bank;

public class MethodEx002 {
	public static  void  test1(int a){ System.out.println(a); }
	public static  void  test2(double a){ System.out.println(a);  }	
	public static  void  hap(int a, int b){  
		int total=0;
		for(int i=a; i<=b; i++){total +=i;} // a~b까지 더한값   
		System.out.println(total);
	} 
	public static  void disp(int num, char ch){ //받은숫자만큼 문자 출력  
		for(int i=0; i<num; i++){System.out.print(ch);}
	}
	////////////////////////////////////////////
	public static void main(String[] args) {
	    // public static  리턴값 메서드명(파라미터) 
								test1(10);    //10 출력							
								test2(1.2);   // 1.2 출력							
								hap(3,5);     // 3+4+5한값  12 출력						
								hap(1,10);    
								disp(7, '*');  // *******출력
	}// end main
	////////////////////////////////////////////
} // end class
/*
연습문제2)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx002
다음과 같이 test1(), test2(), hap(), disp()메서드를 정의하시오.

public static void main(String[] args) {
    // public static  리턴값 메서드명(파라미터)
     test1(10);    //10 출력
     test2(1.2);   // 1.2 출력
     hap(3,5);     // 3+4+5한값  12 출력
     disp(7, '*');  // *******출력
}

*/