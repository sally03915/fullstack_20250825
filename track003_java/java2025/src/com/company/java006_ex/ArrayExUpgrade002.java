package com.company.java006_ex;

import java.util.Scanner;

public class ArrayExUpgrade002 {
	public static void main(String[] args) {
        int[] temperatures = {22, 24, 25, 23, 21, 20, 19, 21};
        int riseCount = 0;

        for (int i = 0; i < temperatures.length; i++) {
            int baseTemp = temperatures[0]; // 기준 온도는 첫 번째 값으로 설정
            System.out.print((i + 1) + "시간차: ");

            if (temperatures[i] > baseTemp) {
                System.out.println("상승");
                riseCount++;
            } else if (temperatures[i] < baseTemp) {
                System.out.println("하락");
            } else {
                System.out.println("유지");
            }
        }

        System.out.println("기준 온도: " + temperatures[0] + "도");
        System.out.println("총 상승 횟수: " + riseCount + "회");
	}
}


/*
패키지명: com.company.java006_ex 
클래스명: ArrayExUpgrade2
문제 설명
배열명: temperatures → 
         하루 동안의 시간별 온도 변화: [22, 24, 25, 23, 21, 20, 19, 21] 

배열을 순회하면서 기준 온도보다 높은 경우는 "상승", 낮은 경우는 "하락", 같은 경우는 "유지"로 출력하세요. 
그리고 전체 중 "상승"한 횟수를 출력하세요.

🧪 출력 예시 
기준 온도: 22도  
1시간차: 유지  
2시간차: 상승  
3시간차: 상승  
4시간차: 상승  
5시간차: 하락  
6시간차: 하락  
7시간차: 하락  
8시간차: 상승  
총 상승 횟수: 4회
*/