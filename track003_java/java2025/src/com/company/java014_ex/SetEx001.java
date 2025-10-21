package com.company.java014_ex;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set; 
// set : 순서X, 중복허용 X  - add , get, size, remove, contains
class UserInfo2{
	 private int no; private  String name; private  int age;
	 //Q1. 생성자, 필드생성자, toString, getters/setters , hashCode / equals
	 public UserInfo2() { super(); }
	 public UserInfo2(int no, String name, int age) { super(); this.no = no; this.name = name; this.age = age; }
	 @Override public String toString() { return "UserInfo2 [no=" + no + ", name=" + name + ", age=" + age + "]"; }
	 public int getNo() { return no; } public void setNo(int no) { this.no = no; } public String getName() { return name; } public void setName(String name) { this.name = name; } public int getAge() { return age; } public void setAge(int age) { this.age = age; }
	 // 클래스UserInfo2 인지확인
	 @Override public int hashCode() { return Objects.hash(age, name, no); }
	 // 인스턴스안의 값확인
	 @Override public boolean equals(Object obj) { if (this == obj) return true; if (obj == null) return false; if (getClass() != obj.getClass()) return false; UserInfo2 other = (UserInfo2) obj; return age == other.age && Objects.equals(name, other.name) && no == other.no; }
}
public class SetEx001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Set<UserInfo2> sets = new HashSet<>();  //Q2.
		// Q3. sets 에  UserInfo2 데이터 넣기
		sets.add(new UserInfo2(1, "아이언맨" , 50));
		sets.add(new UserInfo2(2, "헐크" , 40));
		sets.add(new UserInfo2(3, "캡틴" , 120));  //주소
		sets.add(new UserInfo2(3, "캡틴" , 120));  //주소
		// Q4. 향상된 for / Interator 이용해서 데이터 출력 (3명만 출력되게- 같은자료 중복안되게) equals/hashCode
		double avg = 0.0;
		for( UserInfo2 u: sets) {
			System.out.println(u.getNo() + " - " + u.getName() + " - " + u.getAge());
			avg += u.getAge();
		}
		// Q5. 사용자들의 이름 입력받기 - 이름을 입력받으면 해당하는  유저의 자료출력
		System.out.println("> 찾을 유저이름 : ");
		String find = scanner.next();
		for(UserInfo2 u: sets) {
			if(u.getName().equals(find)) {  System.out.println(u);  break; }
		}
		// Q6. 사용자들의 나이 평균처리
		System.out.println("나이평균 > " + avg/sets.size());
	}
}
/*
연습문제1)  Collection  Framework  
패키지명 : com.company.java014_ex
클래스명 : SetEx001
1. UserInfo2    Dto 클래스만들기  - 속성 : private int no; private  String name; private  int age;
2. users   HashSet만들기
3. 다음의 데이터 넣기
   new UserInfo2(1, "아이언맨" , 50) , 
   new UserInfo2(2, "헐크" , 40) , 
   new UserInfo2(3, "캡틴" , 120), 
   new UserInfo2(3, "캡틴" , 120)
4. 향상된 for / Interator 이용해서 데이터 출력 (3명만 출력되게- 같은자료 중복안되게)
5. 사용자들의 이름 입력받기 - 이름을 입력받으면 해당하는  유저의 자료출력
6. 사용자들의 나이 평균처리

*/
