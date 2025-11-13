package com.thejoa703.dto;

import lombok.Data;

@Data
public class MilkDto {
	private int mno;
	private String mname;
	private int mnum;
	private int mtotal;
}


/*


연습문제)    ex004에 작성하기- 있는곳에 셋팅~!
SQL> desc milk;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 MNO                                       NOT NULL NUMBER
 NMAME                                     NOT NULL VARCHAR2(100)
 NNUM                                      NOT NULL NUMBER
 MTOTAL                                             NUMBER

>  ex004에 작성하기
> 오라클에서 crud sql 5개 테스트 작성해서 카톡으로보내기~!
> 시퀀스이용하기  
1. dto 작성   - mybatis-config.xml  (별명) , MilkDto
2. dao 작성
3. dao 테스트


 create table  milk(
   mno     number  not null  primary key,
   nmame varchar2(100) not null unique,
   nnum   number  not null,
   mtotal  number
 );


create sequence milk_seq;

*/