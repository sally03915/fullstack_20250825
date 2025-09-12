package com.company.bank; 
import java.util.Arrays;
import java.util.Scanner;

public class Bank002_Array {
	public static void main(String[] args) {
		//변수								  0   1    2
		String []id=new String[3];       //  one two three
		String []pass = new String[3];   // 1111 2222 3333
		double []balance = new double[3];// 1100 2200 3300	
		int num=-1;  
		Scanner scanner = new Scanner(System.in);
		//입력 + 처리 + 출력
		while( num !=9 ) {   // 9가아니라면 계속 무한반복
			System.out.println( Arrays.toString(id));
			System.out.println( Arrays.toString(pass));
			System.out.println( Arrays.toString(balance));
		    //■기능 1. 메뉴판
	    	System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\n" + 
	    		"\n[1] ➕ 계좌 추가" + "\n[2] 🔍 계좌 조회" + "\n[3] 💵 입금하기" + "\n[4] 💸 출금하기" + "\n[5] 🗑️ 계좌 삭제  "
	    		+"\n\n👉 번호를 선택하세요:"
	    	);  
	    	num= scanner.nextInt();
	    	if( num==1 ) {    
	    		// 1-1. 빈칸인지 확인 후   find  
	    		// ver-1    if( 0번이 빈칸이라면  ){ find는 0}   if( 1번이 빈칸이라면){ find는 1 }
	    		// ver-2    if( 0번이 null      ){ find는 0}  if( 1번이 null    ){ find는 1 }
	    		// ver-3    if( id[0] == null  ){ find=0; }  if( id[1] == null  ){ find=1; } 
	    		// ver-4    찾았으면 나오기 추가 -  백만개의 자료있다라고하면 ~!   시간 오래걸림.
	    		int find=-1; 
	    		for(int i=0; i<id.length; i++){ if( id[i] == null  ){ find=i; break;  }  }
	    		
	    		//1-2. 유저 계정에 입력받기 
	    		System.out.print("[1]아이디   입력 > ");   id[find] = scanner.next();
	    		System.out.print("[2]비밀번호 입력 > ");    pass[find] = scanner.next();
	    		System.out.print("[3]금액    입력 > ");    balance[find] = scanner.nextDouble();
	    	}
	    	else if(num==2 || num==3 || num==4 || num==5){ 
	    		/* >>>>>> 2-1. 인증정보 */
	    		// 변수
	    		 int find=-1;    String tempId="", tempPass="";
	    		// 입력
	    		//1. 사용자에게 아이디 입력받기 + 2. 사용자에게 비밀번호 입력받기
	    		System.out.print("[1]아이디   입력 > ");   tempId = scanner.next();
	    		System.out.print("[2]비밀번호 입력 > ");    tempPass = scanner.next();
	    		//처리
	    		//3. ver-0  int find=-1;   없는 번호      / 문자열비교는 equals
	    		//3. ver-1   사용자에게입력받은아이디와  id[0]번이 같고  사용자에게입력받은비밀번호와 pass[0]번이면  사용자번호는0
	    		//3. ver-1   사용자에게입력받은아이디와  id[1]번이 같고  사용자에게입력받은비밀번호와 pass[1]번이면  사용자번호는1
	    		//3. ver-2 if(사용자에게입력받은아이디와  id[1]번이 같고  사용자에게입력받은비밀번호와 pass[1]번이면){사용자번호는1}
	    		for(int i=0; i<id.length; i++){ if( tempId.equals(id[i])  && tempPass.equals(pass[i])){ find=i; break;  } }
	    		
	    		//출력
	    		//4. 만약 find==-1 이라면 유저정보 못찾음!
	    		if(find ==1) {  System.out.println("아이디와 비밀번호를 확인해주세요! ");  continue; }
	    		
	    		/* >>>>>> 2-2. find 번호로  각각의 처리 */  
				switch (num) {
				case 2:
					System.out.println("\nID >" + id[find] + "\nPASS > " + pass[find] + "\n잔액 > " + balance[find]);
					break;
				case 3:
					System.out.print("입금할 금액 > ");
					double input = scanner.nextDouble();
					balance[find] += input;
					System.out.println("입금을 완료했습니다.");
					break;
				case 4:
					System.out.print("출금할 금액 > ");
					double output = scanner.nextDouble();
					if (output > balance[find]) {
						System.out.println("잔액이 모자랍니다.");
						continue;
					}
					balance[find] -= output;
					System.out.println("출금을 완료했습니다.");
					break;
				case 5:
					System.out.println("삭제하시겠습니까?");
					String answer = scanner.next();
					if (!answer.toLowerCase().equals("y")) {
						System.out.println("삭제를 취소했습니다.");
						continue;
					}
					id[find] = pass[find] = "";
					balance[find] = 0;
					System.out.println("삭제를 완료했습니다.");
					break;
				}
	    	}
	    	else{  System.out.println("메뉴를 확인해주세요. ");    }
		}
	}// end main
}//end class

/*
for(;;){ 무한반복
   ■기능 1. 메뉴판
   ■기능 2. 
	     if(9){ 빠져나오기   }
   else if(1){ 사용자에게 추가}
   else if(2,3,4,5){ 
   	■1. 사용자 인증
   	 2. 2,3,4,5 각각에 해당하는 처리
	    	switch(){
	    		case 2 : 정보출력 break;
	    		case 3 : 입금 break;
	    		case 4 : 출금 break;
	    		case 5 : 삭제 break;
	    	}
   } // end else if
}// end for

*/