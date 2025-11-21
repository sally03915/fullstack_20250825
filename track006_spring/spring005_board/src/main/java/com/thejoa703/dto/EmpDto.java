package com.thejoa703.dto;

import lombok.Data;

@Data
public class EmpDto {
	private int EMPNO;
	private String ENAME;
	private String JOB;
	private int MGR;
	private String HIREDATE;
	private int SAL;
	private int COMM;
	private int DEPTNO;
}

/*
SQL> desc emp;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 EMPNO                                              NUMBER(4)
 ENAME                                              VARCHAR2(10)
 JOB                                                VARCHAR2(9)
 MGR                                                NUMBER(4)
 HIREDATE                                           DATE
 SAL                                                NUMBER(7,2)
 COMM                                               NUMBER(7,2)
 DEPTNO                                             NUMBER(2)

SQL> 

*/