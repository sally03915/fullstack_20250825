package com.company.java009_ex;

//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수)와 행위(멤버함수)
class Card{
	//상태-멤버변수  :   int cardNum; boolean  isMembership;
	int cardNum;      boolean  isMembership;
	//행위-멤버함수  :   입력: input() / 출력 : show()
	void input() {}
	void  show() {}
	
	public Card() { super(); }
	public Card(int cardNum, boolean isMembership) 
	{ super(); this.cardNum = cardNum; this.isMembership = isMembership; }
	
	@Override public String toString() //####
	{ return "Card [cardNum=" + cardNum + ", isMembership=" + isMembership + "]"; }
} // end class
public class ClassEx005 {
	public static void main(String[] args) {
		Card  c1= new Card(); 
		System.out.println(c1);    // Card[cardNum=0, isMembership=false]
	} 
}


/*

연습문제5)  class
패키지명 : com.company.java009_ex
클래스명 :  ClassEx005
-- 생성자 작성하시오.
class Card{
	//상태-멤버변수  :   int cardNum; boolean  isMembership;	
	//행위-멤버함수  :   입력: input() / 출력 : show()
}
public class ClassEx005{
   public static void main(String[] args) {
	Card  c1= new Card(); 
	System.out.println(c1);  
   }
}

출력내용 :
Card[cardNum=0, isMembership=false]

*/