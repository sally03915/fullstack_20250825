package com.company.java014_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx002 {
	public static void main(String[] args) {
		//변수
		Scanner scanner = new Scanner(System.in);
		List<String> list = new ArrayList<>();   // add, get, size, remove, contains
		int num=-1;
		//입력
		list.add("one");  list.add("two");  list.add("three");
		System.out.print("1,2,3 입력>");
		num = scanner.nextInt();
		
		//처리 - if/ switch/ for
		// if(만약 입력한값이 1이라면 ){one}
		// if( num == 1 ){list.get(0);}     list.get(num-1);
		// if( num == 2 ){list.get(1);}     list.get(num-1);
		// if( num == 3 ){list.get(2);}     list.get(num-1);
		//출력
		System.out.println(  list.get(num-1)   );
	}
}

/*
연습문제2)  Collection  Framework
패키지명 : com.company.java014_ex
클래스명 : ListEx002
1.  numbers ArrayList 만들기
2.  one, two, three 데이터 추가
3.  사용자에게 1,2,3 입력받기
4.  1을 입력받으면 one 출력
    2를입력받으면 two 출력
    3을입력받으면 three 출력
*/