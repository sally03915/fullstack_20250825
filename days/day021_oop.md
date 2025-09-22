## Track001 -  github
 


# ■ Github   
### 12. 깃허브 협업 

---
1. html + css + js/jquery 
2. spring + mybatis + jstl  
3. node + react
4. spring boot + thymeleaf + jpa + mybatis + react  
5. flutter + spring boot + jpa + mybatis + react
     

# ■ JAVA
● 1. class?
1. 자바의 저장단위
- 변수  <  배열   < 클래스 (변수,배열 + 메서드)

2. 클래스(class)
- 부품객체
- 설계도 (레고설계도)
- 상태(멤버변수)와 행위(멤버함수)를 갖는다. 

3. ★ oop?
- Object Oriented Programming
-   객체     지향   프로그래밍
-    틀      기반   프로그래밍
-  부품객체(클래스)  조립  완성된 프로그램 만드는 기법

4. 클래스와 객체들( 각각 인스턴스)
- 1. 클래스 (설계도)로    예) 붕어빵[틀] , 레고설계도
- 2. 인스턴스화를  통해 ( new  실제 메모리 - heap에 객체만들기 ) 예) 만들기, 조립
- 3.      객체(Object)      예)  붕어빵[들] / 우주탐사 레고장난감들  
- 4.          인스턴스          예) 팔붕어빵, 슈크림붕어빵 각각 /  비행선장난감,  여행객,,,

>  클래스는 설계도
>  인스턴스는 실제로 만들어진 객체


연습문제1)  class
패키지명 : com.company.java009_ex
클래스명 :  ClassEx001
class Student001{
  멤버변수 : String name;  int no, kor, eng, math;
  멤버함수 : void info()
}

public class ClassEx001{
   public static void main(String[] args) {
      Student001   s1 = new Student001();
     s1.name="first";  s1.no=11; s1.kor=100; s1.eng=100; s1.math=99;
     s1.info();
   }
}
출력내용 : 
  이름: first
  총점 : 299
  평균 : 99.67


연습문제2)  class
패키지명 : com.company.java009_ex
클래스명 :  ClassEx002
class MyPrice001{
  멤버변수 : String name;  int price;
  멤버함수 : void input()  입력받는 기능 / void show()  출력해주는 기능
}
public class ClassEx002{
   public static void main(String[] args) {
        MyPrice001   p1 = new MyPrice001();
        p1.input();
        p1.show();
   }
}
출력내용 : 
  상품이름 입력 >  apple
  상품가격 입력 >  1500

  상품정보입니다
  상품이름 : apple  / 상품가격 : 1500



● 2. 생성자
1. 생성자
 - new 연산자에 의해 호출 [초기화] 담당

2. 기본생성자 (디폴트 생성자)
 - 모든클래스에 생성자가 반드시 존재
 - 생성자 선언을 생략하면 컴파일러가 자동으로 기본생성자 추가
 - 개발자가 선언시 컴파일러가 자동생성을 취소

3. 생성자형식
class A{
   public A(){}   // 기본생성자
   public A( String name){} // 파라미터, 알규먼트가 있는 생성자
}

1) 리턴값 없음
2) 클래스명과 동일
3) 디폴트생성자를 생성해야하는 경우 : 오버로딩, 상속

4. 초기화순서
기본값      명시적초기화      초기화블록     생성자



 

# ■ Java 복습문제
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Q1. CLASS  vs  INSTANCE  의 차이점?


Q2.  다음코드를 보고 빈칸을 채우시오
-------------------------------------------------
A11 a1 = new A11();
-------------------------------------------------
1. 메모리빌려오고 객체생성하는 역할 :   (    )
2. String null, int는 0으로 초기화 : (    )
3. new A11() 한 주소를 갖고 있는 것은 : (    )


Q3.  생성자
1.  역할?  (    ) 
2.  [클래스 생성]할때 제일먼저 실행되는 특수한형태의 메서드
3. 생성자는 리턴값이    (    )   
4. 클래스명과 이름이 (    )


Q4. 기본생성자를 반드시 선언해야하는 경우
     (      /     )
 
Q5.  다음코드를 확인하고 클래스를 작성시 RUNTIME DATA AREA 의 빈칸을 채우고 설명하시오.
----------------------------------------------------------------------------------------------------------------
class  Tv002{
     String channel;      int volume;
     public Tv002(){  }
     public Tv002(String channel,  int volume){ 
    	this.channel = channel;   this.volume = volume;
     }
     public void show(){
         System.out.println( "Tv채널 > " + channel );
         System.out.println( "Tv볼륨 > " + volume;);
     }
    public void input(){
         Scanner scanner = new Scanner(System.in);
         System.out.print( "Tv채널 > "  ); channel = scanner.next();
         System.out.print( "Tv볼륨 > "  ); volume = scanner.nextInt();
    }
}
public class Test{
    public static void main(String[] args){
    	Tv002  a1 = new Tv002(  "MBC" , 6 );   a1.show();
    	Tv002  a2 = new Tv002();     a2.input(); a2.show();
    }
}

