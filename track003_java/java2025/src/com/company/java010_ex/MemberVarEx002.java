package com.company.java010_ex;

//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기
	
/*   초기화 :  				기본값    			명시적초기화   					초기화블록   생성자  
   studentCount 			0         				= 0        					x 0
   maxScore					0         				= 100      					x 100
   /////////////////////////////////////////////////////////////////////////////////////////////////
   s1{name, kor, eng}	{name=null, kor=0, eng=0} {name=홍, kor=90, eng=85}  	X {name=홍, kor=90, eng=85} 
   s2{name, kor, eng}	{name=null, kor=0, eng=0} {name=홍, kor=90, eng=85}  	X {name=홍, kor=90, eng=85} 
*/															


class Student {
    String name = "홍길동";        // 인스턴스변수 - heap area - new O - 생성자 O  -  this (각각)
    int kor = 90;                 // 인스턴스변수 - heap area - new O - 생성자 O  -  this (각각)     
    int eng = 85;                 // 인스턴스변수 - heap area - new O - 생성자 O  -  this (각각)
    static int studentCount = 0;  // 클래스변수  - mehotd area - new X - 생성자 X -  static (now)  
  
    //static int total = this.kor + this.eng; // 클래스변수 - mehotd area - new X - 생성자 X -  static (now)
    							  //※ static 은  인스턴스(this) 사용불가
     
    static int maxScore = 100;    // 클래스변수 - method area - new X  - 생성자 X -  static (now)

    public Student() {   // 생성자
        studentCount++;  // static 사용가능        
    }
    public int getTotalScore() {   // 인스턴스메서드
        return this.kor + this.eng;        
    }
    public static void showStudentCount() { // 클래스메서드 -  mehotd area - new X - 생성자 X -  static (now)  
        System.out.println("전체 학생 수: " + studentCount);  
    }
   public static void showName() { // 클래스메서드 -  mehotd area - new X - 생성자 X -  static (now) 
       // System.out.println(this.name);  //※ static 은  인스턴스(this) 사용불가
   }
    public void showInfo() {  // 인스턴스메서드 - heaparea -  - new O - 생성자 O  -  this (각각)     
        System.out.println("이름: " + this.name);            
        System.out.println("총점: " + this.getTotalScore());    
    }
}
public class MemberVarEx002 {
	public static void main(String[] args) {
        Student s1 = new Student();     
        Student s2 = new Student();     

        s1.showInfo();                  
        Student.showStudentCount();   
	}
} 

/*
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
   Student.studentCount   , Student.maxScore  , Student.showStudentCount()  , Student.showName()
------------------------------------
[heap: 동적]            				| [stack : 잠깐빌리기]
2번지
{ name=홍, kor=90, eng=85 / 		   ←  s2 [2번지]		
 getTotalScore() , showInfo()}

1번지
{ name=홍, kor=90, eng=85 / 		   ←  s1 [1번지]		
 getTotalScore() , showInfo()}
					   				| main
------------------------------------
*/
 
/*   초기화 :  				기본값    			명시적초기화   					초기화블록   생성자  
studentCount 			0         				= 0        					x 0
maxScore					0         				= 100      					x 100
/////////////////////////////////////////////////////////////////////////////////////////////////
s1{name, kor, eng}	{name=null, kor=0, eng=0} {name=홍, kor=90, eng=85}  	X {name=홍, kor=90, eng=85} 
s2{name, kor, eng}	{name=null, kor=0, eng=0} {name=홍, kor=90, eng=85}  	X {name=홍, kor=90, eng=85} 
*/	

/*
패키지명 : com.company.java010_ex
클래스명 : MemberVarEx002

-- class Student 작성해주세요

- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
- 문제 3. 오류가 발생하는 이유를 설명하시오.
- 문제 4. runtime data area 위치영역 그림그리기

class Student {
    String name = "홍길동";        
    int kor = 90;                  
    int eng = 85;                 
    static int studentCount = 0;    

    static int total = kor + eng;   

    static int maxScore = 100;     

    public Student() {
        studentCount++;             
    }

    public int getTotalScore() {
        return kor + eng;        
    }

    public static void showStudentCount() {
        System.out.println("전체 학생 수: " + studentCount);  
    }

   public static void showName() {
         System.out.println(name);  
   }

    public void showInfo() {
        System.out.println("이름: " + name);            
        System.out.println("총점: " + getTotalScore());    
    }
}

public class MemberVarEx002 {
    public static void main(String[] args) {
        Student s1 = new Student();     
        Student s2 = new Student();     

        s1.showInfo();                  
        Student.showStudentCount();    
    }
}

*/