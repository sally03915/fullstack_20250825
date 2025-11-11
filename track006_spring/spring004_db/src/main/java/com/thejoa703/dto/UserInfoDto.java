package com.thejoa703.dto;
import lombok.Data;

@Data
public class UserInfoDto {
	private int no;
	private String email;
	private int age;
}
/*
■1. 테이블구조
SQL> desc userinfo;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 NO                                        NOT NULL NUMBER
 EMAIL                                     NOT NULL VARCHAR2(100)
 AGE                                                NUMBER


> 오라클에서 crud sql 5개 테스트 작성해서 카톡으로보내기~!
> 시퀀스이용하기  

1. insert     insert into userinfo (no, email, age)  values ( userinfo_seq.nextval, 'first@gmail.com' , 11  )
2. select     select * from userinfo  order by no desc 
3. 해당번호 유저정보   select * from userinfo  where  no=1
4. update     update userinfo  set  email='a@a' , age=100 where no=1
5. delete  해당번호 유저삭제 delete from userinfo  where  no=1

 create table userinfo(
   no number  not null  primary key,
    email varchar2(100) not null unique,
    age   number
 );
  create sequence userinfo_seq;

*/