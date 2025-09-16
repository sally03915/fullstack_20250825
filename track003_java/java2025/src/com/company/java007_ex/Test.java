package com.company.java007_ex;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		int[][] seats = {
			    {0, 1, 0, 0},
			    {1, 0, 0, 1},
			    {0, 0, 1, 0}
			};
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("현재 좌석 상태:");
			for(int i=0;i<seats.length;i++) {
				for(int j=0;j<seats[i].length;j++) {
					System.out.print(seats[i][j]);
				}
				System.out.println();
			}
			
			System.out.print("행을 입력하세요 > ");
			int hang = sc.nextInt();
			System.out.print("열을 입력하세요 > ");
			int yeul = sc.nextInt();
			
			
			if(seats[hang-1][yeul-1] == 1) {
				System.out.println("이미 예약된 좌석입니다.");
			}
			else if(seats[hang-1][yeul-1] == 0) {
				System.out.println("예약되었습니다.");
				seats[hang-1][yeul-1] = 1;
			}
		}
	}
}
