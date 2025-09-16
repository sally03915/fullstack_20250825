package com.company.java007_ex;

import java.util.Scanner;

public class Array2_upgrade3 {
	public static void main(String[] args) {
		int[][] datas = { { 15, 22, 8, 19 }, { 33, 5, 17, 11 }, { 9, 27, 14, 6 } };

		int[][] result = new int[datas.length + 1][datas[0].length + 1];
		int totalMax = Integer.MIN_VALUE;

		// #1. 데이터 복사 및 행 최댓값 계산
		for (int i = 0; i < datas.length; i++) {
			int rowMax = Integer.MIN_VALUE;
			for (int j = 0; j < datas[0].length; j++) {
				result[i][j] = datas[i][j];
				if (datas[i][j] > rowMax) {
					rowMax = datas[i][j];
				}
			}
			result[i][datas[0].length] = rowMax;
			if (rowMax > totalMax) {
				totalMax = rowMax;
			}
		}

		// #2. 열 최댓값 계산
		for (int j = 0; j < datas[0].length; j++) {
			int colMax = Integer.MIN_VALUE;
			for (int i = 0; i < datas.length; i++) {
				if (datas[i][j] > colMax) {
					colMax = datas[i][j];
				}
			}
			result[datas.length][j] = colMax;
			if (colMax > totalMax) {
				totalMax = colMax;
			}
		}

		// #3. 전체 최댓값 저장
		result[datas.length][datas[0].length] = totalMax;

		// #4. 출력
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
/*
패키지명 : com.company.java007_ex 
클래스명 : Array2_upgrade3

배열을 이용하여 다음의 프로그램을 작성하시오.

1. 문제 설명
다음의 주어진 조건을 이용하여 각 행과 열의 최댓값을 구하고, 전체 최댓값도 구하시오.

java
int[][] datas = {
    { 15, 22, 8, 19 },
    { 33, 5, 17, 11 },
    { 9, 27, 14, 6 }
};  // 3층 4칸

int[][] result = new int[datas.length + 1][datas[0].length + 1];

2. 구현 조건
result 배열에 datas 데이터를 복사한다.
각 행의 최댓값을 해당 행의 마지막 열에 저장한다.
각 열의 최댓값을 해당 열의 마지막 행에 저장한다.

전체 최댓값을 마지막 행과 마지막 열의 교차점에 저장한다.

✅ 출력 예시
코드
15  22  8   19  22  
33  5   17  11  33  
9   27  14  6    27  
33  27  17  19  33
 */