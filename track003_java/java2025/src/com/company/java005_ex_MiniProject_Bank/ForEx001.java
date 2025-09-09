package com.company.java005_ex_MiniProject_Bank;

public class ForEx001 {
	public static void main(String[] args) {
		//	q1  for문을 이용해서 다음과 같이 출력하시오 :   1 2 3 4 5 
		System.out.println("\n\nq1");
		for(int i=1; i<=5; i++) {  System.out.print(i + "\t");}
		
		//	q2  for문을 이용해서 다음과 같이 출력하시오 :   5 4 3 2 1 
		System.out.println("\n\nq2");
		for(int i=5; i>=1; i--) {  System.out.print(i + "\t");}
		
		//	q3  for문을 이용해서 다음과 같이 출력하시오 :   JAVA1   JAVA2  JAVA3  
		//		System.out.print("JAVA" + 1 + "\t"); 
		//		System.out.print("JAVA" + 2 + "\t"); 
		//		System.out.print("JAVA" + 3 + "\t");

		System.out.println("\n\nq3");
		for(int i=1; i<=3; i++){ System.out.print("JAVA" + i + "\t"); }
		
		//	q4  for문을 이용해서 다음과 같이 출력하시오 :   HAPPY3   HAPPY2  HAPPY1  
		System.out.println("\n\nq4");
		for(int i=3; i>=1; i--){ System.out.print("HAPPY" + i + "\t"); }
		
		//	q5  for문을 이용해서 다음과 같이 출력하시오 :   0,1,2  
		System.out.println("\n\nq5-1");
		System.out.print(" " +  0   );
		System.out.print("," +  1   );
		System.out.print("," +  2  );   //##  {}     {변수}   for(시작; 종료; 변화){}
		 
		System.out.println("\n\nq5-2");
		for(int i=0; i<=2; i++){  System.out.print( (i==0? "":  ",") +  i   );  }
		
		//	q6  for문을 이용해서 다음과 같이 출력하시오 :   0,1,2, ,,,중간생략 ,,, 99  
		System.out.println("\n\nq6");
		for(int i=0; i<=99; i++){  System.out.print( (i==0? "":  ",") +  i  );  }
		
		//	q7  for문을 이용해서 다음과 같이 출력하시오 :   10, 9,,,,중간생략 ,,, , 1 
		System.out.println("\n\nq7");
		for(int i=10; i>=1; i--){  System.out.print( (i==10? "":  ",") +  i  );  }
		
		//	q8  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 
		System.out.println("\n\nq8");
		for(int i=0; i<=8; i=i+2){  System.out.print( (i==0? "":  ",") +  i  );  }
		
		//	q9  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 ,,,중간생략 ,,, 18 
		System.out.println("\n\nq9");
		for(int i=0; i<=18; i=i+2){  System.out.print( (i==0? "":  ",") +  i  );  }
		
	}
}

/*
연습문제1)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx001
출력내용 :   for 이용
q1  for문을 이용해서 다음과 같이 출력하시오 :   1 2 3 4 5 
q2  for문을 이용해서 다음과 같이 출력하시오 :   5 4 3 2 1 
q3  for문을 이용해서 다음과 같이 출력하시오 :   JAVA1   JAVA2  JAVA3  
q4  for문을 이용해서 다음과 같이 출력하시오 :   HAPPY3   HAPPY2  HAPPY1  
q5  for문을 이용해서 다음과 같이 출력하시오 :   0,1,2  
q6  for문을 이용해서 다음과 같이 출력하시오 :   0,1,2, ,,,중간생략 ,,, 99  
q7  for문을 이용해서 다음과 같이 출력하시오 :   10, 9,,,,중간생략 ,,, , 1 
q8  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 
q9  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 ,,,중간생략 ,,, 18 
*/