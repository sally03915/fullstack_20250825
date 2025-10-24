-- 1 
select * from emp;

-- 2. 집계 sum ,  max , min ,  avg , count
select  sum(sal)   from   emp;  -- 급여의 합계
select  sum(comm)  from   emp;  -- null 값이 있어도 계산가능

--       14줄  1줄
-- select sal, sum(sal), max(sal), min(sal), avg(sal), count(sal) from emp; -- error
select   sum(sal) 합, max(sal) 최대, min(sal) 최소,  round( avg(sal) ,2) 평균 , count(sal) 갯수 from emp;


-- 3. group by
--select  --5
--from    --1
--where   --2  (전체필터링)
--group by  --3 그룹핑
--having    --4 그룹핑안에서 조건( 그룹핑 후 필터링)
--order by; --6
-- 부서[별] 급여의 합
select   deptno , sum(sal)
from     emp
group by deptno;


-- 4. having ( 합계를 구했을때  9000이상이 그룹)
select    deptno, sum(sal) , count(*)
from      emp  
group by  deptno
having    sum(sal) >= 9000;


--####   https://sally03915.github.io/stackventure_250825/004_oracle/oracle005_select_group#14    ~37
-- Q1~Q24  (24번까지)

-- Q1 EMP 테이블에서 SUM 함수를 이용하여 급여 합계(SAL)를 출력하시오.
select        sum(sal)    from      emp;

-- Q2 error 이유  14 , 1    > ORA-00937:
select ename, sum(sal)    from emp;

--select ename, sum(sal)    from emp  group by ename;
--select        sum(sal)    from emp;

-- Q3 EMP 테이블에서 SUM 함수를 이용하여 추가수당(COMM) 합계를 출력하시오
select   sum(comm)    from  emp;  -- 1400 + 300 + 500

-- Q4 EMP 테이블에서 SUM (DISTINCT, ALL)함수를 이용하여 급여 합계를 출력하시오 -- 중복 안 빼고 처리
select * from emp;

select  sum(distinct sal) X,   sum(ALL sal) O,   sum(sal) O  from emp;

-- Q5 EMP 테이블에서 COUNT를 이용하여 데이터의 갯수를 출력하시오.
select  count(*) from emp; 

-- Q6 EMP 테이블에서 COUNT를 이용하여 부서번호가(EMPNO) 30인 데이터의 갯수를 출력하시오.
select  count(*)    -- 3
from    emp         -- 1
where   deptno=30;  -- 2

-- Q7 EMP 테이블에서 COUNT ( DISTINCT, ALL) 를 이용하여 데이터의 갯수를 출력하시오. -- 중복안빼고
select    count(distinct sal) , count(all sal), count(sal) from emp; 

-- Q8 EMP 테이블에서 COUNT를 이용하여 추가수당(COMM) 열의 갯수를 출력하시오.  -- null 값 빼고 카운트
select count(comm)  
from emp;  

-- Q9 Q009
--EMP 테이블에서 COUNT를 이용하여 추가수당(COMM) 열의 갯수를 출력하시오.  위와 실행결과가 같음
--COUNT는 NULL 처리가 들어가 있음.
select count(comm)          -- 3
from emp                    -- 1
where comm is not null;     -- 2

-- Q10 EMP 테이블에서 MAX를 이용하여 부서번호(DEPTNO)가 10번인 사원들의 최대 급여를 출력하시오.
select  max(sal)      -- 3
from    emp           -- 1
where   deptno=10;    -- 2

--1) select *        from emp   where deptno=10;
--2) select max(sal) from emp   where deptno=10;

-- Q11 EMP 테이블에서 부서번호(DEPTNO)가 10번인 사원들의 최소 급여를 출력하시오.
select min(sal)     -- 3
from   emp          -- 1
where  deptno=10;   -- 2

-- Q12 EMP 테이블에서 부서번호가 20인 사원의 입사일(HIREDATE) 중 제일 최근 입사일을 출력하시오.  -- 날짜도 집계함수 사용가능
select  max(HIREDATE)
from    emp
where   deptno=20;

