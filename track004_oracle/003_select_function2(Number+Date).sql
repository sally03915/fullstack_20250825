-------------------------------------------------------------------------------------
-- 003_select_function.sql
-- 1. 문자열
-- 2. 숫자   :   round / trunc(반올림/버림) , ceil( 올림 ) , floor ( 내림) , mod  (나머지)
-- 3. 날짜   :   sysdate (시스템날짜), add_months(몇달뒤에) , next_day, last_day
-- 4. 변환   :   to_char (날짜형식변환), to_date
-- 5. 조건   :   nvl, nvl2 ( null) , decode, case ( 조건분기 ) 
-------------------------------------------------------------------------------------
-- 2. 숫자   :   round / trunc(반올림/버림) , ceil( 올림 ) , floor ( 내림) , mod  (나머지)
select   round(  1234.5678   )   , round(  1234.5678  , 2  ) , trunc(  1234.5678  , 2  ) , ceil(1.1) , floor(4.8)  , mod(10,3)
from dual;     -- 1235              1234.57                       1234.56                      2          4            1

-------------------------------------------------------------------------------------
-- 3. 날짜   :   sysdate (시스템날짜,시간반환), add_months(몇달뒤에) , next_day, last_day
select   SYSDATE  , add_months(  SYSDATE, 1) ,    months_between(  '25-12-1'  , '24-12-1' )
from     dual;

select  NEXT_DAY(SYSDATE,  '월요일')  "다음주 월요일" ,   LAST_DAY(SYSDATE)  "해당월의 마지막 날짜"
from dual;

select  NEXT_DAY(SYSDATE,  1)  "다음주 월요일" ,   LAST_DAY(SYSDATE)  "해당월의 마지막 날짜"
from dual;

-------------------------------------------------------------------------------------
-- 4. 변환   :   to_char (날짜형식변환), to_date
--                날짜를     문자로                         문자를         날짜로
select   TO_CHAR( SYSDATE , 'YYYY-MM-DD' ) ,  TO_DATE(  '2025-10-16' , 'YYYY-MM-DD'  )
from     dual;

--        숫자1234를 문자열로 변환한 다음 +1   ( 자동변환해서 오류가 안날수 있음. )
select    TO_CHAR(1234)               + 1       ,   TO_NUMBER('5678') + 1 
from     dual;

select    TO_CHAR('일이삼사')               + 1   ,   TO_NUMBER('5678') + 1   -- 오류
from     dual;

select           "1234"   + 1  , 1+"1234"       --  자료형이 안맞으면 오류남.
from     dual;

-------------------------------------------------------------------------------------
-- 5. 조건   :   nvl, nvl2 ( null) , decode, case ( 조건분기 ) 

select   nvl(  NULL , '대체값' )             from      dual; -- null 이면 대체값    / null  value  logic( replacement )
select   nvl(          comm  , '입력안됨.')   from     emp;   -- X 오류
select   nvl(  to_char(comm) , '입력안됨.')   from     emp;   -- O 자료형을 맞춰야함.

select  nvl2( NULL, 'A' , 'B'  )     from dual;    -- null 일때 b, 아니면 a
-----
select  nvl2( mgr,          mgr , '--'  )     from emp;   -- 오류나는이유는? 
select  nvl2( mgr, to_char(mgr) , '상위관리자 x'  )     from emp;   -- 해결방안    ( nvl, nvl2  null일때 값 반환 / 자료형맞추기)
-----
select decode( deptno, 10 , '부서10' , 20, '부서20' , 30, '부서30' )
from   emp;
-----
select case  
            when deptno=10 then  '부서10'  
            when deptno=20 then  '부서20'   
            when deptno=30 then  '부서30'  
            else                 '부서x'
       end
from   emp;
-----
select case deptno 
            when 10 then  '부서10'  
            when 20 then  '부서20'   
            when 30 then  '부서30'  
            else          '부서x'
       end
from   emp;
-------------------------------------------------------------------------------------
-- ##1. 문자열 연습문제   (45~49)   ~17:00
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle004_select_fn#61



-- Q045  EMP테이블에서 NVL 함수를 사용하여 다음과 같이 출력하시오   ( nvl 이용 comm 이 null 이면 0 )  - nvl( NULL, '반환값')
select empno, ename, sal, comm,  sal + comm  , nvl( comm , 0) , sal + nvl(comm, 0)
from   emp;

