-------------------------------------------------------------------------------------
-- 003_select_function.sql
-- 1. 문자열
-- 2. 숫자
-- 3. 날짜
-- 4. 변환
-- 5. 조건
-------------------------------------------------------------------------------------
-- 003_select_function.sql
-- 1. 문자열
-- 1-1. upper  대문자, lower 소문자, initcap 대소문자 변환
-- 1-2. length 문자열길이
-- 1-3. substr 부분문자열 ,   instr  위치문자열
-- 1-4. replace 바꾸기 ,  lpad, rpad 채우기
-- 1-5. trim , ltrim, rtrim  공백빼기
-- 1-6. concat 문자열연결

-- #1. 대소문자
select   ename, upper(ename), lower(ename), initcap(ename)   
from     emp;

-- #2. 문자열길이
select ename, length(ename), lengthb(ename) , '킹' , length('킹') , lengthb('킹')
from emp;

-- #3. substr(문자열, 어디서부터 ,몇개 ) 부분문자열 , instr  위치문자열
select ename, substr(ename, 1,2) ,  substr(ename, 1,3) , substr(ename, 2,2) , substr (ename, 3,2)  from emp;
select     substr('oracle' , -1) , substr('oracle' , -3)                , substr('oracle' , -3,2) from dual;
--           e 뒤에서1번부터끝까지      cle 뒤에서부터 세번째부터 끝까지         cl 뒤에 세번째부터  2개
--   -붙이면 끝에서 부터 계산
select     substr('oracle' , -2) ,  substr('oracle' , -2,1)  from dual;  -- le  l

select    instr('oracle' , 'a') from dual;  -- o(1) r(2) a(3) c(4) l(5) e(6)
select   ename, instr(ename, 'A') from emp; -- 있으면 위치, 없으면 0

-- #4. replace(어떤문자열을, 찾아서, 바꾸기) 바꾸기 ,  lpad, rpad 채우기
select  replace( '010-1234-5678' ,'-',' ') from dual;
select  lpad('oracle' , 10 , '#') , rpad('oracle' , 10 , '#') from dual;  -- ㅣ (left채우기)   r( right채우기)

-- #5. trim , ltrim, rtrim  공백빼기
select  trim(' *oracle* ') , ltrim(' *oracle* ') , rtrim(' *oracle* ')  
from dual;

-- #6. concat 문자열연결- 두개의 문자열만 연결가능
select   concat('Hello ' , 'Oracle') from     dual;
select   concat(  concat('Hello ' , 'Oracle')  , '★') from     dual;  -- concat 중첩해서 사용

select  'Hello '  || 'Oracle ' || '♥'  from dual;

-------------------------------------------------------------------------------------
-- ##1. 문자열 연습문제   (1~18)
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle004_select_fn#14

-- Q001
-- EMP 테이블에서 ENAME을 대문자, 소문자, 첫글자만 대문자로 조회하시오.
SELECT ename, upper(ename), lower(ename) , initcap(ename)
FROM   emp;
 

--Q002
--EMP 테이블에서 UPPER를 이용하여 ENAME이 KING인 데이터를 조회하시오.
select ename
from   emp
where  upper(ename)=upper('king');

select ename
from   emp
where  lower(ename)=lower('king');


--Q003 
-- EMP 테이블에서 UPPER를 이용하여 ENAME에 KING인 포함된 데이터를 조회하시오.
-- 대소문자 상관없이 KING인 사람을 조회하는 것이 가능해짐.
select  ename from    emp   where   ename = 'king';  -- = 같다
select  ename from    emp   where   upper(ename) like upper('%a%'); --포함되는

select  ename from    emp   where   upper(ename) like upper('%king%');  -- 정답 ✅


--Q004 
-- EMP 테이블에서 LENGTH를 이용하여 ENAME의 문자열 길이를 조회하시오.
select  ename, length(ename) 
from     emp;

--Q005 
-- EMP 테이블에서 ENAME의 문자열 길이가 5이상인 데이터를 조회하시오.
select ename , length(ename)
from   emp
where length(ename)>=5;

--Q006 
--LENGTH('한글'), LENGTHB('한글')
--문자열길이반환, 문자열 바이트 수 반환
select   length('한글'), lengthb('한글')
from      dual;

--------------------------------
--Q007 
-- 문자열 일부분을 추출
-- SUBSTR( 문자열 , 시작위치, 추출길이)
select  job, substr(job, 1,2) , substr(job, 3,2) , substr(job,5)
from    emp;

--Q008  
-- -의 의미는? 역순으로, 끝에서부터 
-- C(-5)L(-4)E(-3)R(-2)K(-1)
select job  , substr(job, -length(job)) , substr(job, -length(job) , 2)  , substr(job, -3)
from  emp;

