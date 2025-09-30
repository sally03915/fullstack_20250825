package com.company.java013_ex;


abstract class Robot{
	String model;  int batteryLevel;
	void    myrobot() {System.out.println("로봇입니다.");}
	abstract  void charge();  // 충전방식  {}
	abstract  void move();    // 이동방식
	abstract  void speak();   // 말하기방식
} 
class   CleaningRobot extends Robot{
	@Override void charge() { System.out.print("청소로봇 충전 중... 배터리 "); }
	@Override void move()   { System.out.print("청소로봇: 청소 중"); }
	@Override void speak()  { System.out.println("청소로봇 : 먼지를 제거합니다!"); }
}

class   SecurityRobot extends Robot{
	@Override void charge() { System.out.print("경비로봇 태양광 충전 중... 배터리 "); }
	@Override void move()   { System.out.print("경비로봇 : 경비 중"); }
	@Override void speak()  { System.out.println("경비로봇: 이상 없음. 안전 확보!"); }
}

class   CookingRobot extends Robot{
	@Override void charge() { System.out.print("요리로봇 인덕션 충전 중... 배터리 "); }
	@Override void move()   { System.out.print("요리로봇: 요리만드는 중"); }
	@Override void speak()  { System.out.println("요리로봇: 오늘의 메뉴는 파스타입니다!"); }
}
  
public class AbstractEx001 {
	public static void main(String[] args) {
		//Robot robot  = new Robot();  // Q1.why? 
		System.out.println("\n--- 로봇 배열 시뮬레이션 ---");
		//   부모      =    자식1                       자식2                자식3
		Robot [] bots = { new CleaningRobot(), new SecurityRobot() , new CookingRobot() };
		int   [] levels = { 50, 70, 95 };
		
		//Q2. 
		for(int i=0; i<bots.length; i++) {
			bots[i].model = "Robo" +   (i+1); 
			bots[i].batteryLevel = levels[i];
			bots[i].charge();   System.out.println( bots[i].batteryLevel + "%");
			bots[i].speak();  
		}
// bots[0] = 1번지 CleaningRobot{@charge() , @move() , @speak() }-Robot{model="Robo1" ,batteryLevel=50 /---, ---, ---}
// bots[1] = 2번지 SecurityRobot{@charge() , @move() , @speak() }-Robot{model="Robo2" ,batteryLevel=70 /---, ---, ---}
// bots[2] = 3번지 CookingRobot {@charge() , @move() , @speak() }-Robot{model="Robo3" ,batteryLevel=95 /---, ---, ---}		
		
	}
}
/*  
   Abstract  : 일반클래스 + 설계 - 추상클래스: 공통기능 설계

Object
  ↑
 Robot {   abstract charge() , move() , speak() }
↑          ↑               ↑ 
CleaningRobot  SecurityRobot   CookingRobot	
{@charge() , 	{@charge() , 	{@charge() ,
@ move() , 	 	@move() ,       @move() , 
@ speak() }}    @speak() }}     @speak() }}
*/

/* Q1
heap area: 동적,배열			     stack area : 임시
1번지{model, battery, charge()X} ← robot(1번지)
*/

/*
연습문제1)
패키지명 : com.company.java013_ex 
클래스명 : AbstractRobotDemo.java 
주어진조건 : 
1) 상속도
	        Object
	          ↑
	         Robot {   abstract charge() , move() , speak() }
	↑          ↑               ↑ 
CleaningRobot  SecurityRobot   CookingRobot	
{@charge() , 	{@charge() , 	{@charge() ,
 @ move() , 	 @move() ,       @move() , 
 @ speak() }}    @speak() }}     @speak() }}

2)main
public class AbstractEx001 {
	public static void main(String[] args) {
		//Robot robot  = new Robot();  // Q1.why? 
		System.out.println("\n--- 로봇 배열 시뮬레이션 ---");
		Robot [] bots = { new CleaningRobot(), new SecurityRobot() , new CookingRobot() };
		int[] levels = { 50, 70, 95 };
	 
	}
}
 
출력화면 :  
--- 로봇 배열 시뮬레이션 ---
Robo1 청소로봇 충전 중... 배터리 50%
Robo1 청소로봇: 먼지를 제거합니다!
Robo2 경비로봇 태양광 충전 중... 배터리 70%
Robo2 경비로봇: 이상 없음. 안전 확보!
Robo3 요리로봇 인덕션 충전 중... 배터리 95%
Robo3 요리로봇: 오늘의 메뉴는 파스타입니다!
*/