-- Q046  EMP테이블에서 NVL2 함수를 사용하여 다음과 같이 출력하시오. (nvl2 이용  comm이  null 이면 'X')- nvl2( NULL, 'NULL아님','반환값')
select empno, ename,  comm,   nvl2( comm , 'O' , 'X') , sal*12 + nvl2( comm , comm , 0)
from   emp;

-- Q047  EMP테이블에서 DECODE 함수를 사용하여 다음과 같이 출력하시오.  (decode)
--JOB이 MANAGER 는 급여의 10% 인상한 급여       SAL*1.1
--SALESMAN 는 급여의 5% 인상한 급여             SAL*0.5
--ANALYST 는 그대로                            SAL 
--나머지는 3% 인상된 급여         SAL*0.3
select  empno, ename, job, sal , 
        decode(  job 
            , 'MANAGER'  ,  SAL*1.1    -- when   then
            , 'SALESMAN' ,  SAL*1.05   -- when   then
            , 'ANALYST'  ,  SAL
            , SAL*1.03  -- else
        ) upsal
from    emp;
-- Q048
--EMP테이블에서 CASE 함수를 사용하여 다음과 같이 출력하시오.  (case when  then   else  end)
select  empno, ename, job, sal , 
        case 
            when  job='MANAGER'   then SAL*1.1 
            when  job='SALESMAN'  then SAL*1.05 
            when  job='ANALYST'   then SAL
            else  SAL*1.03  
        end   upsal
from    emp;

select  empno, ename, job, sal , 
        case  job
            when  'MANAGER'   then SAL*1.1 
            when  'SALESMAN'  then SAL*1.05 
            when  'ANALYST'   then SAL
            else  SAL*1.03  
        end   upsal
from    emp;

-- Q049
--기준데이터 없이 조건식으로만 CASE 사용가능    case when  then   else  end)
--COMM 값이 NULL 이면 해당사항 없음
--0 이면 수당없음
--0 초과시 초과한 수당을 출력
select  empno, ename, comm
        , case   
            when   comm is null  then   '해당사항 없음'
            when   comm = 0      then   '수당없음'           
            when   comm > 0      then   '수당 : ' || comm
          end   comm_text
from    emp;


-------------------------------------------------------------------------------------
-- ##1. 문자열 연습문제   (19~44)
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle004_select_fn#14

-- Q019
--ROUND를 이용하여 반올림 된 숫자 출력하기
select  round(1234.5678)     r 
,       round(1234.5678 , 0) r1
,       round(1234.5678 , 1) r2
,       round(1234.5678 , 2) r3
,       round(1234.5678 , -1) "r4 -숫자제거"
,       round(1234.5678 , -2) r5
from    dual;

-- Q020
--TRUNC를 이용하여 반올림 된 숫자 출력하기
select  TRUNC(1234.5678)     "r 버리기 "
,       TRUNC(1234.5678 , 0) r1
,       TRUNC(1234.5678 , 1) r2
,       TRUNC(1234.5678 , 2) r3
,       TRUNC(1234.5678 , -1) "r4 -숫자제거"
,       TRUNC(1234.5678 , -2) r5
from    dual;

-- Q021 ceil , floor
--          4              3             -3            -4
select ceil(3.14)  , floor(3.96) , ceil(-3.14)  , floor(-3.96)
from   dual;

-- Q22  MOD
--   10을 3으로 나눴을때 나머지  , 10을 2로 나눴을때 나머지 , 
select   mod(10,3)                 , mod(10,2)          , mod(10,4) 
from     dual;

-- Q23  SYSDATE 함수를 사용하여 날짜 출력 - 하루이전, 이후
select  sysdate 오늘 ,   sysdate-1 어제 , sysdate+1 내일
from dual;

-- Q024 ADD_MONTHS 3개월 
select   sysdate, add_months( sysdate, 3 )  "3개월뒤"
from     dual;

-- Q25  Q025  - [ADD_MONTHS 연습문제]
-- EMP 테이블에서 입사 10주년( 1년 12, 10년 12*10)이 되는 사원들의 데이터

select  empno, ename, hiredate , add_months( hiredate, 120 )  "10주년"
from    emp;

-- sysdate, add_months , next_day , last_day  , to_char
-- Q026         - [ADD_MONTHS 연습문제]
-- EMP 테이블에서 입사 42년 미만인 사원데이터를 출력하시오.
-- 12*42 = 

