package com.company.java007_ex;

import java.util.Scanner;

public class Array2_upgrade2 { 
    public static void main(String[] args) {
	    int[][] seats = {
	            {0, 1, 0, 0},
	            {1, 0, 0, 1},
	            {0, 0, 1, 0}
	        };

        Scanner sc = new Scanner(System.in);
        System.out.print("예약할 좌석의 행 번호 입력 (0~2): ");
        int row = sc.nextInt();
        System.out.print("예약할 좌석의 열 번호 입력 (0~3): ");
        int col = sc.nextInt();

        if (seats[row][col] == 1) {
            System.out.println("이미 예약된 좌석입니다.");
        } else {
            seats[row][col] = 1;
            System.out.println("예약되었습니다.");
        }

        System.out.println("\n현재 좌석 상태:");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    } 
}
/*
다차원 배열을 이용한 좌석 예약 시스템
패키지명 : com.company.java007_ex 
클래스명 : Array2Uptrade002 

문제 설명 : 극장의 좌석 상태를 2차원 배열로 표현하고,
예약 가능한 좌석은 0,
이미 예약된 좌석은 1로 표시됩니다. 사용자가 원하는 좌석을 입력하면,
해당 좌석이 예약 가능한지 확인하고,
예약 처리 후 전체 좌석 상태를 출력하시오.

java
int[][] seats = {
    {0, 1, 0, 0},
    {1, 0, 0, 1},
    {0, 0, 1, 0}
};


조건:
사용자 입력은 행 번호와 열 번호를 Scanner로 받는다.
이미 예약된 좌석이면 "이미 예약된 좌석입니다." 출력
예약 가능하면 "예약되었습니다." 출력 후 해당 좌석을 1로 변경
최종 좌석 상태를 출력하시오.

출력예시:
예약되었습니다.

현재 좌석 상태:
0 1 1 0
1 0 0 1
0 0 1 0
*/