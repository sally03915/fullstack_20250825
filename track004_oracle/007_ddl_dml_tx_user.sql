--007_ddl_dml_tx_user.sql

-- ★ 데이터 베이스언어 
-- 1. dml 조작어(데이터)    insert(삽입)    select(조회)       update(수정)    delete(지우기)  → CRUD
-- 2. ddl 정의어(구조)      create(만들기)   alter(테이블수정)   drop(삭제: 복구안됨.)   →  CAD
-- 3. dcl 제어어(접근권한)  grant(주세요) ,  revoke(권한빼기)
-- 4. tcl 제어어(트랜잭션)  commit(반영)  ,  rollback(되돌리기),  savepoint(지점)



---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
-- 1. dml 조작어(데이터)    ■insert(삽입)    select(조회)       update(수정)    delete(지우기)  → CRUD
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
-- #1. 테이블 복사해오기
create table dept_temp  as  select * from dept;
desc dept_temp;
select * from dept_temp;

-- #2. insert
----------------------------------
insert into  테이블명 (필드1, 필드2,,,)  values (값1, 값2,,,,)
----------------------------------

insert  into dept_temp (  deptno, dname, loc  )  values ( 50 , 'DATABASE' , 'SEOUL'   );
insert  into dept_temp                           valueS ( 60 , 'NETWORK'  , 'BUSAN'   );
insert  into dept_temp                           values ( 70 , 'WEB'      , NULL      );
insert  into dept_temp ( deptno, loc, dname  )   values ( 80 ,  ''        , 'FRONT'  );
insert  into dept_temp ( loc, dname ,deptno  )   values (  'INCHEON'      , 'BACK' , 90  );
insert  into dept_temp ( deptno , dname      )   values ( 99 , 'MOBILE' );

commit; -- 반영

select * from dept_temp;


-- Q1.  EMP테이블을 복사해 EMP_TEMP 테이블을 만드시오. ( 구조확인, 전체데이터 확인)
create table emp_temp  as  select * from emp;
desc emp_temp;
select * from emp_temp;

-- Q2.  모든필드 명시하는 방법이용해서   다음의 값 넣기 - 9999, '홍길동', 'PRESIDENT', NULL, '2001/01/01', 5000, 1000, 10
insert into emp_temp  (EMPNO, ENAME ,   JOB        , MGR ,  HIREDATE , SAL , COMM ,  DEPTNO )    
 values               (9999 , '홍길동', 'PRESIDENT', NULL, '2001/01/01', 5000, 1000, 10);

-- Q3.  필드 명시 안하는 방법이용해서    다음의 값 넣기    - 1111, '성춘향', 'MANAGER', 9999, '2001-01-05', 4000, NULL, 20
insert into emp_temp   
 values               (1111, '성춘향', 'MANAGER', 9999, '2001-01-05', 4000, NULL, 20);

commit;
select * from emp_temp;
 

---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
-- 1. dml 조작어(데이터)    insert(삽입)    select(조회)       ■update(수정)    ■delete(지우기)  → CRUD
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
-- #0.  
select * from dept_temp;

-- #1. update
----------------------------------
update  테이블명    
set     바꿀필드1 = 바꿀값1 ,  바꿀필드2 = 바꿀값2  ,,, 
where   조건;
----------------------------------

update  dept_temp  set  LOC = 'INCHEON' ;                   -- 전체데이터 업데이트 
update  dept_temp  set  LOC = 'NEW YORK'  WHERE  deptno=10; -- 해당하는 조건
update  dept_temp  set  Loc = 'DALLAS'    WHERE  deptno=20  and  dname ='RESEARCH';

select * from dept_temp;

-- #2. delete
----------------------------------
delete  from  테이블명  where  조건
----------------------------------

delete  from dept_temp;    -- 전체데이터 삭제
delete  from dept_temp  where deptno=10; 
delete  from dept_temp  where deptno >=30;

-- #3.
commit;
select * from dept_temp;
select * from dept;

insert into  dept_temp ( deptno, dname, loc) 
                  select deptno, dname, loc from dept;

 
-- Q1.  dept_temp  모든데이터 삭제
delete from dept_temp;

