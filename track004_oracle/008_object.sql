--008_object.sql

-- 1. 시퀀스 : 자동번호생성기  ★
-- 2. 뷰     : 가상테이블 ( select 문 결과를 저장한 객체 )  ★
-- 3. 동의어 : 객체에 대한 별칭
-- 4. 인덱스 : 검색성능향상 ★
-- 5. 클러스터 : 여러테이블을 물리적으로 같은공간에 저장

-----------------------------------------------------------------
-- 1. 시퀀스 : 자동번호생성기  ★
-----------------------------------------------------------------
-- #1. 시퀀스만들기
create sequence   emp_seq;  --  시작1, 증가단위 1 , 10^27
create sequence  dept_seq;

create sequence emp_seq2
start with 1000   -- 시퀀스 시작값
increment by 1    -- 몇개씩증가?
maxvalue  9999    -- 최대값 까지 지정가능
nocache;          -- 메모리에 미리 몇개 값저장둘지.... 

-- #2. 시퀀스사용하기
select  emp_seq.NEXTVAL  from dual;
select  dept_seq.NEXTVAL  from dual;

select table_name from user_tables; 
desc DEPT_TEMP;

insert into DEPT_TEMP  values (dept_seq.nextval , 'ai' , 'INCHEON');
SELECT * FROM DEPT_TEMP;

-- Q  appuser_seq 시퀀스만들기;
desc appuser;
create sequence  appuser_seq;  -- ★
alter  table  appuser modify email varchar2(100)  NOT NULL unique;  -- 유일한값  -- ★
 
DROP TABLE APPUSER; 
CREATE TABLE APPUSER(
    APP_USER_ID  NUMBER NOT NULL PRIMARY KEY ,
    EMAIL        VARCHAR2(100) NOT NULL   UNIQUE ,
    PASSWORD     VARCHAR2(100) ,
    MBTI_TYPE_ID NUMBER ,       
    CREATED_AT   DATE  
)

SELECT table_name, constraint_name, column_name
FROM user_cons_columns
WHERE constraint_name IN (
  SELECT constraint_name
  FROM user_constraints
  WHERE constraint_type = 'U'
);
  
 



