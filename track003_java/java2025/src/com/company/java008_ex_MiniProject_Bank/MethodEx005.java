package com.company.java008_ex_MiniProject_Bank;

import java.util.Scanner;

public class MethodEx005 {
	
	public static  int    process_total(int  kor , int eng, int math){ return kor + eng + math; } 

	public static float    process_avg(int total){  return  total/3f; }
	
	public static String    process_pass(float avg , int kor, int eng, int math){ 
		return  avg<60 ? "불합격" : kor<40 || eng<40 || math<40 ? "재시험" : "합격";
	} 	      
 
	public static  int  inputNum( String subject){ 
	     Scanner scanner = new Scanner(System.in);
		 System.out.print( subject+ "입력 > ");  
		 return scanner.nextInt(); 
	}
	
	public static  String  inputString( String title){ 
	     Scanner scanner = new Scanner(System.in);
		 System.out.print( title+ "입력 > ");  
		 return scanner.next(); 
	}
	public static void main(String[] args) {
		  /////////////////////(1)  변수
	      String name  = ""; 
	      int kor, eng, math, total=0 ;
	      float avg = 0.0f; 
	      String pass = "", jang = "" ,  star= "";  
	      Scanner scanner = new Scanner(System.in);
	      
	      /////////////////////(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.
			//	      System.out.print("이름입력 > ");  name  = scanner.next();
			//	      System.out.print("국어입력 > ");  kor   = scanner.nextInt();
			//	      System.out.print("영어입력 > ");  eng   = scanner.nextInt();
			//	      System.out.print("수학입력 > ");  math  = scanner.nextInt();
	      
	      name  = inputString("이름");
	      // public static  int  inputNum( String subject){  System.out.print( subject+ "입력 > ");  return scanner.nextInt();  }
	      //   System.out.print("국어입력 > ");  kor   = scanner.nextInt();   / 다른점 "국어" , "영어" , "수학"
	      kor   =inputNum("국어");     eng   =inputNum("영어");     math  =inputNum("수학");
	      
	      /////////////////////(3) 처리 : 
	      // public static 리턴값    메서드명(파라미터){  해야할일 }
	      // public static  int    process_total(int  kor , int eng, int math){ 총점처리 } 
	                       total = process_total(kor , eng, math);    // 1. 총점처리
	      // public static float    process_avg(int total){  평균처리 }
	                       avg   = process_avg(total);     
	      // public static String    process_pass(float avg , int kor, int eng, int math){  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면   } 	      
	                       pass = process_pass(avg , kor, eng, math);  
 	      // public static String    process_scholar(float avg){  평균이 95점이상이면 장학생 } 
	                       jang = process_scholar(  avg  ); 

 	      // public static String    process_star(float avg){  평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개  } 
	                       star = process_star(avg);    
	      /////////////////////(4) 출력
	      //	public static 리턴값 메서드명(파라미터) { 출력}
	      //	public static void process_show(String name,int kor, int eng,int math,int total,float avg, String pass, String jang,  String star) { 출력}
	      process_show(name, kor, eng, math, total, avg, pass, jang, star);
	}// end main
	
	public static String    process_scholar(float avg){ return avg<95 ? "":"장학생"; } 
	public static String    process_star(float avg){  
		String result="";
		// 93-> 9   95->9  98-> 9       [99.67 /10 -> (int)9.967 -> 9]
		for(int i=0; i<(int)(avg/10); i++) {   result += "★";  }
		return result;
		//평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9 (93,95,98) , 100점이면 별10개 
	} 

	
	public static void process_show(String name, int kor, int eng,int math,
			   int total,float avg, String pass, String jang,  String star) { 
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\n"
								, "NAME", "KOR" , "ENG" , "MATH","TOTAL", "AVG" , "PASS","장학생", "LEVEL" );
		System.out.println("--------------------------------------------------------------------------- ");
		System.out.printf("%-5s\t%-5d\t%-5d\t%-5d\t%-5d\t%-5.2f\t%-5s\t%-5s\t%-5s\n"
				, name,  kor ,eng , math,total, avg , pass,jang, star );
		System.out.println("--------------------------------------------------------------------------- ");
	}
 
} // end class

/*
연습문제5)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx005

public class MethodEx005{ 
   public static void main(String[] args) {
   /////////////////////(1)  변수
      String name  = ""; 
      int kor, eng, math, total ;
      float avg = 0.0f; 
      String pass = "";
      String jang = "";
      String star= "";  
      Scanner scanner = new Scanner(System.in);
      
      /////////////////////(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.
   
      /////////////////////(3) 처리 : 
      total = process_total(kor , eng, math);    // 1. 총점처리
      
      avg = process_avg(total);    //2.  평균처리
      
      ////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
      pass = process_pass(avg , kor, eng, math);  
      
      //////// 4. 평균이 95점이상이면 장학생
      jang = process_scholar(  avg  ); 
      
      //////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
      star = process_star(avg);  
      
      
      /////////////////////(4) 출력
      process_show(name, kor, eng, math, total, avg, pass, jang, star);
    
      
   }// end main
 
   
}// end class

 
  ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
  이름      국어   영어   수학   총점  평균    합격여부   장학생   랭킹
  --------------------------------------------------------------------------------------------
  아이언맨   100   100   100   300    100.0    합격      장학생   **********
  --------------------------------------------------------------------------------------------
*/