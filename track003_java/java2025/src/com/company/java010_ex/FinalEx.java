package com.company.java010_ex;

//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수)와 행위(멤버함수)
class User002 {
	// 멤버변수
	final String nation = "Korea";
	final String jumin;
	String name;

	// 멤버함수
	public User002() { jumin = "00000"; }
	public User002(String jumin, String name) {
		this.jumin = jumin;
		this.name = name;
	}
}
public class FinalEx {
	public static void main(String[] args) {
		User002 user1 = new User002("123456-1234567", "아이유");
		System.out.println(user1);

		//user1.nation = "USA";  // cannot be assigned
		//user1.jumin  = "123123-1234321";  // final
		user1.name = "IU";
		System.out.println(user1);
	}
}