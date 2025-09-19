package com.company.java008_total;

public class Test003_005 {
	public static void dog(){ System.out.println("멍멍");}
	public static void disp(int a, char ch){  for(int i=0; i<a; i++) { System.out.print(ch); } }
	public static String stdId(int a){   return  "G" + a;   } 
	 
	public static void main(String[] args) {
		// public static 리턴값 메서드명(재료){  해야할일 }
		//3   public static void dog(){ 멍멍}
		dog();   //멍멍
		
		//4   public static void disp(int a, char ch){   해당숫자만큼 문자 출력   }
		disp(7, '*');  // ****
	 
		//5   public static String stdId(int a){    G1111   } 
		System.out.println("당신의 학번은? " + stdId(1111));   //G1111	
	}
}

 /*
	public static void main(String[] args) {
		//3
		dog();   //멍멍
		
		//4
		disp(7, '*');  // ****
		

		//5
		System.out.println("당신의 학번은? " + stdId(1111));   //G1111
		
	}
*/