--Q009   'HELLO, ORACLE!
-- INSTR(문자열, 찾을거, 시작위치, 몇번째)
-- 1. 해당위치의 글자가뭔지 확인   3, 12, 4   (L)
--    H(1)E(2)L(3)L(4)O(5),(6) (7)O(8)R(9)A(10)C(11)L(12)E(13)!(14)
-- 2. INSTR이용해서 해당값 구하기
select 'HELLO, ORACLE!'  
, instr('HELLO, ORACLE!' , 'L')  as instr_1
, instr('HELLO, ORACLE!' , 'L' , 5)  as instr_2
, instr('HELLO, ORACLE!' , 'L' , 2, 2)  as instr_2
from   dual;
 

--Q010 
-- EMP테이블에서 INSTR 함수로 사원이름에 S가 있는 데이터를 조회하시오
SELECT   *
FROM     EMP
WHERE    instr(ename,'S')   > 0;  -- instr은 못찾으면 0

--Q011
-- EMP테이블에서 LIKE를 이용하여 사원이름에 S가 있는 데이터를 조회하시오
SELECT   *
FROM     EMP
WHERE    ename  like '%S%';

--Q012 
--REPLACE를 이용하여 연락처의 -을 공백으로, -을 뺀데이터로 조회하시오
select '010-1234-5678' as BEFORE
, REPLACE('010-1234-5678' ,'-', ' ') REPLACE1
, REPLACE('010-1234-5678' ,'-') REPLACE2
from   dual


--Q013
--LPAD, RPAD를 이용하여 다음과 같이 데이터를 출력하시오 
SELECT  'ORACLE'
,    lpad('Oracle' , 10 , '#')  lpad_1
,    rpad('Oracle' , 10 , '*')  rpad_1
,    lpad('Oracle' , 10  )      lpad_2
,    rpad('Oracle' , 10  )      rpad_2
FROM    dual;


--Q014 
-- RPAD를 이용하여 개인정보뒷자리 *로 출력하시오.
select rpad('911225-', 14 , '*')  JUNO
, rpad('010-1234-', 13, '*')  PHONE
from   dual;

--Q015 
--EMP 테이블에서 EMPNO와 ENAME 사이에 :을 넣고 문자열을 연결하시오.
SELECT CONCAT(empno, ename) , concat(  empno   ,concat(':' , ename))
FROM   EMP
WHERE  ENAME = UPPER('Scott');

--Q016 
-- TRIM을 이용하여 다음과 같이 공백을 제거하고 출력하시오.
select
   '[' ||  trim(' * *Oracle* * ') || ']' as trim  -- 양쪽공백제거 (중간에 있는공백은 제거하지 않음)
,  '[' ||  trim( LEADING   FROM   ' * *Oracle* * ') || ']' as trim --  앞쪽공백제거
,  '[' ||  trim( TRAILING  FROM   ' * *Oracle* * ') || ']' as trim   --  뒤쪽공백제거
,  '[' ||  trim( BOTH      FROM   ' * *Oracle* * ') || ']' as trim  -- 양쪽공백제거
from   dual;

select
   '[' ||  trim(' * *Oracle* * ') || ']' as trim  -- 양쪽공백제거 (중간에 있는공백은 제거하지 않음)
,  '[' ||  ltrim(' * *Oracle* * ') || ']' as trim -- 왼쪽공백없애기
,  '[' ||  rtrim(' * *Oracle* * ') || ']' as trim -- 오른쪽공백제거
,  '[' ||  trim(' * *Oracle* * ') || ']' as trim  -- 양쪽공백제거
from   dual;

--Q017  RIM을 이용하여 삭제할 문자 삭제후
select
   '[' ||  trim(' * *Oracle* * ') || ']' as trim1   
,  '[' ||  trim( LEADING  '*' FROM   '* *Oracle* *') || ']' as trim2  
,  '[' ||  trim( TRAILING '*' FROM   '* *Oracle* *') || ']' as trim3    
,  '[' ||  trim( BOTH     '*' FROM   '* *Oracle* *') || ']' as trim4  
from   dual;   -- '* *Oracle* *'

--Q018  .....
select
   '[' ||      trim(' * *Oracle* * ')         || ']' as trim0     -- trim 양쪽공백없애기
,  '[' ||      ltrim(' * *Oracle* * ')        || ']' as ltrim1    -- ltrim 왼쪽공백없애기
,  '[' ||      ltrim('*-Oracle-*' , '*')      || ']' as ltrim2  -- ltrim 원하는문자열없애기
,  '[' ||      rtrim(' * *Oracle* * ')        || ']' as rtrim1    -- rtrim 오른쪽공백없애기
,  '[' ||      rtrim('*-Oracle-*' , '*')      || ']' as rtrim2  -- rtrim 원하는 문자열없애기
from   dual;



