package com.company.java006_ex;

import java.util.Scanner;

public class ArrayExUpgrade001 {
	public static void main(String[] args) {
		char [] answer = {'A', 'C', 'B', 'D', 'A'};
		char [] correct = new char[answer.length];
		int a = 0; // 맞은 개수
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<answer.length; i++) {
			System.out.print("입력 > ");
			correct[i] = sc.next().charAt(0);
		}
		
		for(int i=0; i<answer.length; i++) {
			if(answer[i]==correct[i]) {
				System.out.println((i+1) + "번: 정답");
				a++;
			}
			else if(answer[i]!=correct[i]) {
				System.out.println((i+1) + "번: 오답");
			}
		}
		
		System.out.println("총 맞은 개수: " + a + "개");
		
	}
}


/*
패키지명: com.company.java006_ex 
클래스명: ArrayExUpgrade1

문제 설명
배열명: answers → 사용자의 답안: 'A', 'C', 'B', 'D', 'A'
배열명: correct  → 정답: 'A', 'C', 'B', 'A', 'A'
두 배열을 비교하여 맞은 개수를 출력하세요.
🧪 출력 예시
정답을 입력하시오. >   'A', 'C', 'B', 'A', 'A'
1번: 정답  
2번: 정답  
3번: 정답  
4번: 오답  
5번: 정답  
총 맞은 개수: 4개
*/