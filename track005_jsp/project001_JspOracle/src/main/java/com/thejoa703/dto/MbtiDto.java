package com.thejoa703.dto;

public class MbtiDto {
	private int mbtiTypeId;  // _빼기
	private String name;
	private String description;
	
	public MbtiDto() { super(); }
	public MbtiDto(int mbtiTypeId, String name, String description) { super(); this.mbtiTypeId = mbtiTypeId; this.name = name; this.description = description; }
	@Override public String toString() { return "MbtiDto [mbtiTypeId=" + mbtiTypeId + ", name=" + name + ", description=" + description + "]"; }
	public int getMbtiTypeId() { return mbtiTypeId; } public void setMbtiTypeId(int mbtiTypeId) { this.mbtiTypeId = mbtiTypeId; } public String getName() { return name; } public void setName(String name) { this.name = name; } public String getDescription() { return description; } public void setDescription(String description) { this.description = description; }	
}




/*
Q4. MODEL
4-1. table
SQL> desc mbtitype
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 MBTI_TYPE_ID                              NOT NULL NUMBER(3)
 NAME                                               VARCHAR2(10)
 DESCRIPTION                                        VARCHAR2(100)

4-2. dto  [com.company.dto]
public class  MbtiTypeDto{
    private  int MBTI_TYPE_ID; 
    private String name;
    private String   description;    //생성자 + toString + getters/setters                                                           
} 

4-3. dao [com.company.dao]
create :  insert into mbtitype ( MBTI_TYPE_ID ,name,  description)  values ( mbtitype_seq.nextval , ?,?);
read   :  select * from mbtitype;        
            select * from mbtitype  where MBTI_TYPE_ID =?;
update : update mbtitype   set name=?,  description=? where MBTI_TYPE_ID =?;  
delete  : delete  from  mbtitype   where MBTI_TYPE_ID =?;  

> oracle 에서 확인하고 dao 작성할것!  

*/