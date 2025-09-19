package com.company.java007_ex_MiniProject_Bank;
import java.util.Arrays;

public class Array2Ex008 {
	public static void main(String[] args) { 
		//변수
		int[][] datas = {  {  10, 10, 10 ,10},    // 00 01 02 03 04  # → 04+=00 04+=01...
			         	   {  20, 20, 20 ,20},    // 10 11 12 13 14  # → 14+=10 14+=11...
			         	   {  30, 30, 30 ,30},    // 20 21 22 23 24  # → 24+=20 24+=21...
		};  // 3층 4칸 							  // 30 31 32 33 34	   
												  // #↓ 30+= 00  30+=10.... 
		int[][] result = new int[datas.length+1][datas[0].length+1];
		
		//입력  result[0][0] = datas[0][0]
		//     새로은 result 아파트 = 기존 datas 아파트 
		for(int ch=0; ch<datas.length;  ch++){//아파트의 층
			for(int kan=0; kan<datas[ch].length;  kan++) {//아파트의 칸수
				result[ch][kan] = datas[ch][kan];
			}	 
		}
		/*
		//처리(1)  가로방향     10	10	10	10	0	   // 00 01 02 03 04
		//ver-1
		//		result[0][4] += result[0][0];  
		//		result[0][4] += result[0][1]; 
		//		result[0][4] += result[0][2];
		//		result[0][4] += result[0][3];

		//		result[1][4] += result[1][0];  
		//		result[1][4] += result[1][1]; 
		//		result[1][4] += result[1][2];
		//		result[1][4] += result[1][3];

		//		result[2][4] += result[2][0];  
		//		result[2][4] += result[2][1]; 
		//		result[2][4] += result[2][2];
		//		result[2][4] += result[2][3];

		//ver-2
		//		for(int kan=0; kan<result[0].length-1; kan++) {   result[0][4] += result[0][kan];   }  
		//		for(int kan=0; kan<result[1].length-1; kan++) {   result[1][4] += result[1][kan];   }  
		//		for(int kan=0; kan<result[2].length-1; kan++) {   result[2][4] += result[2][kan];   }  
		
		//ver-3
		for (int ch = 0; ch < result.length - 1; ch++) {
			for (int kan = 0; kan < result[ch].length - 1; kan++) {
				result[ch][4] += result[ch][kan];
			}
		}
		//처리(2)  세로방향
		//ver-1
		//result[3][0] += result[0][0];   result[3][0] += result[1][0];   result[3][0] += result[2][0];
		//result[3][1] += result[0][1];   result[3][1] += result[1][1];   result[3][1] += result[2][1]; 
		//result[3][2] += result[0][2];   result[3][2] += result[1][2];   result[3][2] += result[2][2]; 
		//result[3][3] += result[0][3];   result[3][3] += result[1][3];   result[3][3] += result[2][3]; 
		//ver-2
		//		for(int ch=0; ch<result.length-1; ch++) {  result[3][0] += result[ch][0];     }
		//		for(int ch=0; ch<result.length-1; ch++) {  result[3][1] += result[ch][0];     }
		//		for(int ch=0; ch<result.length-1; ch++) {  result[3][2] += result[ch][0];     }
		//		for(int ch=0; ch<result.length-1; ch++) {  result[3][3] += result[ch][0];     }
		//ver-3
		//		for(int kan=0; kan<result[0].length-1; kan++)
		//		{ for(int ch=0; ch<result.length-1; ch++) {  result[3][kan] += result[ch][0];     }  }
		//ver-4
		for (int ch = 0; ch < result.length - 1; ch++) {
			for (int kan = 0; kan < result[ch].length - 1; kan++) {
				result[3][kan] += result[ch][0];
			}
		} 
		//처리(3)  전체데이터
		for (int ch = 0; ch < result.length - 1; ch++) {
			for (int kan = 0; kan < result[ch].length - 1; kan++) {
				result[3][4] += result[ch][kan];
			}
		}
		*/
		for (int ch = 0; ch < result.length - 1; ch++) {
			for (int kan = 0; kan < result[ch].length - 1; kan++) {
				result[ch][4] += result[ch][kan];   // 4칸
				result[3][kan] += result[ch][0];    // 3층
				result[3][4] += result[ch][kan];    // 3층 4칸
			}
		}
		
		//출력
		for(int ch=0; ch<result.length;  ch++){//아파트의 층
			for(int kan=0; kan<result[ch].length;  kan++) {//아파트의 칸수
				System.out.print( result[ch][kan] + "\t" );
			}	
			System.out.println();  //한층이 끝나면 해야할일
		}
	}// end main
}// end class


/*


연습문제8)  array
패키지명 : com.company.java007_ex
클래스명 :  Array2Ex008
배열을 이용하여 다음의 프로그램을 작성하시오.   
1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.

int[][] datas = {  {  10, 10, 10 ,10},    // 00 01 02 03 04  # → 04+=00 04+=01...
	         	   {  20, 20, 20 ,20},    // 10 11 12 13 14  # → 14+=10 14+=11...
	         	   {  30, 30, 30 ,30},    // 20 21 22 23 24  # → 24+=20 24+=21...
};  // 3층 4칸 							  // 30 31 32 33 34	   
										  // #↓ 30+= 00  30+=10.... 
										 
int[][] result = new int[datas.length+1][datas[0].length+1];   3,4

#1. result 에 datas데이터 복사하기
#2. 가로방향누적데이터
#3. 세로방향데이터누적
#4. 총합

출력내용:
10	10	10	10	40	
20	20	20	20	80	
30	30	30	30	120	
60	60	60	60	240	




*/
