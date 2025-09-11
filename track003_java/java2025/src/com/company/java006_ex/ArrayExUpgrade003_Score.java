package com.company.java006_ex;


public class ArrayExUpgrade003_Score {
	public static void main(String[] args) {
		String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
	    int[] kor={100,20,90,70,35};   
	    int[] eng={100,50,95,80,100};
	    int[] mat={100,30,90,60,100};
	    int[] aver=new int[5];
	    String[] hab = new String[5];
	    String[] jang = new String[5];
	    int[] rank = new int[5];
	    int b;
	    
	    
	    for (int i=0; i<name.length; i++) {
	    	aver[i]=(kor[i] + eng[i] + mat[i]) / 3; //평균
	    	
	    	if(aver[i]>=60) {
	    		hab[i] = "합격";
	    	}
	    	else if(aver[i]<60) {
	    		hab[i] = "불합격";
	    	}
	    	
	    	if(aver[i]>=95) {
	    		jang[i] = "장학생";
	    	}
	    	else if(aver[i]<95) {
	    		jang[i] = "----";
	    	}
	    }
	    
	    
	    for (int i=0; i<name.length; i++) {
	    	rank[i]=1;
	    }
	    
	    for (int j=0; j<name.length; j++) { if (aver[0] < aver[j]) { rank[0]++; } }
	    for (int j=0; j<name.length; j++) { if (aver[1] < aver[j]) { rank[1]++; } }
	    for (int j=0; j<name.length; j++) { if (aver[2] < aver[j]) { rank[2]++; } }
	    for (int j=0; j<name.length; j++) { if (aver[3] < aver[j]) { rank[3]++; } }
	    for (int j=0; j<name.length; j++) { if (aver[4] < aver[j]) { rank[4]++; } }
	    
	    
	    System.out.println(":::::::::::::::::::::::::::::::::::::::");
	    System.out.println("이름\t 국어\t 영어\t 수학\t 평균\t 등수\t 합격여부\t 장학생");
	    System.out.println(":::::::::::::::::::::::::::::::::::::::");
	    for (int i=0; i<name.length; i++) {
	    	System.out.println(name[i] + "\t "+ kor[i] + "\t "+ eng[i] + "\t "+ mat[i] + "\t "+ aver[i] + "\t " + rank[i] + "\t" + hab[i] + "\t "+ jang[i]);
	    }
	    System.out.println(":::::::::::::::::::::::::::::::::::::::");
	}
}

/*
:::::::::::::::::::::::::::::::::::::::
이름	 국어	 영어	 수학	 평균	 등수	 합격여부	 장학생
:::::::::::::::::::::::::::::::::::::::
아이언맨	 100	 100	 100	 100	 1	합격	 장학생
헐크	 20	 50	 30	 33	 5	불합격	 ----
캡틴	 90	 95	 90	 91	 2	합격	 ----
토르	 70	 80	 60	 70	 4	합격	 ----
호크아이	 35	 100	 100	 78	 3	합격	 ----
:::::::::::::::::::::::::::::::::::::::

*/