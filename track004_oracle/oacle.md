■#1. 저장단위
변수 < 배열 < 클래스 < 콜렉션프레임워크  > file > DB
※ DB( mysql , oracle , mssql)

> java : jdbc  → dbcp → orm (mybatis , jpa)

■#2. RDB (Relational Database)  ★
-    관계형 데이터  베이스
-    테이블 관계
1. 엔티티(Entity)     - 테이블 - 관리할대상  (고객, 주문, 상품)
2. 속성(Attribute)    - 컬럼  - 대상의 특징 (주민번호, 이름, 주문번호)
3. 관계(Relationship) - 외래키 - 대상간의 연결    - 고객은 주문을 한다

■#3. 데이터베이스 언어   ★
1. 정의어(DDL)  -  create ,  alter, drop    .....  cad 
2. 조작어(DML)  -  insert(삽입) , select(조회) , update(수정), delete(지우기) ..... crud
3. 제어어(DCL)  -  grant , revoke

<<사원>> 
SQL> desc emp;
이름       널?       유형           
-------- -------- ------------ 
EMPNO    NOT NULL NUMBER(4)    
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER(4)    
HIREDATE          DATE         
SAL               NUMBER(7,2)  
COMM              NUMBER(7,2)  
DEPTNO            NUMBER(2)    

<<부서>> 
SQL> desc dept;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 DEPTNO                                    NOT NULL NUMBER(2)
 DNAME                                              VARCHAR2(14)
 LOC                                                VARCHAR2(13)

> 부서는 많은 사원을 가질수 있다.
관리대상(table)    :   dept       emp     
속성(attribute)   :   deptno     empno ,deptno ,,,
연결(Relationship):   deptno



■#4. SELECT 기본 (1)
[실습]
```sql
-- #1. 테이블구조확인
desc emp;
desc dept;

show user;       -- 실행) 현재줄 선택하고 ctrl + enter
select  table_name   from  user_tables;    -- 사용할수 있는 테이블 확인

-- #2. 전체테이블 조회
select * from emp;

-- #3. 열조회
select empno, ename  from  emp;
select ename, job    from  emp;

-- #4. 중복제거 (distinct)
select  distinct  job   from  emp;
select  all       job   from  emp;

-- #5. 연산 및 별칭
desc  emp;

--  3달치 급여
select  ename "유저" , sal as "월급"  , sal+sal+sal   as  "3달치 월급"       from emp;

-- #6. 정렬
select   ename, sal   from     emp   order by sal asc ;    -- asc는 오름차순
select   ename, sal   from     emp   order by sal  desc;   -- desc는 내림차순
```
-- ## Step3 연습문제
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle002_select_basic#15

※ 기타)
1. 정의어(DDL)  -  create ,  alter, drop    .....  cad 

CREATE TABLE emp (
  empno NUMBER(4),
  ename VARCHAR2(10),
  job VARCHAR2(9),
  mgr NUMBER(4),
  hiredate DATE,
  sal NUMBER(7,2),
  comm NUMBER(7,2),
  deptno NUMBER(2)
);

INSERT INTO emp VALUES (7839, 'KING', 'PRESIDENT', NULL, TO_DATE('1981-11-17','YYYY-MM-DD'), 5000, NULL, 10);
INSERT INTO emp VALUES (7698, 'BLAKE', 'MANAGER', 7839, TO_DATE('1981-05-01','YYYY-MM-DD'), 2850, NULL, 30);
INSERT INTO emp VALUES (7782, 'CLARK', 'MANAGER', 7839, TO_DATE('1981-06-09','YYYY-MM-DD'), 2450, NULL, 10);
INSERT INTO emp VALUES (7566, 'JONES', 'MANAGER', 7839, TO_DATE('1981-04-02','YYYY-MM-DD'), 2975, NULL, 20);
INSERT INTO emp VALUES (7902, 'FORD', 'ANALYST', 7566, TO_DATE('1981-12-03','YYYY-MM-DD'), 3000, NULL, 20);
INSERT INTO emp VALUES (7369, 'SMITH', 'CLERK', 7902, TO_DATE('1980-12-17','YYYY-MM-DD'), 800, NULL, 20);
INSERT INTO emp VALUES (7788, 'SCOTT', 'ANALYST', 7566, TO_DATE('1987-07-13','YYYY-MM-DD'), 3000, NULL, 20);
INSERT INTO emp VALUES (7876, 'ADAMS', 'CLERK', 7788, TO_DATE('1987-07-13','YYYY-MM-DD'), 1100, NULL, 20);
INSERT INTO emp VALUES (7934, 'MILLER', 'CLERK', 7782, TO_DATE('1982-01-23','YYYY-MM-DD'), 1300, NULL, 10);
INSERT INTO emp VALUES (7654, 'MARTIN', 'SALESMAN', 7698, TO_DATE('1981-09-28','YYYY-MM-DD'), 1250, 1400, 30);
INSERT INTO emp VALUES (7499, 'ALLEN', 'SALESMAN', 7698, TO_DATE('1981-02-20','YYYY-MM-DD'), 1600, 300, 30);
INSERT INTO emp VALUES (7844, 'TURNER', 'SALESMAN', 7698, TO_DATE('1981-09-08','YYYY-MM-DD'), 1500, 0, 30);
INSERT INTO emp VALUES (7900, 'JAMES', 'CLERK', 7698, TO_DATE('1981-12-03','YYYY-MM-DD'), 950, NULL, 30);
INSERT INTO emp VALUES (7521, 'WARD', 'SALESMAN', 7698, TO_DATE('1981-02-22','YYYY-MM-DD'), 1250, 500, 30);
 

-- ## Step4 사고확장
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle002_select_basic#45


■#5. SELECT 기본 (2)  조건에 맞는 데이터 조회
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


-- #3. 집합연산자
 union (중복제거하고 합집합) ,  union all (중복 포함하고 합집합) , minus(차집합) , intersect(교집합)
--  1) 집합연산자 : union (중복제거하고 합집합) ,  union all (중복 포함하고 합집합) , minus(차집합) , intersect(교집합)
```sql
SELECT * 
FROM   EMP
WHERE  DEPTNO=10
UNION
SELECT * 
FROM   EMP
WHERE  DEPTNO=10;
``` 

-- 2)  union all (중복 포함하고 합집합)
```sql
SELECT * 
FROM   EMP
WHERE  DEPTNO=10
UNION ALL
SELECT * 
FROM   EMP
WHERE  DEPTNO=10;
```


-- 3)  Minus( 차집합 )
```sql
SELECT * 
FROM   EMP 
MINUS
SELECT * 
FROM   EMP
WHERE  DEPTNO=20;
```


-- 4) INTERSECT  (교집합)
```sql
SELECT * 
FROM   EMP 
INTERSECT
SELECT * 
FROM   EMP
WHERE  DEPTNO=20;
```


 -- 연습문제  (30~37) ~50
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle003_select_where#71


-- 사고확장  (1~6)
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle003_select_where#87


■#6. SELECT 기본  (3) function


■#7. SELECT 기본  (4) group


■#8. SELECT 기본  (5) join


■#9. SELECT 기본  (6) subquery

 
■#10. SELECT 기본 (7) update/ delete

 
■#11. SELECT 기본 (8) transaction

 
■#12. SELECT 기본 (9) ddl


■#13. SELECT 기본 (10) object

 
■#12. SELECT 기본 (11) constraint


■#13. SELECT 기본 (12) user


■#13. SELECT 기본 (13) plsql