-- Q13 EMP 테이블에서 부서번호가 20인 사원의 입사일(HIREDATE) 중 제일 오래된 입사일을 출력하시오.
select  min(HIREDATE)
from    emp
where   deptno=20;

-- Q14 EMP 테이블에서 부서번호가 30인 사원의 평균급여를 출력하시오.
select  avg(sal)
from    emp
where   deptno=30;


-- Q15 EMP 테이블에서 부서번호가 30인 사원의 DISTINCT로 중복을 제거한 급여 열의 평균급여를 출력하시오.
select  avg(  distinct  sal )
from    emp
where   deptno=30; 

-- Q16 EMP 테이블에서
--집합연산자(UNION ALL) 를 사용하여 각 부서별 평균급여를 출력하시오.   union all- 중복제거안하고  합집합 , union  중복제거하고 합집합
select avg(sal), '10'  as  deptno   from emp  where deptno=10 
union all
select avg(sal), '20'  as  deptno   from emp  where deptno=20 
union all
select avg(sal), '30'  as  deptno   from emp  where deptno=30;

-- x
select avg(sal), '10'  as  deptno   from emp  where deptno=10 
union all
select '20' ,avg(sal)  as  deptno   from emp  where deptno=20 
union all
select avg(sal), '30'  as  deptno   from emp  where deptno=30;






-- Q17 EMP 테이블에서 GROUP BY를 사용하여 [부서별 평균급여]를 출력하시오.
select    deptno,  avg(sal)
from      emp
group by  deptno;


-- Q18 EMP 테이블에서 부서번호(DEPTNO) 및 직책별(JOB) 평균급여(SAL)로 정렬한 후 출력하시오.
-- 집계함수( avg, sal, min, max, count ) 빼고 다 그룹핑
select      deptno, job, avg(sal)
from        emp
group by    deptno, job     
order by    deptno, job ;


-- Q19 EMP 테이블에서 GROUP BY절에 없는 열을 SELECT절에 포함하면 에러가 난다.
SELECT ENAME, DEPTNO, AVG(SAL)
  FROM EMP
GROUP BY DEPTNO;   -- ENAME, DEPTNO,

-- Q20 EMP 테이블에서 GROUP BY 와 HAVING 절을이용하여
--각부서의 직책별 평균급여를 구하되 그 평균급여가 2000이상인 그룹만 출력하시오.
select  deptno  , job, avg(sal)  --4
from      emp    --1
group by  deptno  , job   --2
having    avg(sal) >= 2000  --3
order by  deptno  , job;  --5


-- Q21 다음 코드가 오류나는 이유를 적으시오
SELECT DEPTNO, JOB, AVG(SAL)
  FROM EMP      -- 1
 WHERE AVG(SAL) >= 2000  -- 2
GROUP BY DEPTNO, JOB     -- 3 DEPTNO, JOB,
ORDER BY DEPTNO, JOB;

-- Q22  WHERE 절을 사용하지 않고 HAVING절만 사용한 경우
SELECT DEPTNO, JOB, AVG(SAL)
  FROM EMP      -- 1
GROUP BY DEPTNO, JOB     -- 2 DEPTNO, JOB,
HAVING   AVG(SAL) >= 2000  -- 3
ORDER BY DEPTNO, JOB;


-- Q23  WHERE절과 HAVING절을 모두 사용한경우
SELECT DEPTNO, JOB, AVG(SAL)  --5
  FROM EMP      -- 1     14줄
WHERE  SAL <=3000  -- 2   3000이하인애들
GROUP BY DEPTNO, JOB     -- 3 DEPTNO, JOB  그룹의 평균
HAVING   AVG(SAL) >= 2000  -- 4   
ORDER BY DEPTNO, JOB; --6

-- Q24 EMP 테이블에서
--부서별(큰그룹) 직책(소그룹)의
--사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.
SELECT     deptno, job, count(*) , max(sal), sum(sal), avg(sal)
FROM       emp
GROUP BY   deptno, job
ORDER BY   deptno, job;



-- #### https://sally03915.github.io/stackventure_250825/004_oracle/oracle005_select_group#38
-- Q25~39

