package com.company.java005_ex_MiniProject_Bank;
public class ForEx009 {
	public static void main(String[] args) {
	 //변수  
		int hap=0;
	 //입력 + 처리
		//ver-1  제일작은단위로 해야할일 -   1이 3의 배수라면 hap누적
		//ver-2  구조                    if(2이 3의 배수라면){ hap누적}
		//ver-3  코드작성                 if(3%3==0){ hap+=3;}
		//		 if(1%3==0){ hap+=1;}
		//		 if(2%3==0){ hap+=2;}
		//		 if(3%3==0){ hap+=3;}
		// {  반복   }    {  변수  }
		for(int i=1; i<=10; i++){    if(i%3==0){ hap+=i;}  }
		
     //출력  1~10까지 3의 배수의 합 : 18
		System.out.println("for- ver 1~10까지 3의 배수의 합 : " + hap);
	///////// while
		 hap=0;
		 int i=1; while(i<=10){    if(i%3==0){ hap+=i;}       i++;}
		 System.out.println("while- ver 1~10까지 3의 배수의 합 : " + hap);

	///////// do while
		 hap=0;
		 i=1; do{    if(i%3==0){ hap+=i;}       i++;}while(i<=10);
		 System.out.println("do while- ver 1~10까지 3의 배수의 합 : " + hap);
	}
}

/*
연습문제9)  for/while/do while
패키지명 : com.company.java005_ex
클래스명 :  RepeatEx009
for , while , do while 3가지 버젼으로 
1~10까지 3의 배수의 합 : 18

힌트)
ver-1)
1이  3의 배수라면  합을더해주변수에누적
2가  3의 배수라면  합을더해주변수에누적
3이  3의 배수라면  합을더해주변수에누적

ver-2)
if( 1이  3의 배수라면 ){ 합을더해주변수에누적 }
if( 2가  3의 배수라면 ){ 합을더해주변수에누적 }
if( 3이  3의 배수라면 ){ 합을더해주변수에누적 }

*/