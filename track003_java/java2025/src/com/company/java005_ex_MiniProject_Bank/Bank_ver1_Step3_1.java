package com.company.java005_ex_MiniProject_Bank; 
import java.util.Scanner;

public class Bank_ver1_Step3_1 {
	public static void main(String[] args) {
		//변수
		int num = -1; String id = "", pass=null;  double balance=0;
		Scanner scanner = new Scanner(System.in);
		//입력+처리+ 출력
		for(;;) {
			System.out.print("\n\n====== 💰BANK💰 ======\n*"
			+ " 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료\n입력>>> ");
			num = scanner.nextInt();
			
			if(num == 9 ) {  System.out.println("ATM을 종료합니다."); break;}
			switch(num){
				case 1 : 
					System.out.println("1.추가기능입니다."); 
					System.out.print("✅아이디입력  >");    id=scanner.next();
					System.out.print("✅비밀번호입력  >");  pass=scanner.next();
					System.out.print("✅잔액입력  >");     balance=scanner.nextDouble(); 
				break;
				case 2 : {
					System.out.println("2.조회기능입니다."); 
					//변수
					String tempid, temppass;
					//입력  2-1. 사용자에게 임시아이디와 임시비밀번호 입력받기
					System.out.print("✅아이디입력  >");      tempid=scanner.next();
					System.out.print("✅비밀번호입력  >");   temppass=scanner.next();
					//처리+출력
					if(  tempid.equals(id)  &&  temppass.equals(pass) ) {
						System.out.println("💰 사용자정보" );	
						System.out.println("💰 id > " + id );	
						System.out.println("💰 pass > " + pass );	
						System.out.println("💰 balance > " + balance );	
					}else { System.out.println("정보를 확인해주세요.");  }
				} break;
				case 3 : {
					System.out.println("3.입금입니다.");
					// 변수
					// 입력  사용자에게 임시아이디와 임시비밀번호 입력받기
					// 처리  if( 아이디와 임시아이디가 같고  비번과 임시비밀번호가 같다면 ){  돈입력받아서 , 잔액에 추가   }  
					// 출력  else{  아니라면   정보를 확인해주세요.  }
				} break;
				case 4 : {
					System.out.println("4.출금입니다."); 
					// 변수
					// 입력  사용자에게 임시아이디와 임시비밀번호 입력받기
					// 처리  if( 아이디와 임시아이디가 같고  비번과 임시비밀번호가 같다면 ){  돈입력받아서 , 잔액에서 빼기  }  
					// 출력  else{  아니라면   정보를 확인해주세요.  }
				}break;
				case 5 : {
					System.out.println("5.삭제입니다.");  
					// 변수
					// 입력  사용자에게 임시아이디와 임시비밀번호 입력받기
					// 처리  if( 아이디와 임시아이디가 같고  비번과 임시비밀번호가 같다면 ){  삭제하시겠습니까? 묻고 y라면 정보삭제 }  
					// 출력  else{  아니라면   정보를 확인해주세요.  }
				}break;
				
			}
		}// end for
	}// end main
}//end class



/*  하루에 하나씩 힌트나가요~~~!
	천천히 정리하면서 익히면서 도전이요~~!  이번주~ 다음해서 숙제~!

Step1. 무한반복으로 만드는 메뉴만들기	
	for(;;){ //1-1 무한반복
		//1-2 빠져나올조건 9
		//1-3 입력받은번호가   if   or  switch
		1을 입력하면 추가기능입니다. 출력구문까지만
		2를 입력하면 조회기능입니다. 출력구문까지만
		3을 입력하면 입금기능입니다. 출력구문까지만
		4를 입력하면 출금기능입니다. 출력구문까지만
		5를 입력하면 삭제기능입니다. 출력구문까지만
		9를 입력하면 종료합니다.    출력구문까지만
	}
	
	■ 힌트
	for(;;) { 
		System.out.println("숫자1을 입력하세요.");
		int a = scanner.nextInt();
		if(a == 1) { break;}
	}
	
Step 2 추가
					//아이디입력  > _입력받기
					//비밀번호입력 > _입력받기
					//잔액입력    > _입력받기			
Step 3 조회
					System.out.println("2.조회기능입니다."); 
					//변수
					String tempid, temppass;
					//입력  2-1. 사용자에게 임시아이디와 임시비밀번호 입력받기
					System.out.print("아이디입력  >");      tempid=scanner.next();
					System.out.print("비밀번호입력  >");   temppass=scanner.next();
					//처리+출력
					//     2-2. if( 아이디와 임시아이디가 같아야하고 비번과 임시비밀번호가 같다면 ){ 사용자정보출력 }
					//          else {다르면 정보를 확인해주세요.}
*/