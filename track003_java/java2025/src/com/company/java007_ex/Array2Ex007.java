package com.company.java007_ex;

public class Array2Ex007 {
	public static void main(String[] args) {
		//변수
		int [][] arr2 = new int[4][4];
		int data=1;
		for(int ch=0; ch<arr2.length; ch++) { //아파트의 층
			for(int kan=0; kan<arr2[ch].length; kan++) { //층칸?
				arr2[ch][kan] = data++;
			}
			// 각층이 끝날때 해야할일
			data=1;
		}
		
		for(int ch=0; ch<arr2.length; ch++) { //아파트의 층
			for(int kan=0; kan<arr2[ch].length; kan++) { //층칸?
				System.out.print(arr2[ch][kan] + "\t");
			}	
			// 각층이 끝날때 해야할일
			System.out.println();
		}
		
	}// end main
}// end class


/*

연습문제7)  array
패키지명 : com.company.java007_ex
클래스명 :  Array2Ex007
> 2차원배열   4*4
1.  new 로 만들고 
2.  데이터 넣기  for+length
3.  데이터 출력  for+length
1	2	3	4
1	2	3	4
1	2	3	4
1	2	3	4



*/