----------------------------------------------------------------------------------------------------------------

파일명    :    (          )    
위의 코드에서 생성되는 클래스명 : (      /      )
----------------------------------------------------------------
[method 정보]  (    )
----------------------------------------------------------------
[heap]                             |   [stack]
2000번지{channel=null, volume=0}  <------ (    )       ]

1000번지{channel=MBC, volume=6} <------ (    )     ] 
		                      |  [main]
----------------------------------------------------------------



Q6.   클래스에서 사용가능한 변수들의 범위와 역할
6-1. 자바메모리구조 - RUNTIME DATA AREA
6-2. 
1) (    ) area : 정보저장
2) (    ) area : 실체화(객체-인스턴스)저장 , Garbage Collector가 처리 
3) (    ) area : 임시값 저장 , 메서드의 작업공간 , 지역변수 잠깐사용되는 데이터

>>>>>>>>>>> Java Answer
1. 클래스는 부품객체
2. OOP 
3. 클래스 - 부품객체 특징 - 멤버변수/멤버함수

Q1. CLASS  vs  INSTANCE  의 차이점?
    설계도       실체화한것( new )
    붕어빵틀      붕어빵들 (객체)
    			   각기 다른특징을 가진다.(인스턴스)


Q2.  다음코드를 보고 빈칸을 채우시오
-------------------------------------------------
A11 a1 = new A11();
-------------------------------------------------
1. 메모리빌려오고 객체생성하는 역할    :   (  new    )
2. String null, int는 0으로 초기화 :  (  A11()  )
3. new A11() 한 주소를 갖고 있는 것은 : (  a1  )


Q3.  생성자
1.  역할?  (  초기화  ) 
2.  [클래스 생성]할때 제일먼저 실행되는 특수한형태의 메서드
3. 생성자는 리턴값이    (  없음  )   
4. 클래스명과 이름이 (   동일하다  )

   리턴값  메서드명(파라미터)
   
   

Q4. 기본생성자를 반드시 선언해야하는 경우
     ( 오버로딩 / 상속    )
 
Q5.  다음코드를 확인하고 클래스를 작성시 RUNTIME DATA AREA 의 빈칸을 채우고 설명하시오.
----------------------------------------------------------------------------------------------------------------
class  Tv002{
//멤버변수
     String channel;      int volume;
//멤버함수
     public Tv002(){  }
     public Tv002(String channel,  int volume){ 
    	this.channel = channel;   this.volume = volume;
     }
     public void show(){
         System.out.println( "Tv채널 > " + channel );
         System.out.println( "Tv볼륨 > " + volume;);
     }
    public void input(){
         Scanner scanner = new Scanner(System.in);
         System.out.print( "Tv채널 > "  ); channel = scanner.next();
         System.out.print( "Tv볼륨 > "  ); volume = scanner.nextInt();
    }
}
public class Test{
    public static void main(String[] args){
    	Tv002  a1 = new Tv002(  "MBC" , 6 );   a1.show();
    	Tv002  a2 = new Tv002();     a2.input(); a2.show();
    }
}

----------------------------------------------------------------------------------------------------------------

파일명    :    (   Test.java   )    
위의 코드에서 생성되는 클래스명 : (   Tv002.class   /   Test.class     )

----------------------------------------------------------------
[method 정보]  (    )
----------------------------------------------------------------
[heap 동적]                             |   [stack 임시]
											a2.show(){}
											a2.input(){}
2000번지{channel=null , volume=0 }  <------ (a2 :2000번지    )       ]
											a1.show(){}
1000번지{channel=MBC, volume=6}   <------ (  a1 :1000번지  )       ] 
		                      |  [main]
----------------------------------------------------------------

Q6.   클래스에서 사용가능한 변수들의 범위와 역할
6-1. 자바메모리구조 - RUNTIME DATA AREA
6-2. 
1) (   method ) area : 정보저장
2) (   heap   ) area : 실체화(객체-인스턴스)저장 , Garbage Collector가 처리 
3) (   stack  ) area : 임시값 저장 , 메서드의 작업공간 , 지역변수 잠깐사용되는 데이터



# ■ Web Basic 복습문제
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
[실기]
0. 스크립트가 document어느위치에서든지 동작가능하게
1. 아이디가 addEventEx인것을  getElementById 이용해 선택
2. 클릭시 prompt이용해서 당신이 좋아하는 1~5사이의 숫자 물어보고
3. alert이용해서 알림창띄우기  

<input type="button"  value="addEventEx-1~5 Like"  
        title="버튼5"  id="addEventEx"  class="btn btn-success" />





>>>>>>>>>  WEB BASIC-ANSWER 

```js
     window.addEventListener("load" , function(){ 
        document.getElementById("addEventEx").onclick=function(){
          let like = prompt("좋아하는 숫자1~5" , "1~5");
          alert("좋아하는 숫자는 " + like + "입니다.");
        }; 
     });   
```        