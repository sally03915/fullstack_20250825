package com.company.java008_ex_MiniProject_Bank;

public class MethodEx003 {
	 public static void printProfile(String name,  int age,  String loc){ 
		 System.out.println("=== 사용자 프로필 ===\r\n"
		 		+ "이름: "+name+"\r\n" + "나이: "+age+"\r\n" + "지역: "+loc+"\r\n"
		 		+ "===================");
	 }
	
	 public static void	checkAge(int age){  
		 System.out.println( age< 19? "미성년자입니다." : "성인입니다." );
	 }	
	 
	 public static void repeatMessage(String str, int num) {
		 for(int i=0; i<num; i++) { System.out.println( str);}
	 }	
	 
	 public static void drawBox(int num, char ch) {
		 for(int i=0; i<num; i++) {
			 for(int j=0; j<num; j++) {
				 System.out.print(ch);
			 }System.out.println();
		 }
	 }
	///////////////////////////////////////////////////
	public static void main(String[] args) {
	    // public static 리턴값 메서드명(파라미터) 
				printProfile("홍길동"     ,     25, "서울");   
				checkAge(17);                      // 미성년자 여부 판단 
		 	    repeatMessage("안녕하세요!", 3);     // 메시지 반복 출력
			    drawBox(5, '#');                   // 문자로 박스 출력
	}
	///////////////////////////////////////////////////
}
/*
■ 출력 예시
=== 사용자 프로필 ===
이름: 홍길동
나이: 25
지역: 서울
===================
미성년자입니다.
안녕하세요!
안녕하세요!
안녕하세요!
#####
#####
#####
#####


연습문제3)
패키지명 : com.company.java008_ex 
클래스명 : MethodEx003 다음과 같이 
printProfile(), checkAge(), repeatMessage(), drawBox() 메서드를 정의하시오.

public static void main(String[] args) {
    // public static 리턴값 메서드명(파라미터)
    printProfile("홍길동", 25, "서울");   // 이름, 나이, 지역 출력
    checkAge(17);                      // 미성년자 여부 판단
    repeatMessage("안녕하세요!", 3);     // 메시지 반복 출력
    drawBox(5, '#');                   // 문자로 박스 출력
}
■ 출력 예시
=== 사용자 프로필 ===
이름: 홍길동
나이: 25
지역: 서울
===================
미성년자입니다.
안녕하세요!
안녕하세요!
안녕하세요!
#####
#####
#####
#####
#####

*/