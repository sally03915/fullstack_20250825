package com.company.java010_ex;


//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기
//- 문제 5. 다음과 같이 출력되도록 코드를 작성하시오.

//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수)와 행위(멤버함수)

class LunchTray {
	//멤버변수 ( 1. 클래스변수: 공용,  2. 인스턴스변수:this(각각) , 3. 지역변수:임시)
    String owner;     // 인스턴스변수 - heap area - new O - 생성자O  - this
    int rice = 90;    // 인스턴스변수 
    int soup = 85;    // 인스턴스변수         

    static int trayCount = 0;   // 클래스변수 - method area - new X - 생성자 X - [now] 
    //static int totalFood = rice + soup;   // ★ static 은 this 사용불가
    static int maxRice = 100;   // 클래스변수 -  LunchTray.maxRice    

    //멤버함수
    public LunchTray() { 
    	//  owner 이름 : std-1 , 급식판수 숫자올리기 
    	this.owner = "std-" +    ++trayCount;
    }
    
    public int getFoodAmount() { return rice + soup; }  // 인스턴스 메서드 - heap - new O - 생성자O  - this
     
	public static void showTrayCount() { // 클래스메서드  
        System.out.println("전체 급식판 수: " + trayCount);   
    }

    public static void showOwner() { // 클래스메서드  
      // System.out.println(this.owner);  //★ static 은 this 사용불가
    }

    public void showTray() {
        System.out.println("\n\n:: 주인 이름: " + this.owner);  // this              
        System.out.println("총 음식량: " + getFoodAmount());    // static
    }
}
 

public class MemberVarEx003 {
	public static void main(String[] args) {
        LunchTray tray1 = new LunchTray();   // 1. new(메모리,객체)  2) 생성자(인스턴스변수초기화사용가능) 3) tray1 주소
        tray1.showTray();                    
        LunchTray.showTrayCount();     // 클래스.메서드()    

        LunchTray tray2 = new LunchTray();   
        tray2.showTray();                   
        LunchTray.showTrayCount();   
	}
}



/*
public LunchTray() { 
	//  owner 이름 : std-1 , 급식판수 숫자올리기 
	this.owner = "std-" +    ++trayCount;
}
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
>1. LunchTray.class , MemberVarEx003.class
>2. LunchTray.trayCount=2 [공용]      , LunchTray.maxRice , 
    LunchTray.showTrayCount() , LunchTray.showOwner()
------------------------------------
[heap: 동적]            			 | [stack : 잠깐빌리기]
									tray2(2번지).showTray();
2번지{owner=std-2,rice=90,soup=85} ← tray2[2번지] 
									tray1(1번지).showTray();
1번지{owner=std-1,rice=90,soup=85} ← tray1[1번지]
					   			 | main
------------------------------------
*/
/*
            초기값   명시적초기화   초기화블록   생성자
///////////////////////////////////////////////////	
trayCount		0		= 0     X 0       2    공용으로사용관련X
maxRice			0		= 100   X 100        생성자안에서 클래스변수 사용가능
///////////////////////////////////////////////////			
owner		null	X null	    X null    X "std-2"	(this)    	this.owner = "std-" +    ++trayCount;
rice           0        90      X  90     X   90    
soup           0        85      X  85     X   85
///////////////////////////////////////////////////
*/

/*

연습문제3)  멤버변수
패키지명 : com.company.java010_ex
클래스명 :  MemberVarEx003
//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기
//- 문제 5. 다음과 같이 출력되도록 코드를 작성하시오.
:: 주인 이름: std-1
총 음식량: 175
전체 급식판 수: 1


:: 주인 이름: std-2
총 음식량: 175
전체 급식판 수: 2

 
class LunchTray {
    String owner;        
    int rice = 90;               
    int soup = 85;               

    static int trayCount = 0;      

    static int totalFood = rice + soup;

    static int maxRice = 100;       

    public int getFoodAmount() {
        return rice + soup;         
    }

    public static void showTrayCount() {
        System.out.println("전체 급식판 수: " + trayCount);   
    }

    public static void showOwner() { 
       System.out.println(owner);
    }

    public void showTray() {
        System.out.println("\n\n:: 주인 이름: " + owner);                
        System.out.println("총 음식량: " + getFoodAmount());     
    }
}


public class MemberVarEx003 {
	public static void main(String[] args) {
        LunchTray tray1 = new LunchTray();   
        tray1.showTray();                    
        LunchTray.showTrayCount();         

        LunchTray tray2 = new LunchTray();   
        tray2.showTray();                   
        LunchTray.showTrayCount();         
	}
} 



*/