-- Q2.  insert 이용해서 데이터 삽입, 반영
insert into dept_temp  ( deptno, dname, loc)  select deptno, dname, loc from dept;   

select * from dept_temp;
rollback;  -- 되돌리기
commit;

-- Q3.  dept_temp 테이블에서  40번부서의이름을 DATABASE ,  지역을 SEOUL로 수정하시오.
update  dept_temp  set  dname ='DATABASE'  , LOC='SEOUL'  WHERE  DEPTNO=40;
SELECT * FROM DEPT_TEMP;

-- Q4.  위에데이터 되돌리기 #
ROLLBACK; -- 되돌리기



---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
-- 4. tcl 제어어(트랜잭션)  commit(반영)  ,  rollback(되돌리기),  savepoint(지점)
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------

-- #0. 준비 -  다음 문제들을 풀으시오
-- Q1. DEPT 테이블을 복사해 DEPT_TCL테이블을 작성하시오.
-- Q2. DEPT_TCL 테이블에 다음과 같이 데이터를 입력, 수정, 삭제 하시오.
--    2-1.  데이터 삽입   50, 'DATABASE', 'SEOUL'
--    2-2.  부서번호가 40인  LOC를 INCHEON 으로 수정
--    2-3.  DNAME이 RESEARCH 인데이터 삭제
--    2-4.  전체데이터 확인
CREATE TABLE DEPT_TCL  AS  SELECT * FROM DEPT;
DESC DEPT_TCL;
SELECT * FROM DEPT_TCL;

INSERT INTO DEPT_TCL  VALUES (50, 'DATABASE', 'SEOUL');
UPDATE  DEPT_TCL  SET  LOC='INCHEON'  WHERE DEPTNO=40;
DELETE  FROM DEPT_TCL  WHERE  DNAME = 'RESEARCH';
SELECT * FROM  DEPT_TCL;

-- #1.  데이터 반영  ( INSERT, UPDATE, DELETE )
COMMIT;

-- #2.  데이터 되돌리기 (  COMMIT 이후에는 ROLLCAK 효과 X  )
ROLLBACK;

INSERT  INTO  DEPT_TCL  DEPT_TCL  VALUES ( 20, 'AI', 'INCHEON' );
ROLLBACK;
SELECT * FROM DEPT_TCL;
 
-- #3.  SAVEPOINT

INSERT INTO DEPT_TCL VALUES (60, 'AI', 'INCHEON');   -- INSERT   (작업하고 저장)
SAVEPOINT  sp_insert;   -- 기준점 1 -----------


UPDATE DEPT_TCL  SET deptno=20  where  DEPTNO=60; -- UPDATE 설정  (작업하고 저장
SAVEPOINT  sp_update;  --  기준점 설정2  ----------------------

ROLLBACK TO  sp_insert;

SELECT * FROM DEPT_TCL;


---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
-- 2. ddl 정의어(구조)      create(만들기)   alter(테이블수정)   drop(삭제: 복구안됨.)   →  CAD
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
-- #1. CREATE 
----------------------------
CREATE TABLE 테이블명 (
   필드명1  자료형  옵션,
   필드명2  자료형  옵션,
   필드명3  자료형  옵션
)
----------------------------
필드명 - 영문소문자
자료형 - 숫자는 NUMBER, 문자열 VARCHAR2(갯수) , 날짜 DATE
옵션   - NOT NULL  필수입력 , 기본값 PRIMARY KEY


-- 테이블만들기
CREATE TABLE DEPT_DDL(
    DEPTNO   NUMBER(2)   PRIMARY KEY , 
    DNAME    VARCHAR(50) NOT NULL,
    LOC      VARCHAR2(50)
);

DESC DEPT_DDL;


----------------------------
ALTER  TABLE 테이블명    ADD     필드명  자료형  
                        DROP    COLUMN 필드명
                        MODIFY  필드명  자료형  
----------------------------
-- 컬럼추가
ALTER  TABLE DEPT_DDL  ADD     ADMIN VARCHAR(50);
-- 컬럼수정
ALTER  TABLE DEPT_DDL  MODIFY  ADMIN VARCHAR(100) NOT NULL;
-- 컬럼삭제
ALTER TABLE DEPT_DDL   DROP   COLUMN ADMIN;

----------------------------
DROP TABLE 테이블명
----------------------------
DROP TABLE DEPT_DDL;
ROLLBACK;
DESC DEPT_DDL;


-- part) 테이블만들기
--✅ 문제 1:  다음과 같이 테이블을 작성하고 데이터를 삽입하세요
--※AppUser 의 FK는 무시하세요.
--
--#### 1. `MbtiType`
--| 필드명 | 타입 | 설명 |
--|--------|------|------|
--| mbti_type_id | INT (PK) | MBTI 유형 ID |
--| name | VARCHAR(10) | 유형 이름 (예: ENFP) |
--| description | TEXT | 성향 설명 |
--
--**예시 데이터**
--```sql
--(3, 'ENFP', '열정적이고 창의적인 성향')
--(7, 'INTJ', '논리적이고 전략적인 성향')
--```