select empno , ename, hiredate,sysdate,  add_months(  hiredate, 504 )  "42년"
from emp
where add_months( hiredate, 504 ) > sysdate;

-- Q27  
-- 24/12/21 기준으로 다음과 같이 구분
--empno, ename, hiredate, sysdate (24/12/21), months1, months2, months3
select empno , ename, hiredate, to_date('2024-12-21' , 'YYYY-MM-DD')
,   MONTHS_BETWEEN(  hiredate , to_date('2024-12-21' , 'YYYY-MM-DD')     )    months1  
,   MONTHS_BETWEEN(  to_date('2024-12-21' , 'YYYY-MM-DD') ,  hiredate    )    months2  
,   TRUNC(    MONTHS_BETWEEN(  to_date('2024-12-21' , 'YYYY-MM-DD') ,  hiredate    )       )  months3
from emp;

-- Q28  -- SYSDATE, ADD_MONTHS , NEXT_DAY /  LAST_DAY /  MONTHS_BETWEEN
SELECT  SYSDATE ,   NEXT_DAY( SYSDATE , '월요일'  ) , LAST_DAY(SYSDATE)
FROM   DUAL;

-- Q29   -- ROUND ( 반올림 기준)
SELECT  SYSDATE  
,  ROUND(  SYSDATE  , 'CC'  )  "CC 세기- Century"
,  ROUND(  SYSDATE  , 'YYYY'  )  "YYYY-★"
,  ROUND(  SYSDATE  , 'Q'  )  "Q-분기"
,  ROUND(  SYSDATE  , 'DDD'  )  "DDD-연중일수"
,  ROUND(  SYSDATE  , 'HH'  )  "HH 시간"
FROM    DUAL;

-- Q30  -- trunc ( 버리기 )
SELECT  SYSDATE  
,  trunc(  SYSDATE  , 'CC'  )  "CC 세기- Century"
,  trunc(  SYSDATE  , 'YYYY'  )  "YYYY-★"
,  trunc(  SYSDATE  , 'Q'  )  "Q-분기"
,  trunc(  SYSDATE  , 'DDD'  )  "DDD-연중일수"
,  trunc(  SYSDATE  , 'HH'  )  "HH 시간"
FROM    DUAL;

-- Q31.  - [문자 + 숫자 연습문제]
-- empno 숫자 + '500' ( 문자열500이지만 , 알파벳포함X A) = 자동변환
select empno, ename, empno + '500'
from   emp
where  ename='SCOTT';

select empno, ename, empno + TO_NUMBER( '500' )
from   emp
where  ename='SCOTT';

-- Q32
select empno, ename, empno + '500a'
from   emp
where  ename='SCOTT';

-- Q33. sysdate
select   sysdate,    to_char( sysdate, 'YYYY/MM/DD  HH24:MI:SS' )
from     dual;

-- Q34~38

-- Q6-34
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'MM') AS MM,
       TO_CHAR(SYSDATE, 'MON') AS MON,
       TO_CHAR(SYSDATE, 'MONTH') AS MONTH,
       TO_CHAR(SYSDATE, 'DD') AS DD,
       TO_CHAR(SYSDATE, 'DY') AS DY,
       TO_CHAR(SYSDATE, 'DAY') AS DAY
  FROM DUAL;

-- Q6-35
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'MM') AS MM,
       TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = KOREAN' ) AS MON_KOR,
       TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = JAPANESE') AS MON_JPN,
       TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS MON_ENG,
       TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = KOREAN' ) AS MONTH_KOR,
       TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = JAPANESE') AS MONTH_JPN,
       TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS MONTH_ENG
  FROM DUAL;

-- Q6-36
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'MM') AS MM,
       TO_CHAR(SYSDATE, 'DD') AS DD,
       TO_CHAR(SYSDATE, 'DY', 'NLS_DATE_LANGUAGE = KOREAN' ) AS DY_KOR,
       TO_CHAR(SYSDATE, 'DY', 'NLS_DATE_LANGUAGE = JAPANESE') AS DY_JPN,
       TO_CHAR(SYSDATE, 'DY', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS DY_ENG,
       TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = KOREAN' ) AS DAY_KOR,
       TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = JAPANESE') AS DAY_JPN,
       TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS DAY_ENG
  FROM DUAL;

-- Q6-37
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'HH24:MI:SS') AS HH24MISS,
       TO_CHAR(SYSDATE, 'HH12:MI:SS AM') AS HHMISS_AM,
       TO_CHAR(SYSDATE, 'HH:MI:SS P.M.') AS HHMISS_PM
  FROM DUAL;

