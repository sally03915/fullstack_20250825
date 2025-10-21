package com.company.java015_labmda_stream;

import java.util.Arrays;
import java.util.List;

public class Stream003 {
	public static void main(String[] args) {
		Integer[]  ages = {17 , 21, 26 , 45, 18};  // 객체
		
		// Ex1
		double avg	  = Arrays.stream(ages)
							  .mapToInt(age -> age)  //객체는 기본값
							  .average()  //평균값처리
							  .orElse(0.0);  // 값없으면 0.0
		System.out.println("평균나이 : " + avg);
		System.out.println();
		
		//Ex2  짝수만 출력   
		System.out.println("\n\nEx2");
		Arrays.stream(ages)     //step1) 스트림만들기 
			  .filter(t->t%2==0)//step2) 짝수필터링 -filter 이용   (t)-> return
			  .forEach(System.out::print);   //step3) 출력  -  forEach  (t)-> x
		
		//Ex3  성이 김씨인친구들
		System.out.println("\n\nEx3");
		List<String> names = Arrays.asList("김수지" , "이나영" , "김나영" , "유재석" , "강호동");
		System.out.println(names.get(0).startsWith("김"));  // 힌트) 문자열에서 startWith("문자") 시작하는
		
		names.stream()//step1) 스트림만들기 
			 .filter(t-> t.startsWith("김"))//step2) 김으로 시작하는 값찾기 -filter 이용  (t)->{ return  }
			 .forEach(System.out::print);//step3) 출력  -  forEach
		
		//Ex4  names  정렬후 출력
		System.out.println("\n\nEx4");  
		names.stream()
			 .sorted()
			 .forEach(System.out::print);
		
		//Ex5  제일 나이 많은(max) 사람
		System.out.println("\n\nEx5");
		//               1단계-스트림      객체를 숫자로        최대값     못찾으면 -1
		int max= Arrays.stream(ages).mapToInt(age->age).max().orElse(-1);
		System.out.println(max);
		
	}
}