CREATE TABLE   MbtiType (
  mbti_type_id  NUMBER  PRIMARY KEY,
  name          VARCHAR2(10) ,
  description   VARCHAR2(100)
);

-- NUMBER, VARCHAR2



--#### 2. `AppUser`
--| 필드명 | 타입 | 설명 |
--|--------|------|------|
--| app_user_id | INT (PK) | 사용자 고유 ID |
--| email | VARCHAR(100) | 이메일 주소 |
--| password | VARCHAR(255) | 암호화된 비밀번호 |
--| mbti_type_id | INT (FK → MbtiType.mbti_type_id) | 연결된 MBTI 유형 |
--| created_at | DATETIME | 가입일 |
--
--**예시 데이터**
--```sql
--(1, 'alice@example.com', 'hashed_pw_123', 3, 2, '2025-10-01 10:00:00')
--(2, 'bob@example.com', 'hashed_pw_456', 7, 1, '2025-10-02 14:30:00')
--```
CREATE  TABLE  AppUser(
    app_user_id   NUMBER(5)  PRIMARY KEY, 
    email         VARCHAR2(100) , 
    password      VARCHAR2(255) ,
    mbti_type_id  NUMBER(3), 
    created_at    DATE
);


-- part) alter
--✅ 문제 1: AppUser 테이블에 사용자 이름(name) 컬럼을 추가하세요.
--컬럼 타입은 VARCHAR2(50)이며 NULL 허용
ALTER TABLE    AppUser    ADD  name  VARCHAR2(50);
 
--✅ 문제 2: AppUser 테이블의 email 컬럼에 NOT NULL 제약을 추가하세요.
ALTER TABLE    AppUser  modify   email varchar2(100)  not null;
 
--✅ 문제 3: AppUser 테이블의 password 컬럼 길이를 255 → 100으로 줄이세요.
ALTER TABLE    AppUser  modify    password varchar2(100);

--✅ 문제 4: MbtiType 테이블에 컬럼 category를 추가하세요.
--타입은 VARCHAR2(20)이며 기본값은 '기본'
ALTER TABLE MbtiType  ADD    category  VARCHAR2(20) DEFAULT '기본';

SELECT  column_name, data_default
from    user_tab_columns
where   table_name = 'MBTITYPE';  -- 테이블명 대문자
 
--✅ 문제 5: MbtiType 테이블의 description 컬럼 이름을 details로 변경하세요. (pass)   REMANE
--  https://www.oracletutorial.com/oracle-basics/
--  한국어로 변경
--  ALTER TABLE table_name   RENAME COLUMN column1 TO new_column;
ALTER TABLE  MbtiType  RENAME COLUMN description TO details;
 
--✅ 문제 6: AppUser 테이블의 name 컬럼을 삭제하세요.
ALTER TABLE   AppUser  DROP column name;
DESC  AppUser;
 
--✅ 문제 7:  MbtiType 테이블 이름을 MbtiInfo로 변경하세요. (pass)     REMANE     TO
ALTER TABLE  MbtiType  RENAME TO    MbtiInfo;
DESC  MbtiInfo;

ALTER TABLE  MbtiInfo  RENAME TO    MbtiType;