-- Q6-38
SELECT SAL,
       TO_CHAR(SAL, '$999,999') AS SAL_$,
       TO_CHAR(SAL, 'L999,999') AS SAL_L,
       TO_CHAR(SAL, '999,999.00') AS SAL_1,
       TO_CHAR(SAL, '000,999,999.00') AS SAL_2,
       TO_CHAR(SAL, '000999999.99') AS SAL_3,
       TO_CHAR(SAL, '999,999,00') AS SAL_4
  FROM EMP;

-- Q39 숫자-'숫자로만이뤄진문자열'  가능
select  1300- '1500' ,  '1300' + 1500
from dual;


-- Q40 '숫자로만이뤄진문자열'
select   '1500' - '1300'
from dual;

select   '1,500' - '1,300'  
from dual;   -- X

-- Q41. TO_NUMBER (포맷형식에 맞춰서)
select   TO_NUMBER('1,500' , '999,999') - TO_NUMBER('1,300', '999,999')
from dual;

-- Q42. TO_CHAR
SELECT    TO_DATE( '2025-10-17' , 'YYYY-MM-DD')
from     dual;

-- Q6-43
SELECT *
  FROM EMP
 WHERE HIREDATE > TO_DATE('1981/06/01', 'YYYY/MM/DD');

-- Q6-44
SELECT TO_DATE('49/12/10', 'YY/MM/DD') AS YY_YEAR_49,
       TO_DATE('49/12/10', 'RR/MM/DD') AS RR_YEAR_49,
       TO_DATE('50/12/10', 'YY/MM/DD') AS YY_YEAR_50,
       TO_DATE('50/12/10', 'RR/MM/DD') AS RR_YEAR_50,
       TO_DATE('51/12/10', 'YY/MM/DD') AS YY_YEAR_51,
       TO_DATE('51/12/10', 'RR/MM/DD') AS RR_YEAR_51
FROM DUAL;



-------------------------------------------------------------------------------------
-- Ex1. EMP 테이블에서 다음과 같은 결과가 나오도록 SQL문을 작성하시오.
--EMP 테이블에서 ENAME이 다섯글자 이상이며 여섯글자 미만인 사원을 조회하시오.
--MASKING_EMPNO 는 EMPNO 앞두자리외 뒷자리를 *로 출력
--MASKING_ENAME 는 사원이름의 첫글자만 보여주고 나머지는 *로 출력
--※ 앞자리 추출 - SUBSTR(문자열, 어디에서, 몇개)
--※ RPAD - RPAD( 문자열, 몇자리, 채울값)

-- 힌트1)
-- Step1)   select     from   where  구문적기
-- Step2)   from  채우기
-- Step3)   where  채우기  -  ENAME이 다섯글자 이상이며 여섯글자 미만인 사원을 조회
--          length(ename)  이상  5   그리고      length(ename)  이하 6
-- Step4)   오른쪽채우기 rpad  (  substr(empno에서 , 첫번째부터, 2글자  )  , 4자리 맞추기 , '*'로 채우기   ) 

select   empno   ,   rpad( substr( empno , 1,2  ) ,   4                ,'*'     )    MASKING_EMPNO 
       , ename   ,   rpad( substr( ename , 1,1  ) ,   length(ename)    , '*'    )  MASKING_ENAME 
from     emp  
where    length(ename) >=5   and  length(ename)<6;    


---------
-- EX002
--EMP 테이블에서 다음과 같은 결과가 나오도록 SQL문을 작성하시오.
--EMP 테이블에서 사원들의 월 평균 근무일 수는 21.5일
--2 하루 근무시간을 8시간으로 보았을때 사원들의 하루급여(DAY_PAY) 와 시급(TIME_PAY)을 계산하여 결과를 조회하시오.
--※ 하루급여는 소수점 세번째 자리에서 버리고(TRUNC), 시급은 두번째 소수점에서 반올림(ROUND)하시오  --##

