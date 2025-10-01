package com.company.java011;

/*  상속 : 클래스의 재사용 
    Objecet (실선-속이빈화살표)  ■3) Object{                                          ■4) }  
      ↑
   Animal    ■2) Animal()   {              name=null,age=0 / eat(), sleep(), poo()■5) }
   ↑	↑    ■1) Cat()      {                             animal_card / qukquk()  ■6) }          
Person  Cat	 ■0) 1번지,객체생성(method area)             
-----------------------------------------------
Cat sally = new Cat();
-----------------------------------------------
1) Cat은 Animal이다   ↑
2) 생성자호출 : Cat()   →  Animal() → Object()
3) 객체생성   : Object →   Animal   →  Cat
*/
class Animal{ 
	String name;
	int    age;
	void eat  () {System.out.println("먹고");}
	void sleep() {System.out.println("자고");}
	void poo  () {System.out.println("배변");}
	public Animal() { super(); } 
}
class Cat extends Animal{
	String animal_card;
	public Cat() { super(); }
	void qukquk() {  System.out.println(this.name + "-꾹꾹이");}
} 
public class Extends002 {
	public static void main(String[] args) {
		Cat sally = new Cat();
		sally.name="kitty"; sally.age =52;
		sally.animal_card="ani-1234";
		sally.eat(); sally.sleep(); sally.poo();  sally.qukquk();
	}
}
