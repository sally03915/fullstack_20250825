
## Track003 - JAVA
#### 1. java?
- 한 번 작성하면 어디서든 실행된다.
- JDK 설치 -> 작성 -> 컴파일 -> 실행
- JVM 운영체제의 다른차이점을 처리해줘 
  개발자는 프로그램 작성만 집중
- 객체지향언어

#### 2. java setting  (1) 자바다운로드 및 설치
1) java.sun.com    
2) https://www.oracle.com/java/technologies/?er=221886
3) 설치
4) C:\Program Files\Java  폴더찾기
   C:\Program Files\Java\jdk-11

#### 3. java setting  (2) 환경설정
1) 내컴퓨터 - [속성] - 시스템속성 - 환경변수 - 시스템변수
   JAVA_HOME      
   C:\Program Files\Java\jdk-11

   Path           
   %JAVA_HOME%\bin

2) cmd
   java  -version   

#### 4. java setting  (3) ECLIPSE 설치
1) eclipse.org
2) [download] - Eclipse IDE for Java EE Developers

#### 5. java setting  (4) ECLIPSE 셋팅
1) perspective : 개발에 유용한 view들 만 묶어놓은 작업창
   window - perspective - open perspective - [java]
2) utf-8
   window - preferences - 검색 [enc] 
3) 이클립스 단축키
  - 명령어 불러오기  ctrl + space
  - 주석           ctrl + shift + /     (\)
  - import        ctrl + shift + o
  - 정렬           crtl + shift + f
  - 한줄정렬       ctrl + alt + j

#### 6. 처음으로 작성해본 자바
```bash
package com.company.java001;  // 1.부품의 위치

// 주석 , 설명
public class A000 { // 2. 어디에서든지 접근 , 부품객체 , 부품이름(클래스이름)
      public          static          void main(String[] args) { 
// 3. 어디에서든지 접근 , 바로사용가능 메모리 , void main(String[] args) 전원버튼이름 
    	  System.out.println("Hello Java");
    	//4.운영체제부품객체. 출력(cmd) . println("하고싶은말") 출력
      }
} // end class   

// ctrl + f11 ( 실행 )
```

> Q) 패키지명 : com.company.java001_ex
>    클래스명 : A000_ex.java
>    "한 번 작성하면 어디서든 실행된다."  출력
```bash
package com.company.java001_ex;  //경로위치

public class A000_ex {// 아무데서나 접근가능 , 부품객체
	public static void main(String [] args) {
		System.out.println("한 번 작성하면 어디서든 실행된다.");
	}
}
//> Q) 패키지명 : com.company.java001_ex
//>    클래스명 : A000_ex.java
//>    "한 번 작성하면 어디서든 실행된다."  출력
```


#### 7. 출력
System.out.print("Hello");   // 줄바꿈안됨.
System.out.println("Hello");   // 줄바꿈 됨.
System.out.println("Hello\nSally");   // 줄바꿈.
// 포맷형식  %s , %d
System.out.printf("이름 : %s  나이: %d " , "길동"  , 12 );

```bash
package com.company.java001;

public class A002 {
	public static void main(String[] args) {
		System.out.println("A");
		System.out.println("AB");
		System.out.println("ABC"); // 여러줄사용
		
		// 한줄로만드는 방법은?
		System.out.println("A\nAB\nABC");  // 줄바꿈  \n
		
		// 포맷형식  %s , %d
		System.out.printf("이름 : %s  나이: %d " , "길동"  , 12 );
	}
}