--  조건에 맞는 데이터 조회
--  #1. where      
--  #2. 비교연산자 : (같다) = , (다르다) != , <>  ,  ^=   
--  #3. 논리연산자 : AND / BETWEEN      AND  (범위지정) , OR / IN , NOT    
--  #4. like     : 패턴검색
--  #5. null 처리 : null 여부확인 
--  #6. 집합연산자 : union (중복제거하고 합집합) ,  union all (중복 포함하고 합집합) , minus(차집합) , intersect(교집합)


-- #1. 전체데이터 조회 ( emp 테이블에서 )
select * from emp;

-- #2. where  조건조회
select * from emp  where  empno =7839;   -- 같다 =
select * from emp  where  empno!=7839;   -- 다르다 !=
select * from emp  where  empno<>7839;   -- 다르다 <>
select * from emp  where  empno^=7839;   -- 다르다 ^=

select * from emp where ename='KING';

select * from emp  where  empno=7839 and  ename='KING';  -- and 두가지다 조건이 맞아야함.
select * from emp  where  empno=7839 and  ename='SCOTT'; -- x
select * from emp  where  empno=7839 or   ename='SCOTT'; -- or 둘중에 하나

select * from emp  where  sal*12 = 36000;
select * from emp  where  sal >= 3000;

select * from emp where  ename >='S';
select * from emp where  ename <='SOR';

select * from emp  where deptno>=20  and  deptno<=30;   -- >= , <=
select * from emp  where deptno  between  20  and   30; -- between and는 이상과 이하

select * from emp  where deptno=10  or  deptno=30; 
select * from emp  where deptno  in(10,30);

select * from emp  where ename =     'KING';  -- 이름이 알때
select * from emp  where ename LIKE  'A%';    -- 이름이 A로 시작할때
select * from emp  where ename LIKE  '%A%';   -- 이름이 A가 중간
select * from emp  where ename LIKE  '%G';    -- G로 끝나는
select * from emp  where ename LIKE  '_I%';   -- _(첫글자) 두번째글자가 I

select * from emp  where comm =  null;  --  X  null (데이터 없어 - 상태)
select * from emp  where comm is null; 
select * from emp  where comm is not null; 


-- 연습문제  (1~29)
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle003_select_where#11

-- Q1. emp 테이블의 모든열 조회
select * from emp;

-- Q2. 부서번호가 30인데이터
select * from emp where deptno=30;

-- Q3. 부서번호가 30 이고  job = 'SALESMAN'
select * from emp where  deptno=30  and job = 'SALESMAN';

-- Q4. or 이용해서 부서번호가 30 이거나  job = 'CLERK'
select * from emp where deptno=30  or job = 'CLERK';

-- Q5. sal 12를 곱한값이 36000인행을 조회
select * from emp  where sal* 12 = 36000; 

-- sql처리순서  ( from → where → select  )
-- select   *                 ③ * (모든컬럼값) 
-- from    emp                ① emp테이블 읽어오기
-- where sal*12=360000        ② 각행에대해( 한 명 자료묶음 ) sal*12=36000  조건평가

-- Q6. sal  3000이상인 행
select * from emp where sal>=3000;

-- Q7.  EMP테이블에서 ENAME 열의 첫문자가 F와 같거나 뒤에 있는 행
select * from emp  where ename >= 'F';

-- Q8.  EMP테이블에서 ENAME 열의 문자열이 첫문자 F, 두번째 문자 O, 세번째 문자 R, 네번째문자열이 Z 인 문자열보다 앞에 있는 행
select * from emp where ename <= 'FORZ';

-- Q9.  EMP테이블에서 != 를 이용하여 SAL열이 3000  아닌행을 조회
-- Q10. EMP테이블에서 <> 를 이용하여 SAL열이 3000  아닌행을 조회
-- Q11. EMP테이블에서 ^= 를 이용하여 SAL열이 3000  아닌행을 조회
select * from emp where sal != 3000;
select * from emp where sal <> 3000;
select * from emp where sal ^= 3000;
 

-- Q12. EMP테이블에서 NOT 를 이용하여 SAL열이 3000  아닌행을 조회
select * from emp WHERE NOT sal=3000;

-- Q13. EMP테이블에서 OR 를 이용하여 
-- JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되는 행을 조회
select * from emp  where job='MANAGER' or job='SALESMAN' or job= 'CLERK';

-- Q14. EMP테이블에서 IN 를 이용하여 
-- JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되는 행을 조회
-- from → where  → select 
select * from emp  where job in ('MANAGER' ,'SALESMAN' , 'CLERK');

-- Q15.EMP테이블에서 등가연산자(!= , <>, ^=)와 AND 를 이용하여 
-- JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되지않는 행을 조회하시오
select * from emp 
where   job != 'MANAGER' 
and     job <> 'SALESMAN' 
and     job ^= 'CLERK';

-- Q16. EMP테이블에서 NOT IN 를 이용하여
-- JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되지않는 행을 조회하시오
select * from emp  where  job  not  in ('MANAGER' ,'SALESMAN' , 'CLERK');

-- Q017 EMP테이블에서 대소비교연산자(<= , >= ) and 를 이용하여 sal 열이 2000이상 3000이하인인 행을 조회
select * from emp  where sal >= 2000 and  sal<=3000;

-- Q18. EMP테이블에서 BETWEEN AND 를 이용하여 sal 열이 2000이상 3000이하인인 행을 조회
select * from emp  where sal between 2000 and 3000;

-- Q19. EMP테이블에서 NOT BETWEEN AND 를 이용하여 sal 열이 2000이상 3000이하인사이 이외의 행 
select * from emp  where sal not between 2000 and 3000;


-- Q20. EMP테이블에서 ENAME이 S로 시작하는 행
select * from emp  where ename like 'S%';

-- Q21. EMP테이블에서 ENAME의 두번째 글자가 L인 행을 조회
select * from emp  where ename like '_L%';

-- Q22. EMP테이블에서 ENAME에 AN이 포함되어 있는 행을 조회
select * from emp  where ename like '%AN%';


-- Q23. EMP테이블에서 ENAME에 AN이 포함하고 있지 않은 행을 조회
select * from emp  where ename NOT like '%AN%';

-- Q24. EMP테이블에서 별칭을 사용하여 다음과 같이 '연간총수입' 행
select ename, sal, sal*12+comm as  annsal   , comm  from emp; 
select ename, sal, sal*12+comm     annsal   , comm  from emp; 
 
-- Q25. null
select * from emp  where  comm = null;

-- Q26. null
select * from emp  where  comm is null;
select * from emp  where  comm is not null;
 
-- Q27. emp 테이블에서 mgr열이 null 이 아닌행
select * from emp  where mgr is not null;

-- Q28. 되는 코드?  > X
select * from emp  where sal > null  and  comm  is null;
--                         x  (false) and  true

-- Q29. 되는 코드?  > O
select * from emp  where sal > null  or  comm  is null;
--                         x  (false) or  true