-- Step1)   select     from   where  구문적기
-- Step2)   from  채우기
-- Step4)   select 채우기    -  trunc( 급여(sal)/21.5  , 2 )  소수점 버리기 /  round( 급여(sal)/21.5/8 , 1   )
--  한달급여 sal 
--  일일급여 sal/21.5    ,  시급  sal/21.5/8

select  empno, ename, sal,  trunc(  sal/21.5  ,2)   day_pay     , round( sal/21.5/8 , 1)  time_pay
from    emp;
--where


---------
--EX003
---  EMP 테이블에서 다음과 같은 결과가 나오도록 SQL문을 작성하시오. 
--1. EMP테이블에서 사원들은 입사일(HIREDATE)을 기준으로 3개월이 지난 후 첫 월요일에 정직원이 됨
--2. 사원들이 정직원이 되는 날짜(R_JOB)를 YYYY-MM-DD 형식으로 오른쪽과 같이 출력하시오.
--3. 추가 수당(COMM)이 없는 사원들의 추가수당은 N/A로 출력하시오.

-- Step1)   select     from   where  구문적기
-- Step2)   from  채우기
-- Setp3)   입사일(HIREDATE)을 기준으로 3개월이 지난 후 첫 월요일에 정직원이 됨  ADD_MONTHS(HIREDATE, 3)  3개월뒤
--           첫월요일   - NEXT_DAY(ADD_MONTHS(HIREDATE, 3), '월요일')
--           문자열로   - TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 3), '월요일'), 'YYYY-MM-DD')
--          추가수당이 있는지 확인      NVL(  TO_CHAR(COMM)  , 'N/A'  ) null 이라면 'N/A'
select    empno, ename, hiredate 
    , TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE,3) ,  2 ) ,'YYYY-MM-DD')     R_JOB    
    -- 3개월이(ADD_MONTHS) / 첫 월요일 NEXT_DAY( 날짜 , '월요일'  ) 1-7 '일'(1)  '월'(2)  /  TO_CHAR  YYYY-MM-DD
    , NVL(  TO_CHAR( COMM ) , 'N/A'   ) COMM 
from      emp;
--where   



---------
--Ex004) EMP 테이블에서 다음과 같은 결과가 나오도록 SQL문을 작성하시오.
--1. 직속상관의 사원번호(MGR)를 다음과 같은 조건을 기준으로 변환해서 CHG_MGR열에 출력하시오
--1) 직속상관의 사원번호가 존재하지 않을경우 : 00000
--2) 직속상관의 사원번호 앞 두자리가 75일 경우 : 5555
--3) 직속상관의 사원번호 앞 두자리가 76일 경우 : 6666
--4) 직속상관의 사원번호 앞 두자리가 77일 경우 : 7777
--5) 직속상관의 사원번호 앞 두자리가 78일 경우 : 8888
--6) 그 외 직속상관 사원번호의 경우 : 본래 직속상관의 사원번호 그대로 출력

-- Step1)   select     from   where  구문적기
-- Step2)   from  채우기
-- Step3)   case  when   then  end   구문 채우기
--      case   처리대상(mgr)
--          when   사원번호가 존재하지 않을경우(mgr  is null)  then   '00000'
--          when   직속상관의 사원번호 앞 두자리(문자열일부분)   substr(  mgr , 첫글자부터(1), 몇개(2) ) = '78'   then   '8888'
--          when   직속상관의 사원번호 앞 두자리(문자열일부분)   substr(  mgr , 첫글자부터(1), 몇개(2) ) = '77'   then   '7777'
--          when   직속상관의 사원번호 앞 두자리(문자열일부분)   substr(  mgr , 첫글자부터(1), 몇개(2) ) = '76'   then   '6666'
--          when   직속상관의 사원번호 앞 두자리(문자열일부분)   substr(  mgr , 첫글자부터(1), 몇개(2) ) = '75'   then   '5555'
--          else   to_char(mgr)
--      end   CHG_MGR


select   empno, ename, mgr, 
        case
            when  mgr is null  then  '0000'
            when  substr(  mgr  , 1, 2 )  = '78' then  '8888'
            when  substr(  mgr  , 1, 2 )  = '77' then  '7777'
            when  substr(  mgr  , 1, 2 )  = '76' then  '6666'
            when  substr(  mgr  , 1, 2 )  = '75' then  '5555'
            else  to_char(mgr)
        end chg_mgr    
from    emp
--where
 

---------















