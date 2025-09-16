package com.company.java007_ex;

public class Array2_upgrade1 { 
    public static void main(String[] args) {
        int[][] arr2 = {
            {101, 102, 103},
            {200, 201, 202},
            {301, 302, 303}
        };

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                if (arr2[i][j] % 2 == 0) {
                    System.out.printf("짝수 arr2[%d][%d] = %d\n", i, j, arr2[i][j]);
                }
            }
        }
    } 
}
/*
다차원 배열 + 조건 처리
패키지명 : com.company.java007_ex 
클래스명 : Array2Ex002_upgrade1 
1. 문제 설명 : 
다음과 같은 2차원 배열이 주어졌을 때,
각 요소를 이중 for문으로 순회하면서
짝수인 값만 출력하시오.
출력 시 각 값의 위치(index)도 함께 출력하시오.

2. 출력예시:
짝수 arr2[0][1] = 102
짝수 arr2[1][0] = 200
짝수 arr2[1][2] = 202
짝수 arr2[2][1] = 302

int[][] arr2 = {
    {101, 102, 103},
    {200, 201, 202},
    {301, 302, 303}
};
*/