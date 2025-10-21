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
--where   --2
--group by  --3 그룹핑
--having    --4 그룹핑안에서 조건
--order by; --6
-- 부서별 급여의 합
select   deptno , sum(sal)
from     emp
group by deptno;



 
 
 
 
 
 