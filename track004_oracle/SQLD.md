> 문제1)
■모델링의 3대특징 - 추단정
추상화
단순화
정확화

------------
no   animal    (  고양이-페르시안고양이 )
------------
1       cat
2       dog


> 문제2)
모델링= 설명 + 분석 + 설계


> 문제3)
■데이터모델링 : 중독일
중복최소화
독립성
일관성

<emp>  deptno
<dept>  deptno

>ver-1
empno	dname
10001	인천
10002	인천   ...500만개

deptno   dname
3	서울

>ver-2
empno	deptno
10001	3
10002	3

deptno   dname
3	서울

문제4) 
비유연성


문제5)
■ 모델링단계
개-추상      animal
논-정의      name, age
물-저장소   <table> name varchar2(20)

문제6) 
■ANSI-SPARC 스키마 (구조)
외부-사용자 (내가메뉴판)
개념-설계도 (레시피)
내부-저장소 (음식,하드디스크)


문제7) 
■erd  - 1:N 관계
<고객>+_____실선______∈<주문>

고객
1	홍길동

주문
1000	1    10


문제8)
■erd 작성순서
- 피터첸
- 도(형) -관(계) -이(름) -차(수)
- 구조와 흐름에 따라


문제9)
■ 엔티티 
-엔티티(테이블)
  누구를 관리할지를 나타내는 단어
-속성 (대상의 정보)

<환자>
이름, 나이, 주소


문제10) 
■ 엔티티특징
-엔티티(테이블)
-속성 (대상의 정보)
-관계

객체지향 싱글톤 x

<환자>
이름, 나이, 주소
가가가 10   인천
나나나 20   서울


문제11) 
-엔티티(테이블)+속성 (대상의 정보)+관계


문제12) 
기본엔티티- (primary key)
  : 독립적, 고유식별자
중심엔티티 (main)
  : 전체모델의 중심, 식별자 무관
행위엔티티
  : 이벤트, 활동중심
개념엔티티
  :추상적개념

문제13) 
약어 x

dev


문제14)
속성 : 분리x, 최소단위,  하나하나의 정보



문제15)
이름은 한개

<환자>
-----------------------
이름, 나이, 주소
-----------------------
가가가 10   인천
가나라
-----------------------
나나나 20   서울
-----------------------



문제16+17)
기본속성 :  입력하는값  원금, 이자율,
파생속성 :  계산하는값  총금액 : 원금*이자율

파생속성:
■ 미리 계산해서 저장해놓으면 빠르게 조회
- 데이터를 조회할 때 빠른 성능을 낼 수 있도록 하기 위해
원래 속성의 값을 계산하여 저장할 수 있도록 만든 속성


문제18)
데이터모델의 개념
도메인 : 값의 허용범위  + 형식

pname   varchar(20)

시스템카달로고 : db구조와 정보저장
용어사정: 용어정의
속성목록

문제19)
속성명 - 명확하고 구분가능
1. 약어제한
2. 서술식지양
3. 동일속성명 사용하지 말것 - 혼동유발
4. 자주 사용하는 용어 우선

문제20)
■ ERD   VS  UML
ERD (단일실선)
UML (실선 - 연관 , 점선-의존)

1. ERD = 실선하나
2. UML = 실선/점선구분
3. ERD  = 실선하나
4. UML = 방향성, 다중선표현

------

문제21+22)

■ 관계 :  존재 (소속) / 행위 (배송근거)
■ 관계표기법 :  관계명 , 관계차수(1:1, 1:N)


<고객>+_____실선______∈<주문>


문제23 + 24)
■ 관계도출:
- 규칙  (연관규칙)
- 조합  (두 엔티티사이의 정보조합)
- 설명  (규칙서술)
- 동사  (동사)

규칙보고, 동사보고, 정보보고


문제25)
주식별자 ( PK )
- 유일성
- 최소성
중복 X,  NOT NULL


※ KEY - 구분할수 있는값
후보키 , 주키(PK) , 대체키 , 슈퍼키(복합키) , 외래키


문제26)
인조식별자 - 시스템이 자동생성값


문제27)
PK - 유일성(#) + 최소성
※ KEY - 구분할수 있는값
후보키 , 주키(PK) , 대체키 , 슈퍼키(복합키) , 외래키


문제28)
식별자 - 유일성 + 최소성
자주사용 +  복잡하지 않게 / 안정적 + 간단한속성


문제29+30)
■ 비식별자
: 부모의 식별자를 자식이 받지 않는 경우
- 식별자 전달 X (연관성이 약할경우)
- 자식 독립적
- 복잡성방지


문제31)
■ 성능튜닝 = SQL + 모델링


문제32+33+34)
■ 모델링순서
- 정 (규화)
- 용 (량산정)
- 트 (트랜잭션 유형)   한번에처리- 상세보기(조회수↑+보기)
- 반 (반정규화)
- 조 (정,- PK/FK,  모델링조정)
- 검 (증 - 성능)


문제35)

<관서번호, 납부자번호> →직급명, 통신번호
<관서번호>→<관리점번호, 관서명, 상태, 관서등록일자>

1NF - 한번에 한칸씩
2NF - <관서번호, 납부자번호>


문제36)
- 일자별매각물건: 약 100만건
- 매각일자별매각내역: 약 2만건


<매각물건번호,매각일자>→
<매각일자>→매각시각, 매각장소   1:M

--------

문제37+38)
모델코드PK  A유형	B유형  C유형
1000	   1         NUL     NULL
2000	   NULL       2     NULL	


모델코드PK   유형
1000	   1   
2000	   2



--------
문제39)
<학번, 과목번호> → 성적
<학번> → 지도교수명
<학번> → 학과명


문제40+41)
>조인에서 느려지므로 자주쓰는 정보만 따로 모아놓기
>중간테이블만들기

문제42)
반정규화 
- 중복칼럼을  추가
- 파생칼럼을  추가 : 총액
- 이력테이블에  기능 

FK 속성추가 : 관계유지 목적


문제43)
반정규화 
- 주문할때마다 총액을 미리계산해서 넣기



문제44)
반정규화 
- 전화번호, 메일주소, 위치는 자주 변경이 될 수 있으며 
 데이터 조회를 할 때는 항상 최근에 변경된 값 을 조회하게 됨


문제45) 컬럼많을때
로우체이닝(Row Chaining)은 데이터베이스에서 하나의 행(row)이 여러 블록에 나뉘어 저장되는 현상을 말해요. 이 현상은 특히 칼럼이 많거나, 자주 업데이트되는 테이블에서 발생


문제46)
파티셔닝 = 물리적분할 성향향상


문제47)
UNION  ALL : 중복제거안하고 합치기
UNION        : 중복제거하고    합치기

1. 구조가 같으면 구로를 하나로 합치고
2. 구분코드로 분리

문제 48)
슈퍼타입 + 서브타입  데이터모델  - 성능은 상황에 따라서 다름.
  


문제 49 + 50)
<거래일자+사무소코드+출급기번>

SELECT  건수, 금액
FROM   테이블명
WHERE   거래일자 BETWEEN  '20251105'  AND '20251105'
AND 사무실코드='1'

WHERE 
확실한 조건먼저 읽기
= 데이터 먼저 읽기   1)사무실코드
BETWEEN               2) >=  <=

<지사코드 , 일자 , 명세번호>

문제 51)
FK(Foreign Key)  
: 관계유지
- 조인성능을 위해 INDEX를 생성하는게 좋음.
- 제약조건을 생략해도 INDEX는 필요함.

<학사기준>학사기준번호 PK
<수강신청>강의번호+학번 (PK)  학사기준번호 FK


문제 52)
분산데이터베이스
1) 마스터데이터 복제 
2) 실시간업무 
3) 백업사이트 구성

4) GSI - 단일인스턴스 (통합운영)





---
■ SQL BASIC
p103  6번 _
p113  12번 _
p126  22번  FK지우기
        29번  VAL=200
        34번  empno : 100,200,300
149  from    svc_join   테이블명
53    2번 group by 회원id
64    a.ename



문제 1~10) SQL 명령어

-R
■DDL(정의어) - CADR
  - C(REATE), A(LATER) , D(ROP) , R(NAME)
■DML(조작어) - CRUD
  - C(insert), R(select), U(update), D(delete)
■DCL(제어어-권한) - RG
  - R(EVOKE) 빼기 , G(RANT) 주기
■TCL(제어어-트랜잭션) -CR
  - C(OMMIT) , R(OLLBAK)

Q1) 4
1. insert - DML
2. rename - ddl
3. commit - tcl
4. revoke - dcl

Q2) 2
1. create- ddl
2. grant - dcl
3. alter - ddl
4. drop  - ddl

Q3) tcl


Q4) 1
1. 어떻게 접근 - 무엇사용 (x)
2. DML - 조작 -  CRUD (O)
3. DDL - 정의 -  CADR (O)
4. 호스트 프로그램 속에 삽입되어 사용 (O)

Q5) 1,2

Q6)  PRIMARY KEY 키추가 - C 이름 P
(1)
create table  PRODUCT(
   PROD_ID  VARCHAR2(10) NOT NULL  primary key,
   PROD_NM  VARCHAR2(100) NOT NULL,
   REG_DT   DATE NOT NULL,
   REGR_NO  NUMBER(10) NULL  ,
);


(2) CP : constraint  이름   primary key(id)
create table  PRODUCT(
   PROD_ID  VARCHAR2(10) NOT NULL , 
   PROD_NM  VARCHAR2(100) NOT NULL,
   REG_DT   DATE NOT NULL,
   REGR_NO  NUMBER(10) NULL  ,
   constraint  PRODUCT_pk primary key(PROD_ID)
);

(3) alter table   PRODUCT  add
    constraint  PRODUCT_pk primary key(PROD_ID)

Q7)  4 
[SQLServer]
ALTER TABLE 기관분류  ALTER COLUMN   VARCHAR(30) NOT NULL
ALTER TABLE 기관분류  ALTER COLUMN   DATE NOT NULL 

[Oracle]
ALTER TABLE 기관분류  MODIFY   분류명 VARCHAR(30) NOT NULL
ALTER TABLE 기관분류  MODIFY   DATE NOT NULL 


Q8) null   - 3
- 자리는 있으나 값을 채운적이 없음. (상태)
1) 모르는 값 (O)
2) 값의 부재 (O)
3) 숫자 0(x) , 공백문자(X)
4) is null,  is not null

Q9)
CREATE TABLE T
(C INTEGER PRIMARY KEY,
 D INTEGER):


CREATE TABLE S
(B INTEGER PRIMARY KEY,
 C INTEGER REFERENCES T(C) ON DELETE CASCADE);


CREATE TABLE R
(A INTEGER PRIMARY KEY,
 B INTEGER REFERENCES S(B) ON DELETE SET NULL);

> 부모삭제시  자식은 삭제, 손자는 null


Q10) 제약사항
unique - 유일한값 , NULL 값 허용
pk  - 주키 , 복합키   not null
    primary key(id), primary key(id,jumin)
fk  - 외래키 연결(참고유지)
not null - null 방지  null허용안해


-R
■DDL(정의어) - CADR
  - C(REATE), A(LATER) , D(ROP) , R(NAME)
■DML(조작어) - CRUD
  - C(insert), R(select), U(update), D(delete)
■DCL(제어어-권한) - RG
  - R(EVOKE) 빼기 , G(RANT) 주기
■TCL(제어어-트랜잭션) -CR
  - C(OMMIT) , R(OLLBAK)


✅ 11~20번: 테이블 생성, 제약조건, 데이터 조작

Q11) 테이블이름    _소문자10


Q12) CREATE  INDEX  ON   - (IO)

기본부서(코드 : '0000')로 배치
입사일자(JOIN DATE) 기준으로 많은 조회가 발생

CREATE TABLE EMP(
EMP_NO  VARCHAR2(10) NOT NULL PRIMARY KEY,
EMP_NM VARCHAR2(30) NOT NULL , 
DEPT_CODE  VARCHAR2(4) NOT NULL DEFAULT '0000',
JOIN_DATE DATE NOT NULL ,
REGIST_DATE  DATE NULL
);

CREATE INDEX IDEX_EMP  ON  EMP(JOIN_DATE);


Q13)  3

<학번> : PK , NOT NULL 무조건데이터값 입력

select count(*) from 학생     - 모든값카운트
select count(학번) from 학생   - 모든값카운트

※ COUNT(학번) - NULL 값 빼고 카운트


Q14)  2,3
외래키 = null + 여러개가능

1. 테이블 생성시 설정가능
2. null 가능함
3. 여러개 가능함
4. 참조무결성


Q15)   3
제약조건
1. check - 컬럼의 무결성 (O)  결점없이, 제약조건
2. pk - 한개만 , 중복x + not null
3. unique - 안겹치게 , null 허용
4. fk - pk 관계정의


Q16) COMM 칼럼을 삭제

alter table emp
drop column comm;


Q17)   2 (A: 3, C: 1)
1. 부서번호(부모)가 삭제되면 직원(자식)도 같이 삭제
2. 테이블구성 확인
<부서>
10 영업과
20 기획과

<직원>
1000  10
2000  20
3000  20  

3. 
A. SELECT COUNT(직원번호) FROM 직원  => 3
B. DELETE FROM 부서 WHERE 부서번호 = '20': =>1000  10
C. SELECT COUNT(직원번호) FROM 직원  => 1
COMMIT;

Q18)
C(REATE)A(LTER)D(ROP)R(ENAME) 

RENAME  STADIUM    TO   STADIUM_JSC;
RENAME    A        TO   B;


Q19) 4
[오라클문법]
CREATE TABLE EMP (
  EMPNO  NUMBER PRIMARY KEY,
  DEPTNO NUMBER,
  CONSTRAINT    FK_EMP_DEPT
  FOREIGN KEY  (DEPTNO)  REFERNECES DEPT(DEPTNO)
  -- DEPENDENT 설명?
  ON DELETE  CASECADE   -- 부모삭제시 자식도 같이 삭제
);


Q20)  4
-- 테이블 구조 순서대로 모든값을 넣을때 
insert into  테이블명  values (값1, 값2,,,,);

insert into  테이블명 (필드명1, 필드2,,,,)  values (값1, 값2,,,,);


✅ 21~30번: 관계 설정, FK 제약, 트랜잭션 처리
Q21)

Q22) 1,3
고객삭제시 주문은 null

2) 고객(부모)가 없는데 주문(자식) 먼저
4) 부모는 자식의 데이터가 남아 있으면 삭제 불가

Q23) 1

DELETE FROM STADIUM;  ← ROLLBACK 복구가능

2) DELETE * FROM 문법틀림
3) TRUNCATE  아예 삭제
4) DROP    테이블자체를 삭제 복구안됨!

Q24) DISTINCT 
SELECT DISTINCT 거주지, 근무지
FROM 고객지역;


Q25)  TRUNCATE
테이블의 데이터를 모두 삭제함 디스크 사용량도 초기화 (TRUNCATE)

TRUNCATE - 복구안됨! 데이터 삭제
DROP     - 복구안됨! 테이블 삭제

Q26)  
DELETE 와 TRUNCATE, DROP 
1) X DELETE - 로그남음, DROP TABLE 복구안됨! 테이블 삭제
2) o TRUNCATE - 복구안됨! 데이터 삭제 / DROP     - 복구안됨! 테이블 삭제
3) o  TRUNCATE - 복구안됨!때문에  - 동일 데이터량 삭제시 DELETE보다 빠르다.
4) X DROP은 Auto Commit이 되고 , DELETE와 TRUNCATE는 사용자 Commit으로 수행된다.
- DROP , TRUNCATE는 : Auto Commit
- DELETE : COMMIT

Q27)
데이터베이스 트랜잭션 (ACID)

A :  DO OR NOT
C :  데이터 일관성 유지있게    -> 영구저장 X
I :  영향받지말기 ( COMMIT, ROLLBACK )
D :  트랜잭션이후에 변경사항 영구유지


Q28)  고립성(isolation) 

① Dirty Read: 다른 트랜잭션에 의해 수정되었고 (이미 x) 커밋된 데이터를 읽는 것을 말한다. → 이미X
>  COMMIT 되지 않은 데이터 읽기
② Non-Repeatable Read: 한 트랜잭션 내에서 같은 쿼리를 두 번 수행했는데, 그 사이에 다른 트랜잭션이 값을 수정 또는 삭제하는 바람에 두 쿼리 결과가 다르게 나타나는 현상을 말한다.
> 결과다르게 읽기
③ Phantom Read: 한 트랜잭션 내에서 같은 쿼리를 두 번 수행했는데, 첫번째 쿼리에서 없던 유령 레코드가 두번째 쿼리에서 나타나는 현상을 말한다.
>  첫번째쿼리에는 없는 유령레코드가, 두번째 쿼리에서 나오기
④ isolation : 트랜잭션이 실행되는 도중에 다른 트랜잭션의 영향을 받아 잘못된 결과를 만들어서는 안된다. → (정의)
> 정의 내림


Q29) 

ORACLE    -    DDL 실행시 ,  AUTO COMMIT 발생 O
SQLSEVER  -    DDL 실행시 ,  AUTO COMMIT 발생 X

DDL- CADR


Q30) 

㉠ 은 데이터베이스의 논리적 연산단위로서 밀접히관련되어 분리될 수 없는 한 개 이상의 데이터베이스 조작을 가리킨다.
㉠ 의 종료를 위한 대표적 명령어로서는 데이터에 대한 변경사항을 데이터베이스에 영구적으로 반영하는 ㉡ 과
데이터에 대한 변경사항을 모두 폐기하고 변경전의 상태로 되돌리는 ㉢ 이 있다.

㉠ 트랜잭션 
㉡ 영구반영 - COMMIT
㉢ 변경전의 상태로 되돌리 - ROLLBACK


-R 
■DML(조작어) - CRUD
  - C(insert), R(select), U(update), D(delete) 
■TCL(제어어-트랜잭션) -CR
  - C(OMMIT) , R(OLLBAK)



트랜잭션, SELECT, 집계함수, NULL 처리
Q31)    3 

001	1000
002	2000  #
003	1000
004	2000  # 
005 2000  #
-- INSERT
DELETE
UPDATE
-- ROLLBACK 반영안됨

SELECT COUNT(품목ID) FROM 품목 WHERE 단가=2000


Q32)  LCD-TV

001	TV

--SP1

001	 LCD-TV
--SP2

001	 평면-TV
ROLLBACK TRANSACTION SP2; ##



Q33) WHERE

SQL을 사용하여 데이터베이스에서 데이터를 조회할 때 원하는 데이터 만을 검색하기 위해서 SELECT, FROM 절과 함께 ① 을(를) 이용하여 조회되는 데이터의 조건을 설정하여 데이터를 제한할 수 있다. 



Q34)  2

EMPNO	SAL
100	1500
200	3000    #
300	2000


SELECT COUNT(*)
FROM EMP_TBL
WHERE EMPNO > 100 AND SAL >= 3000 OR EMPNO = 200;


Q35)    4
NULL 상태값

COL1	COL2	COL3
30	  NULL	20        50
NULL	10	  40        NULL
50	NULL	  NULL      NULL

SELECT COL1 + COL3 FROM TAB_A; 


Q36) 1
COLUMN1의 값이 널(NULL)이 아닌 경우
IS NOT NULL
IS NULL  


Q37)   4

(가) SELECT * FROM 서비스 WHERE 서비스번호 = 1;
(나) INSERT INTO 서비스 VALUES ('999', ", '2015-11-11');
(다) SELECT * FROM 서비스 WHERE 서비스명 = ";
(라) SELECT * FROM 서비스 WHERE 서비스명 IS NULL;


① 서비스번호 컬럼에 모든 레코드 중에서 '001'과 같은 숫자형식으로 하나의 레코드만이라도 입력되어 (가)는 오류 없이 실행된다.
> x 숫자가 아니라 문자형 ``필요함
② ORACLE에서 (나)과같이 데이터를 입력하였을 때, 서비스명 컬럼에 공백문자 데이터가 입력된다.
> NULL
③ ORACLE에서 (나)과같이 데이터를 입력하고, (다)과 같이 조회하였을 때, 데이터는 조회된다.
> IS NULL , IS NOT NULL
④ SQL Server에서 (나)과같이 데이터를 입력하고 (o), (라)과 같이 조회하였을때, 데이터는 조회되지 않는다. (O)

ORACLE - 빈문자열 공백
SQL SERVER - 빈문자열 NULL로 조회




Q38)  4


2014년 11월부터 2015년 03월까지의 매출금액 합계를 출력

1. SUM
2. 년 2014 11 ,12
      2015 01,02,03

      

Q39)   4
20150101 날짜비교가  

TO_DATE('201501', 'YYYYMM') = SVC_END_DATE


      

Q40) 
아래와 같은 내장 함수에 대한 설명 중에서 옳은 것을 모두 묶은 것은?

가) 함수의 입력 행수에 따라 단일행 함수와 다중행 함수로 구분할 수 있다. (o)
나) 단일행 함수는 SELECT, WHERE, ORDER BY, UPDATE의 SET 절에 사용이 가능하다.   (o)
다) 1:M 관계의 두 테이블을 조인할 경우 M쪽에 다중행이 출력되므로 단일행 함수는 사용할 수 없다. (X)
라) 단일행 함수는 다중행 함수와 다르게 여러 개의 인수가 입력 되어도 단일 값만을 반환한다. (O)

단일행 SUM(*) , AVG(SAL)
다중행 - 여러줄



 41~50번: 고급 SQL 함수, 날짜 처리, CASE 문

Q41)   3     5줄

(LENGTH(C1) - 
 LENGTH(REPLACE(C1, CHR(10),'')) + 1)
                    줄바꿈   ''
 (본인갯수 - 본인줄바꿈한갯수 빼기) + 1
 > 해당줄수 카운트


Q42)  3
TO_DATE('2015.01.10 10', 'YYYY, MM, DD HH24') + 1/24/(60/10)

1. HH24   24시
2. 1/24/(60/10)
   1/24   1시간/(6) = 10분

   2015.01.10 10:10:00


Q43)
> CASE  LOC  WHEN  'NEW YORK' THEN 'EAST'
SELECT LOC,
    CASE WHEN LOC = 'NEW YORK' THEN 'EAST'
    ELSE 'ETC'
    END as AREA
FROM DEPT;


SELECT LOC,
    CASE  LOC  WHEN  'NEW YORK' THEN 'EAST'
    ELSE 'ETC'
    END as AREA
FROM DEPT;


Q44) 4
ELSE 1

Q45) 2
COL1	COL2
a	NULL
b	''
c	3
d	4
e	3


Q46)  NULIF(MGR,7698) 

NULIF(MGR,7698) - 같은면 NULL    
NVL(A,B)         -  A가 NULL이면 B

Q47)   4
EMP_Q 테이블에서 세개의 SQL 결과
SELECT SAL/COMM FROM EMP_Q WHERE ENAME = 'KING';
SELECT SAL/COMM FROM EMP_Q WHERE ENAME = 'FORD';
SELECT SAL/COMM FROM EMP_Q WHERE ENAME = 'SCOTT';

ENAME (문자타입)	SAL(숫자타입)	COMM(숫자타입)
KING	            0	          300
FORD	            5000	      0
SCOTT	            1000	      null

0/300     = 0
5000/0    = 나눌수 없는 값 error 
1000/null = null 


Q48)   3
SELECT SUM(COALESCE(C1, C2, C3))
FROM TAB1

C1	C2	C3
1	  2	  3      -> 1
    2	  3      -> 2
        3      -> 3 


COALESCE(C1, C2, C3)   -> null 이 아닌 첫번째 값   
1+2+3=6     


Q49)  NVL

아래의 각 함수에 대한 설명 중 (ㄱ), (ㄴ), (ㄷ)에 들어갈 함수를 차례대로 작성하시오.
 
(ㄱ)  (표현식1, 표현식2): 표현식1의 결과값이 NULL이면 표현식 2의 값을 출력한다.
(ㄴ)  (표현식1, 표현식2): 표현식1이 표현식2와 같으면 NULL을, 같지 않으면 표현식1을 리턴한다.
(ㄷ)  (표현식1, 표현식2): 임의의 개수 표현식에서 NULL이 아닌 최초의 표현식을 나타낸다.


NVL(표현식1, 표현식2)       →  표현식1의 결과값이 NULL이면 표현식 2의 값을 출력
NVLIF(표현식1, 표현식2)     →  표현식1, 표현식2의 결과값이 NULL이면  아니라면  표현식1
COALESCE(표현식1, 표현식2)  →  NULL이 아닌 최초의 표현식



Q50)   3

SELECT AVG(COL3) FROM TAB_A;   →   (20+0)/2 = 10
SELECT AVG(COL3) FROM TAB_A WHERE COL1 > 0;   →  	20/1 = 20
SELECT AVG(COL3) FROM TAB_A WHERE COL1 IS NOT NULL; →  20, null →  	20/1 = 20

※ avg(필드명)    null 빼고 값의 평균



51~64번: 실전 SELECT + GROUP BY/HAVING + JOIN
Q51)   3   

직급
사원 500명, 
대리 100명, 
과장 30명, 

차장 10명, 
부장 5명,     ---   645
NULL 25명

SQL1) SELECT COUNT(GRADE) FROM EMP;   →  645
SQL2) SELECT GRADE FROM EMP WHERE GRADE IN (차장', '부장', 'NULL');  →  15
SQL3) SELECT GRADE, COUNT(*) FROM EMP GROUP BY GRADE;   → 6

※ COUNT(필드명)    null 빼고 값의 평균
※ NULL 값 상태확인  →  IS NULL,  IS NOT NULL



Q52)  2
> 광고매체 ID별 최초로 게시한 광고명과 광고시작일자를 출력

[SQL]
SELECT C.광고매체명, B.광고명, A.광고시작일자
FROM 광고게시 A, 광고 B, 광고매체 C,
     (         [가]            )   D
WHERE A.광고시작일자 = D.광고시작일자
AND   A.광고매체ID  = D.광고매체ID
AND   A.광고ID = B.광고ID
AND   A.광고매체ID = C.광고매체ID
ORDER BY C.광고매체명:

1.   광고매체 ID별 최초로 게시한 광고명과 광고시작일자를 출력
2.   연결된 D
  WHERE A.광고시작일자 = D.광고시작일자
  AND   A.광고매체ID  = D.광고매체ID   → 구해야할 
3.   광고매체 ID별(GROUP BY)
  SELECT   광고매체ID ,  MIN(광고시작일자)
  FROM     광고게시
  GROUP BY  광고매체ID


Q53) 4  오류가 발생하는 SQL 문장

① SELECT 회원ID, SUM(주문금액) AS 합계
  FROM 주문
  GROUP BY 회원ID   
  HAVING COUNT(*) > 1;

② SELECT SUM(주문금액) AS 합계
  FROM 주문
  GROUP BY 회원ID
  HAVING AVG(주문금액) > 100;

③ SELECT 메뉴ID, 사용유형코드, COUNT(*) AS CNT
  FROM 시스템사용이력
  WHERE 사용일시 BETWEEN SYSDATE - 1 AND SYSDATE
  GROUP BY 메뉴ID, 사용유형코드
  HAVING 메뉴ID = 3 AND 사용유형코드 = 100;

④ SELECT 메뉴ID, 사용유형코드, AVG(COUNT(*)) AS AVGCNT
  FROM 시스템사용이력
  GROUP BY 메뉴ID, 사용유형코드:

※ 집계함수안에 집계함수 못집어넣음



Q54)  2

[SQL]
SELECT MAX(가) AS 가, 나, SUM(다) AS 다  →  4)
FROM A        →  1)
GROUP BY 나   →  2) 
HAVING COUNT(*) > 1     →  3)
ORDER BY 다 DESC;    → 5)

가	 나	   다
001	A001	100
002	A001	200       002   A001   300

003	A002	100
004	A002	200
005	A002	200       005  A002    500

006	A003	100
007	A003	200
008	A003	100
009	A003	200       009   A003    600
  


Q55)   2

SELECT ID     → 4) 
FROM TBL      → 1)
GROUP BY ID   → 2)
HAVING COUNT(*) = 2   → 3)
ORDER BY (CASE WHEN ID = 999 THEN O ELSE ID END)

ID
999       0    진행되는순서 0순위 
100       100 

※ order by 숫자가 작을수록 우선순위
0순위



[문제 056]  다음 SQL 중 오류가 발생하는 것은?  3
① SELECT 지역, SUM(매출금액) AS 매출금액  FROM 지역별매출   GROUP BY 지역
ORDER BY 매출금액 DESC;   →  집계함수로 정렬가능

② SELECT 지역, 매출금액 FROM 지역별매출
ORDER BY 년 ASC;   →  컬럼이 존재하면 정렬가능

③ SELECT 지역, SUM(매출금액) AS 매출금액   FROM 지역별매출
GROUP BY 지역     
ORDER BY 년 DESC;    →  GROUP BY 지역으로 그룹을 묶음, GROUP BY 없는 컬럼정렬 X

④ SELECT 지역, SUM(매출금액) AS 매출금액
FROM 지역별매출
GROUP BY 지역
HAVING SUM(매출금액) > 1000
ORDER BY COUNT(*) ASC;   →  GROUP BY  그룹을 묶음,  order by는 집계함수 안에서


[문제 057]  
다음 중 ORDER BY 절에 대한 설명으로 가장 부적절한 것은? 3

① SQL 문장으로 조회된 데이터들을 다양한 목적에 맞게 특정 컬럼을 기준으로 정렬하는데 사용한다.  → 정의
② DBMS마다 NULL 값에 대한 정렬 순서가 다를 수 있으므로 주의하여야 한다.   → 정렬순서가 다르게 나올수 있음
③ ORDER BY 절에서 컬럼명 대신 Alias 명이나 컬럼 순서를 나타내는 정수도 사용이 가능하나, 이들을 혼용하여 사용할 수 없다.   → 컬럼명, 별칭,  혼용 사용가능
④ GROUP BY 절을 사용하는 경우 ORDER BY 절에 집계 함수를 사용할 수도 있다 → 가능


[문제 058]    2

[SQL]
SELECT ID, AMT   → 2)
FROM TBL         → 1)
ORDER BY (CASE WHEN ID = 'A' THEN 1 ELSE 2 END),
AMT DESC

> CASE WHEN ID = 'A' THEN 1 ELSE 2 END
정렬은 0순위

ID	AMT
A	200       1
A	50        1
B	300       2
C	100       2



[문제 059]   4
 다음 중 SELECT 문장의 실행 순서를 올바르게 나열한 것은?
SELECT    5)
FROM      1)
WHERE     2)
GROUP BY  3)
HAVING    4)
ORDER BY  6)

[문제 060]   4
> 3위 동일   → TOP(N)  WITH TIES
승리건수가 높은 순으로 3위까지 출력하되 3위의 승리건수가 동일한 팀이 있다면 함께 출력하기 위한 SQL

SELECT    TOP(3)  WITH TIES  팀명 , 승리건수
FROM      팀별성적
ORDER BY  승리건수 DESC


[문제 061]  3

  5개의 테이블로부터 필요한 칼럼을 조회
  A ↔ B ↔ C ↔ D  ↔ E


[문제 062]  
1. 기본키이며 
2. 출연료가 8888 이상인 
3. 영화명, 배우명, 출연료
배우(배우번호(PK), 배우명, 성별)
영화(영화번호(PK), 영화명, 제작년도)
출연(  <배우번호, 영화번호> , 출연료)

SELECT      영화명, 배우명, 출연료
FROM        배우, 영화, 출연
WHERE       출연료 >= 8888
AND         출연.배우번호 = 배우.배우번호
AND         출연.영화번호 = 영화.영화번호



[문제 063]  
다음 중 아래에서 Join에 대한 설명으로 가장 적절한 것은?   4
가) 일반적으로 Join은 PK와 FK 값의 연관성에 의해 성립된다. (O)
나) DBMS 옵티마이져는 From 절에 나열된 테이블들을 임의로 3개 정도씩 묶어서 Join을 처리한다. ? 
다) EQUI Join은 Join에 관여하는 테이블 간의 컬럼 값들이 정확하게 일치하는 경우에 사용되는 방법이다.   (O)
라) EQUI Join은 '=' 연산자에 의해서만 수행되며, 그 이외의 비교 연산자를 사용하는 경우에는 모두 Non EQUI Join이다.  (O)     >   <      Non EQUI Join
마) 대부분 Non EQUI Join을 수행할 수 있지만, 때로는 설계상의 이유로 수행이 불가능한 경우도 있다. 
(O)



[문제 064]  3

[SQL]
SELECT COUNT(*) CNT
FROM EMP_TBL A, RULE_TBL B    1)  전체다 가져옴.
WHERE A.ENAME LIKE B.RULE     2) 1번조건, 2번조건


[EMP_TBL]
EMPNO	ENAME
1000	SMITH       S로 시작    , T포함
1050	ALLEN
1100	SCOTT       S로 시작    , T포함

[RULE_TBL]
RULE_NO	RULE
1	  S%          2건
2	  %T%         2건    > 4건


■ SQL USING : 관계 연산자, JOIN 실무, 집합 연산자

[문제 065]  
다음 중 순수 관계 연산자에 해당하지 않는 것은?  2
① SELECT  (O)
② UPDATE  (X) 수정 
③ JOIN    (O) 연결
④ DIVIDE  (O) 집합

> 순수 관계 연산자 (SELECT)



[문제 066]    3,4
고객에게 추천할 컨텐츠를 생성하는 배치작업에서, 

> 주어진조건
1. 추천 대상일자에 해당하고 
   비선호 컨텐츠에 포함되지 않은 컨텐츠만 추천해야 한다. 
2. 
※ 추천컨텐츠 테이블의 복합키: 고객ID + 컨텐츠ID
※ 비선호컨텐츠 테이블의 복합키: 고객ID + 컨텐츠ID

---------------------------------------------
※   NOT EXISTS (제외하고)
결과가 없으면 바깥쿼리 실행

※   
RIGHT OUTER       -  오른쪽테이블 보장 / 왼쪽NULL
LEFT OUTER JOIN   -  왼쪽테이블보장    / 오른쪽은 NULL
----------------------------------------------

1. 추천 대상일자에 해당하고   - 1,2,3,4
2. 비선호 컨텐츠에 포함되지 않은 컨텐츠만 추천해야 한다. 
 


[문제 067]
적절한 것을 2개 고르시오.   1,2
생산제품 테이블의 복합키: 라인번호 + 제품코드

① 제품, 생산제품, 생산라인 엔터티를 Inner Join 하기 위해서 생산제품 엔터티는 WHERE절에 최소 2번이 나타나야 한다.
② 제품과 생산라인 엔터티를 Join시 적절한 Join조건이 없으므로 카티시안곱(Cartesian Product)이 발생한다.
③ 제품과 생산라인 엔터티에는 생산제품과 대응되지 않는 레코드는 없다.
④ 특정 생산라인번호에서 생산되는 제품의 제품명을 알기위해서는 제품,생산제품, 생산라인까지 3개 엔터티의 Inner Join인 필요하다. 



[문제 068]  2
1. 구매 이력이 있는 고객 중 
2. 구매 횟수가 3회 이상인 
3. 고객의 이름과 등급을 출력  (o)

고객(고객번호(PK), 이름, 등급)
구매정보(구매번호(PK), 구매금액, 고객번호(FK))

SELECT A.이름, A.등급
FROM 고객 A
JOIN 구매정보 B  ON( A.고객번호   = B.고객번호)   (가)
GROUP BY A.이름, A.등급
HAVING COUNT(B.구매번호) >=3  ( 나)


[문제 069]   3

1. 시간대별사용량 테이블을 기반으로
2. 고객별 사용금액


SELECT A.고객ID, A.고객명, SUM(B.사용량 * C.단가) AS 사용금액
FROM 고객 A 
INNER JOIN 시간대별사용량 B  ON ( A.고객ID = B.고객ID  )
INNER JOIN 시간대구간    C  ON (   B.사용시간대  BETWEEN C.시작시간대 AND  C.종료시간대  )
GROUP BY A.고객ID, A.고객명
ORDER BY A.고객ID, A.고객명;



① 시작시간대 설정잘못됨.
② JOIN ON연결위치
③ 답 
④ JOIN 구문이상



[문제 070] 1
USING (T.STADIUM_ID = S.STADIUM_ID)  X
USING ( STADIUM_ID)  O



[문제 071]
[사례1]
SELECT ENAME, DNAME
FROM EMP, DEPT
ORDER BY ENAME;   >> join의 조건이 없음, 카다시안곱

[사례2]
SELECT ENAME, DNAME
FROM EMP  ㉠ DEPT 
ORDER BY ENAME;    >> cross join


[문제 072]

* LEFT  JOIN  왼쪽보장!
* RIGHT JOIN  오른쪽보장!


SELECT A.고객번호, A.고객명, B.단말기ID, B.단말기명, C.OSID, C.OS명

FROM 고객 A 
LEFT OUTER JOIN 단말기 B  
ON (A.고객번호 IN (11000,12000)  AND  A.단말기ID=B.단말기ID)  
LEFT OUTER JOIN OS C  ON (B.OSID = C.OSID)
ORDER BY A.고객번호;

>
고객번호 (PK)	고객명	단말기ID (FK)
11000	홍길동	1000
12000	강감찬	NULL
13000	이순신	NULL
14000	안중근	3000
15000	고길동	4000
16000	이대로	4000



[문제 073]  1,2,3
(1) SELECT A.ID, B.ID
FROM TBL1 A FULL OUTER JOIN TBL2 B
ON A.ID = B.ID
> TBL1 테이블보장
> TBL2 테이블보장


(2) SELECT A.ID, B.ID
FROM TBL1 A LEFT OUTER JOIN TBL2 B
ON A.ID = B.ID
UNION
SELECT A.ID, B.ID
FROM TBL1 A RIGHT OUTER JOIN TBL2 B
ON A.ID = B.ID

> TBL1 테이블보장 
UNION
> TBL2 테이블보장


(3) SELECT A.ID, B.ID
FROM TBL1 A, TBL2 B
WHERE A.ID = B.ID
> 교집합 (겹치는 부분만)
UNION ALL  
> 겹치는거 있어도 합쳐줘
SELECT A.ID, NULL
FROM TBL1 A
WHERE NOT EXISTS (SELECT 1 FROM TBL2 B WHERE A.ID = B.ID)
>  B테이블에서 겹치는 애들 빼고
UNION ALL
SELECT NULL, B.ID
FROM TBL2 B
WHERE NOT EXISTS (SELECT 1 FROM TBL1 A WHERE B.ID = A.ID)
>  A테이블에서 겹치는 애들 빼고





[문제 074]   1

EMP 테이블과 DEPT 테이블을 LEFT, FULL, RIGHT

[ EMP 테이블]
<A>	B	C
1	b	w
3	d	w
5	y	y

[DEPT 테이블]
<c>	D	E
w	1	10
z	4	11
v	2	22

1.   emp left join   dept
<A>	B	C
1	b	w      w	1	10
3	d	w      w	1	10
5	y	y      null

     3줄

2.    emp full join   dept
<A>	B	C
1	b	w w	1	10  (R)
3	d	w w	1	10  (R)
5	y	y null     
null   z	4	11
null   v	2	22
    5줄


[DEPT 테이블]
<c>	D	E
w	1	10  1	b	w
w	1	10  3	d	w 
z	4	11  null
v	2	22   null
   4건
   
[문제 075]   LEFT JOIN
신규 부서의 경우 일시적으로 사원이 없는 경우도 있다고 가정하고 
DEPT와 EMP를 조인하되 
사원이 없는 부서 정보도 같이 출력하도록 할 때, 
아래 SQL 문장의 (가) 안에 들어갈 내용을 기술하시오.

> 사원이 없는(null) 부서 정보도(무조건) 같이 출

SELECT E, ENAME, D. DEPTNO, D. DNAME
FROM  DEPT D  left join  EMP E
ON    D.DEPTNO = E.DEPTNO;   


   
[문제 076] 2

SELECT *
FROM TABI A LEFT OUTER JOIN TAB2 B
ON (A.C1 = B.C1 AND B.C2 BETWEEN 1 AND 3)

[ 테이블 1: TAB1]
C1	C2
A	1   NULL
B	2   B	2
C	3   C	3
D	4   NULL  
E	5   NULL
---------------------

[ 테이블 2: TAB2]
C1 C2
B	2
C	3
D	4

[문제 077]  1
[SQL]
SELECT A.게시판ID, A.게시판명, COUNT(B.게시글ID) AS CNT

FROM 게시판 A left join 게시글 B
WHERE A.게시판ID = B.게시판ID   AND   B.삭제여부 = 'N'
AND   A.사용여부 = 'Y'

GROUP BY A.게시판ID, A.게시판명
ORDER BY A.게시판ID;

※ (+) null


[문제 078] 5

SELECT count(st name)
FROM student s
WHERE not exists
(   SELECT *
    FROM department d
    WHERE s.d_num = d.dept_num  and dept_name = '전자계산학과');

※  WHERE not exists  ( 조건제외 )


[문제 079]

[SQL]    TAB1   -  TAB2
SELECT A, B
FROM TAB1    -- A,B 
EXCEPT       - 차집합
SELECT A, B
FROM TAB2;



16~30번 ( 080~094 ): INTERSECT, EXCEPT, 계층형 질의
NTERSECT, MINUS, EXCEPT




[문제 080]


[수행 SQL]
SELECT A.서비스ID, B.서비스명, B.서비스URL
FROM (SELECT 서비스ID  FROM 서비스
      INTERSECT
      SELECT 서비스ID  FROM 서비스이용) A, 서비스 B
WHERE A.서비스ID = B.서비스ID;

------------
※ INTERSECT   교집합  
※ NOT EXISTS(제외)     MINUS(이요안된거) - 차집합
----------

> 서비스와 서비스이용의 교집합 - 서비스를 이용한 데이터


① SELECT B.서비스ID, A.서비스명, A.서비스URL
FROM 서비스 A , 서비스이용 B
WHERE A.서비스ID = B.서비스ID;    
> 단순조인 다른값 포함이 가능함. X

② SELECT X.서비스ID, X.서비스명, X.서비스URL
FROM 서비스 X
WHERE NOT EXISTS (  ----> 2) 제외
    SELECT 1 
    FROM (SELECT 서비스ID  FROM 서비스    
          MINUS
          SELECT 서비스ID  FROM 서비스이용) Y
    WHERE X. 서비스ID = Y. 서비스ID);
    ...........> 1)이용안된서비스

 서비스와 서비스이용의 교집합 - 서비스를 이용한 데이터  (?)

③ SELECT B.서비스ID, A.서비스명, A.서비스URL
FROM 서비스 A LEFT OUTER JOIN 서비스이용 B
ON (A.서비스ID = B.서비스ID)
WHERE B.서비스ID IS NULL        
GROUP BY B.서비스ID, A.서비스명, A.서비스URL;
>  (X  제외조건  ) 

④ SELECT A.서비스ID, A.서비스명, A.서비스URL
FROM 서비스 A
WHERE 서비스ID IN (SELECT 서비스ID FROM 서비스이용
                MINUS
                SELECT 서비스ID  FROM 서비스);
 >  조건반대               



[문제 081]
① UNION   합집합 - 겹치면 빼고,   UNIONALL 합집합 - 겸침유지
② INTERSECT 교집합
③ MINUS 차집합
④ EXCEPT 차집합

 ------------
※ INTERSECT   교집합  
※ NOT EXISTS(제외)     MINUS(이요안된거) - 차집합
----------




[문제 082]   2
다음 중 아래의 EMP 테이블의 데이터를 참조하여 실행한 SQL의 결과로 가장 적절한 것은?

SELECT ENAME AAA, JOB AAB
FROM EMP
WHERE EMPNO = 7369                            	ENAME (AAA)	JOB(AAB)	 
                                              	  SMITH	       CLERK	 

UNION ALL

SELECT ENAME BBA, JOB BBB                     ENAME (BBA)	JOB(BBB)
FROM EMP                                       JONES	       MANAGER
WHERE EMPNO = 7566
ORDER BY 1, 2;     
        ENAME, JOB

> 
ENAME (AAA)	JOB(AAB)
  JONES	       MANAGER
  SMITH	       CLERK	 

[ 테이블 1: EMP]

EMPNO	ENAME	JOB	MGR	HIREDATE	SAL	COMM	DEPTNO
7369	SMITH	CLERK	7902	1980-12-17	800		20
7499	ALLEN	SALESMAN	7698	1981-02-20	1600	300	30
7521	WARD	SALESMAN	7698	1981-02-22	1250	500	30
7566	JONES	MANAGER	7839	1981-04-02	2975		20
7654	MARTIN	SALESMAN	7698	1981-09-28	1250	1400	30
7698	BLAKE	MANAGER	7839	1981-05-01	2850		30
7782	CLARK	MANAGER	7839	1981-06-09	2450		10
7788	SCOTT	ANALYST	7566	1987-07-13	3000		20
7839	KING	PRESIDENT		1981-11-17	5000		10
7844	TURNER	SALESMAN	7698	1981-09-08	1500	0	30
7876	ADAMS	CLERK	7788	1987-07-13	1100		20
7900	JAMES	CLERK	7698	1981-12-03	950		30
7902	FORD	ANALYST	7566	1981-12-03	3000		20
7934	MILLER	CLERK	7782	1982-01-23	1300		10




[문제 083]

[SQL]
STEP2) 
SELECT COL1, COL2, COUNT(*) AS CNT
FROM (SELECT COL1, COL2 FROM TBL1
      UNION  
      SELECT COL1, COL2 FROM TBL2
      UNION All
      SELECT COL1, COL2 FROM TBL1)
GROUP BY COL1, COL2; 

[ 테이블 1: T1]
A	B	C
A3	B2	C3  #
A1	B1	C1  #
A2	B1	C2
 



A3	B2	C3
A1	B1	C1
A2	B1	C2


[테이블 2: T2]
A	B	C
A1	B1	C1
A3	B2	C3

STEP2) 
SELECT COL1, COL2, COUNT(*) AS CNT
FROM (SELECT COL1, COL2 FROM TBL1
      UNION ALL
      SELECT COL1, COL2 FROM TBL2
      UNION ALL
      SELECT COL1, COL2 FROM TBL1)
GROUP BY COL1, COL2;

AA	A1 #11
AB	A2 #21
AA	A1 #12
AB	A2 #22
AC	A3 
AD	A4
AA	A1 #13
AB	A2 #23




[문제 084] 1

가. SELECT A, B, C FROM T1
UNION ALL
SELECT A, B, C FROM T2

나. SELECT A, B, C FROM T1
UNION
SELECT A, B, C FROM T2

가)
A	  B	  C
A3	B2	C3
A1	B1	C1
A2	B1	C2
A1	B1	C1
A3	B2	C3 

A	B	C
A3	B2	C3  A3	B2	C3
A1	B1	C1  A1	B1	C1
A2	B1	C2



[문제 085] 3   Intersection

집합 A = {가, 나, 다, 라},
집합 B = {다, 라, 마, 바},
집합 C = {다, 라}

① Union  합집합
② Difference 차잡합
③ Intersection  교집합
④ Product 곱집합



[문제 086]  3
회원기본정보와 회원상세정보는 1:1, 양쪽 필수 관계


① 회원ID 컬럼을 대상으로 (회원기본정보 EXCEPT 회원상세정보) 연산을
수행하면 회원상세정보가 등록되지 않은 회원ID가 추출된다. ( 차집합 - 없는값)
② 회원ID 컬럼을 대상으로 (회원기본정보 UNION ALL 회원상세정보)
  - 건수 증가가능 ( 중복데이터 포함 )
연산을 수행한 결과의 건수는 회원기본정보의 전체건수와 동일하다.
③ 회원ID 컬럼을 대상으로 (회원기본정보 INTERSECT 회원상세정보)
연산을 수행한 결과의 건수와 두 테이블을 회원ID로 JOIN 연산을 수행한
결과의 건수는 동일하다.
④ 회원ID 컬럼을 대상으로 (회원기본정보 INTERSECT 회원상세정보)
연산을 수행한 결과와 (회원기본정보 UNION 회원상세정보) 연산을
수행한 결과는 다르다.


1     1 first
2     3 third
3
4



[문제 087]   c


SELECT C3
FROM TAB1     1)
START WITH C2 IS NULL   2)   루트  
                 부모  자식
CONNECT BY PRIOR C1 = C2  3)  1=c2
ORDER SIBLINGS BY C3 DESC


C1	C2	C3
1		    A     2)루트   c1=1    c3 a
2	   1	B     3)  1 - (2,B)  (3	 , C)
3	   1	C         2 - (4,D)
4	   2	D


A(1)
  ㄴ C(3)
  ㄴ B(2)
      ㄴ D(4)



[문제 088]   
다음 중 Oracle 계층형 질의에 대한 설명으로 가장 부적절한 것은?   4

① START WITH절은 계층 구조의 시작점을 지정하는 구문이다.  (O)
② ORDER SIBLINGS BY절은 형제 노드 사이에서 정렬을 지정하는 구문이다.
③ 순방향전개란 부모 노드로부터 자식 노드 방향으로 전개하는 것을 말한다.
④ 루트 노드의 LEVEL 값은 0이다.  X (1)



[문제 089]   1

사원번호 (PK)	사원명	입사일자	매니저사원번호 (FK)
--------------------------------------
001	홍길동	2012-01-01	NULL  ##  LV1
-------------------------------------- 
003	이순신	2013-01-01	001
004	이민정	2013-01-01	001
--------------------------------------
005	이병헌	2013-01-01	NULL  ##  LV1
--------------------------------------


[SQL]
SELECT 사원번호, 사원명, 입사일자, 매니저사원번호
FROM 사원
START WITH 매니저사원번호 IS NULL
CONNECT BY PRIOR 사원번호 = 매니저사원번호
AND 입사일자 BETWEEN '2013-01-01' AND '2013-12-31'
ORDER SIBLINGS BY 사원번호;

PRIOR 사원번호 = 매니저사원번호  부모거를 가지고 자식거 찾기(순반향)

[문제 090]  
다음 중 계층형 질의문에 대한 설명으로 가장 부적절한 것은?

① SQL Server에서의 계층형 질의문은 CTE(Common Table Expression)를 재귀 호출함으로써 계층 구조를 전개한다.  (o)
② SQL Server에서의 계층형 질의문은 앵커 멤버를 실행하여 기본 결과 집합을 만들고 이후 재귀 멤버를 지속적으로 실행한다. (O)
③ 오라클의 계층형 질의문에서 WHERE 절은 모든 전개를 진행한 이후 필터 조건으로서 조건을 만족하는 데이터만을 추출하는데 활용된다.  (O)
④ 오라클의 계층형 질의문에서 PRIOR 키워드는 CONNECT BY 절에(만) 사용할 수 있으며 'PRIOR 자식 = 부모' 형태로 사용하면 순방향 전개로 수행 된다.

CONNECT BY PRIOR 부모 = 자식  → 순방향
CONNECT BY PRIOR 자식 = 부모  → 역방향

[문제 091] 
아래 [부서]와 [매출] 테이블에 대해서 SQL 문장을 실행하여 아래 [결과]와 같이 데이터가 추출 되었다. 다음 중 동일한 결과를 추출하는 SQL 문장은?

부서코드	부서명	상위부서코드	매출액	LVL
100	아시아지부	NULL	NULL	2
120	일본지사	100	NULL	1   #1
121	도쿄지점	120	1500	2
122	오사카지점	120	1000	2


1) LV1 =  120
2) LV2 = 121 , 122 , 100


① SELECT A.부서코드, A.부서명, A.상위부서코드, B.매출액, LVL
FROM (SELECT 부서코드, 부서명, 상위부서코드, LEVEL AS LVL 
        FROM 부서
        START WITH 부서코드 = '120'
        CONNECT BY PRIOR 상위부서코드 = 부서코드  (역방향)
        UNION
        SELECT 부서코드, 부서명, 상위부서코드, LEVEL AS LVL
        FROM 부서
        START WITH 부서코드 = '120'  (정방향)
        CONNECT BY 상위부서코드 = PRIOR 부서코드) A LEFT  OUTER JOIN 매출 B
ON (A.부서코드 = B.부서코드)
ORDER BY A.부서코드;



부서코드	부서명	상위부서코드	매출액	LVL
100	  아시아지부	NULL	NULL	2
120	  일본지사	100	NULL	1
121	  도쿄지점	120	1500	2
122	  오사카지점	120	1000	2


[문제 092]
다음 중 SELF JOIN을 수행해야 할 경우로 가장 적절한 것은?  1

① 한 테이블 내에서 두 칼럼이 연관 관계가 있다.  (o)
② 두 테이블에 연관된 칼럼은 없으나 JOIN을 해야 한다.  (x)
③ 두 테이블에 공통 칼럼이 존재하고 두 테이블이 연관 관계가 있다. (x)
④ 한 테이블 내에서 연관된 칼럼은 없으나 JOIN을 해야 한다. (x)


FROM EMP E, EMP E2   ON  e.mgr = e.empno


[문제 093]  3

일자별 누적 매출액   
1) 각날짜별 매출액
SELECT A.일자, SUM(A.매출액) AS 누적매출액
FROM 일자별매출 A
GROUP BY A.일자
ORDER BY A.일자;

2) 
② SELECT B.일자, SUM(B.매출액) AS 누적매출액
FROM 일자별매출 A JOIN 일자별매출 B ON (A.일자 >= B.일자)
GROUP BY B, 일자
ORDER BY B.일자;


③ SELECT A.일자, SUM(B.매출액) AS 누적매출액
FROM 일자별매출 A JOIN 일자별매출 B ON (A.일자 >= B.일자)
GROUP BY A.일자
ORDER BY A.일자:


25.1.1  1000      1000
25.1.2  1000      2000
25.1.3  1000      3000



[문제 094]  3
다음 중 아래의 SQL 수행 결과로 가장 적절한 것은?
SELECT COUNT(DISTINCT A||B)
FROM EMP   1)
WHERE D = (SELECT D FROM DEPT WHERE E = 'i'):


[테이블 1: EMP 테이블]
A	B	C	D
1	a	1	x
2	a	1	x
3	b	2	y



✅ 31~45번 (095~109): 집합 연산자, JOIN 조건, 서브쿼리 활용
UNION ALL, 집합 연산자 조합, 서브쿼리와 EXISTS 활용을 집중적으로 다룹니다.
JOIN 조건에 따른 결과 건수와 정렬 방식까지 실무 중심으로 분석합니다.



[문제 095]  
아래는 서브쿼리에 대한 설명이다. 다음 중 올바른 것끼리 묶인 것은?
> 가 라 마 

가) 서브쿼리는 단일 행 (Single Row) 또는 복수행(Multi Row) 비교 연산자와 함께 사용할 수 있다. (0)
나) 서브쿼리는 SELECT 정, FROM 절, HAVING 절, 
    ORDER BY 절 등에서 사용이 가능하다.   ?

다) 서브쿼리의 결과가 복수행(Multi Row) 결과를 반환하는 경우에는 '=','<=', '=>' 등의 연산자와 함께 사용이 가능하다.  X   in, any, all

라) 연관(Correlated) 서브쿼리는 서브쿼리가 메인쿼리 컬럼을 포함하고 있는 형태의 서브쿼리이다. (O)
마) 다중 컬럼 서브쿼리는 서브쿼리의 결과로 여러 개의 컬럼이 반환되어 메인쿼리의 조건과 동시에 비교되는 것을 의미하며 Oracle 및 SQL Server 등의 DBMS에서 사용 할 수 있다.   (o)


select enamae
from emp  e
where  sal > (    select avg(sal)  from emp  where e.id = id )


 
[문제 096]  
아래 테이블은 어느 회사의 사원들과 이들이 부양하는 가족에 대한 것으로 밑줄 친 칼럼은 기본키(Primary Key)를 표시한 것이다. 다음 중 '현재 부양하는 가족들이 없는 사원들의 이름을 구하라'는 질의에 대해 아래 SQL 문장의 (가) , (나) 들어 갈 내용으로 가장 적절한 것은?
[테이블]
사원 ( <사번>, 이름, 나이)
가족 (<이름>, 나이, 부양사번)
※ 가족 테이블의 부양사번은 사원 테이블의 사번을 참조하는 외래키(Foreign Key)이다.

[SQL 문장]
SELECT 이름
FROM 사원   -1)
WHERE  (가) (SELECT * FROM 가족 WHERE  (나)  )

>1
SELECT 이름
FROM 사원   
WHERE   사번   NOT IN (SELECT 부양사번 FROM 가족)

>2
SELECT 이름
FROM 사원 
WHERE NOT EXISTS  (SELECT * FROM 가족   사번= 부양사번 )
          없는        가족이

[문제 097] 3
SELECT A.회원번호, A.회원명
FROM 회원 A, 동의항목 B
WHERE A.회원번호 = B.회원번호

GROUP BY A.회원번호, A.회원명
HAVING COUNT(CASE WHEN B.동의여부 = 'N' THEN 0 ELSE NULL END) >= 1
ORDER BY A.회원번호:           

★ COUNT(*)  NULL 빼고 카운트
> 동의여부가 N인 회원의 숫자

1)   WHERE A.회원번호 = B.회원번호 AND B.동의여부 = 'N')
2)   WHERE A.회원번호 IN (SELECT B.회원번호 FROM 동의항목 B WHERE B.동의여부 = 'N')

3)  WHERE 0 < (SELECT COUNT(*) FROM 동의항목 B WHERE B.동의여부 = 'N')
    A.회원번호 = B.회원번호  회원별로 필터링안됨. X
    회원A와 아무런관련없이 항상 참이 될수 있음.

4)  WHERE A.회원번호 = B.회원번호 AND B.동의여부 = 'N'



[문제 098] 3
[SQL]
SELECT A.회원ID, A.회원명, A.이메일
FROM 회원 A
(가)
WHERE EXISTS 
              (SELECT 'X'
                FROM 이벤트 B.메일발송 C
                WHERE B.시작일자 >= '2014.10.01'
                AND B.이벤트ID = C.이벤트ID
               ///이메일이 발송된 기록이 있는지 
(나)
                AND A.회원ID = C.회원ID
               ///메일이 발송된 회원
(다)
                HAVING COUNT(*) < (SELECT COUNT(*)
                                FROM 이벤트
                                WHERE 시작일자 >='2014.10.01'));
               //////// 메일건수<  이벤트개수     

    > 이메일건수가 해당이벤트수보다 작은거     

① 이벤트 시작일자가 '2014.10.01'과 같거나 큰 이벤트를 대상으로 이메일이 발송된 기록이 있는 모든 회원을 추출하는 SQL이다. 
② (나)을 제거하고  (가)의 EXISTS 연산자를 IN연산자로 변경해도 결과는 동일하다. (달라질수 있음)
③ (다)은 이벤트 시작일자가 '2014.10.01'과 같거나 큰 이벤트건수와 그 이벤트들을 기준으로 회원별 이메일 발송건수를 비교하는 것이다. (o)
④ GROUP BY 및 집계함수를 사용하지 않고 HAVING절을 사용하였으므로 SQL이 실행되지 못하고 오류가 발생한다.  ( 같이 사용가능)

[문제 099]  
다음 중 서브쿼리에 대한 설명으로 가장 적절한 것은?  2

① 단일 행 서브쿼리는 서브쿼리의 실행 결과가 항상 한 건 이하인 서브쿼리로서 IN, ALL 등의 비교 연산자를 사용하여야 한다.   →    = 단일행   /  → IN, ALL 다중행
② 다중 행 서브쿼리 비교 연산자는 단일 행 서브쿼리의 비교 연산자로도 사용할 수 있다.
     = IN   = , < 사용가능

③ 연관 서브쿼리는 주로 메인쿼리에 값을 제공하기 위한 목적으로 사용한다.
select enamae
from emp  e
where  sal > (    select avg(sal)  from emp  where e.id = id )

④ 서브 쿼리는 항상 메인쿼리에서 읽혀진 데이터에 대해 서브쿼리에서 해당 조건이 만족하는지를 확인하는 방식으로 수행된다.  
> WHERE 독립적으로 시행


[문제 100]  
다음 중 아래 SQL에 대한 설명으로 가장 부적절한 것은?   3
[SQL]
SELECT B.사원번호, B.사원명, A.부서번호, A.부서명 
 , (SELECT COUNT(*) FROM 부양가족 Y WHERE Y.사원번호 = B.사원번호) AS 부양가족수
FROM 부서 A, (SELECT *
            FROM 사원
            WHERE 입사년도 = '2014') B
WHERE A.부서번호 = B.부서번호
AND EXISTS (SELECT 1 FROM 사원 X WHERE X. 부서번호 = A.부서번호);

① 위 SQL에는 다중 행 연관 서브쿼리, 단일 행 연관 서브쿼리, Inline View 가 사용되었다.  (O)
② SELECT절에 사용된 서브쿼리는 스칼라 서브쿼리라고도하며, 이러한 형태의 서브쿼리는 JOIN 으로 동일한 결과를 추출할 수도 있다. (O)
③ WHERE 절의 서브쿼리에 사원 테이블 검색 조건으로 입사년도 조건을 FROM절의 서브쿼리와 동일하게 추가해야 원하는 결과를 추출할 수 있다.  >   EXISTS 부서에 있니?
④ FROM 절의 서브쿼리는 동적 뷰(Dynamic View)라고도 하며, SQL 문장 중 테이블 명이 올 수 있는 곳에서 사용할 수 있다.


1) 인라인뷰 (SELECT *
            FROM 사원
            WHERE 입사년도 = '2014') B
2) 스칼라, 단일행연관쿼리 
           (SELECT COUNT(*) FROM 부양가족 Y WHERE Y.사원번호 = B.사원번호) AS 부양가족         
3) 다중행 
           EXISTS (SELECT 1 FROM 사원 X WHERE X. 부서번호 = A.부서번호);     


 
[문제 101]   2

> 평가대상상품에 대한 
> 품질평가항목별 최종 평가결과

1)  (SELECT MAX(평가회차) AS 평가회차 FROM 평가결과) D
전체평가에서 최대 회차 1개만 반환
2)  유력
3) 평가회차 MAX과 반드시 일치하지 않을 수도 있음.
4) 문자열과 날짜를 그냥 MAX로 뽑으면 최신회차와 연결되지 않음.



[문제 102]    3
아래 부서 테이블의 담당자 변경을 위해 

부서임시 테이블에 입력된 데이터를 활용하여 
주기적으로 부서 테이블을 아래 결과와 같이 반영하기 위한 SQL으로 가장 적절한 것은?(단, 부서임시 테이블에서 변경일자를 기준으로 가장 최근에 변경된 데이터를 기준으로 부서 테이블에 반영되어야 한다)


부서임시에서 해당부터코드의 가장 최근 변경일자

1,2 )  X   SET 담당자 = (SELECT C.부서코드

 
[문제 103]  
다음 중 뷰(View)에 대한 설명으로 가장 부적절한 것은?  4
① 뷰는 단지 정의만을 가지고 있으며, 실행 시점에 질의를 재작성하여 수행한다.  (o)
② 뷰는 복잡한 SQL 문장을 단순화 시켜주는 장점이 있는 반면, 테이블 구조가 변경되면 응용 프로그램을 변경해 주어야 한다. (O)
③ 뷰는 보안을 강화하기 위한 목적으로도 활용할 수 있다. (O)
④ 실제 데이터를 저장하고 있는 뷰를 생성하는 기능을 지원하는 DBMS도 있다. (X)



[문제 104]    2   
아래 테이블에 대한 [뷰 생성 스크립트]를 실행한 후, 조회 SQL의 실행결과로 맞는 것은?

[TBL]
C1	C2
A	  100
B	  200
B	  100
B	 (   )  
(  )200

[뷰 생성 스크립트]
CREATE VIEW V_TBL
AS
SELECT *
FROM TBL
WHERE CI = 'B' OR C1 IS NULL

>>>>1)
C1	C2 
B	  200
B	  100
B	 (   )  
(  )200


[조회 SQL]
SELECT SUM(C2) C2
FROM V_TBL
WHERE C2 >= 200 AND C1 = 'B'

>>>>> 2)
C1	C2 
B	  200 



[문제 105] 
다음 중 아래의 테이블에서 SQL을 실행할 때 결과로 가장 적절한 것은?
[테이블 : 서비스]

서비스ID(PK)	서비스명
001	서비스1
002	서비스2
003	서비스3
004	서비스4

[테이블 : 서비스가입]
회원번호(PK)	서비스ID(PK)	가입일자
1	001	2013-01-01
1	002	2013-01-02
2	001	2013-01-01
2	002	2013-01-02
2	003	2013-01-03
3	001	2013-01-01
3	002	2013-01-02
3	003	2013-01-03
[SQL]
SELECT CASE WHEN GROUPING(A.서비스ID) = 0 
            THEN A.서비스ID
            ELSE '합게' END AS 서비스ID
      ,CASE WHEN GROUPING(B, 가입일자) = 0
            THEN NVL(B, 가입일자, '-') ELSE '소재' END AS 가입일자
      ,COUNT(B.회원번호) AS 가입건수
FROM 서비스 A LEFT OUTER JOIN 서비스가입 B
ON (    A.서비스ID = B.서비스ID
    AND B.가입일자 BETWEEN '2013-01-01' AND '2013-01-31')
GROUP BY ROLLUP (A.서비스ID, B.가입일자);


※ GROUPING   그룹화가되면  1 , 아니면 0
   GROUPING(A.서비스ID)  
※ ROLLUP (A.서비스ID, B.가입일자);

    
1. FROM 서비스 A LEFT OUTER    → 004번 없는거   1,2

서비스ID(PK)	서비스명
001	서비스1
002	서비스2
003	서비스3
004	서비스4

2.  소계 / 합계  → 4
3.  답은 3


[문제 106] 2
아래의 데이터 모델에서 SQL을 이용하여 
표(지역별 월별 이용량)와 같은 형식의 
데이터를 추출하려고 할 때 올바른 SQL 문장은?


> 지역별 월별 이용량
경기	   월별합계	3,000
대전	   월별합계	2,500
지역전체	월별합계	7,500

지역전체

※ GROUPING   그룹화가되면  1 , 아니면 0

GROUP BY ROLLUP(B.지역명, TO_CHAR(A.이용일시, 'YYYY.MM'))


[문제 107]  ROLLUP
[SQL문]
SELECT 구매고객, 구매월, COUNT(*) '총 구매건', SUM(구매금액) '총 구매액'
FROM 구매이력
GROUP BY   ROLLUP(구매고객, 구매월)


[문제 108]  
다음 설명 중 가장 적절한 것은?  4

① 일반 그룹 함수를 사용하여 CUBE, GROUPING SETS와 같은 그룹함수와 동일한 결과를 추출할 수 있으나,  ROLLUP 그룹 함수와 동일한 결과는 추출할 수 없다.
> 일반 그룹 함수 (SUM, AVG, COUNT)


② GROUPING SETS 함수의 경우에는 함수의 인자로 주어진 컬럼의 순서에 따라 결과가 달라지므로 컬럼의 순서가 중요하다.   (?O)
> GRPUING SETS( (A,B) , (C,D) )   GRPUING SETS( (B,C) , (A,B) )    


③ CUBE, ROLLUP, GROUPING SETS 함수들의 대상 컬럼 중 
집계된 컬럼 이외의 대상 컬럼 값은 해당 컬럼의 데이터 중 가장 작은 값을 반환한다.
> ROLLUP에서는 NULL  (X)

④ CUBE 그룹 함수는 인자로 주어진 컬럼의 결합 가능한 모든 조합에 대해서 집계를 수행하므로 다른 그룹 함수에 비해 시스템에 대한 부하가 크다.
> (O)


[문제 109]  2,3
아래와 같이 설비와 에너지사용 테이블을 이용하여 결과를 나타내려할때 SQL으로 가장 적절한 것을 2개 고르시오.  (가장적절 2개)


CUBE

1) x
  GROUP BY CUBE ((A.설비ID), (B.에너지코드), (A.설비ID, B.에너지코드))
  (A.설비ID, B.에너지코드)   한번더 들어가 있음
2) O  모든집계
   GROUP BY CUBE (A.설비ID, B.에너지코드)
3) O  원하는 집계  
    ()전체합계
    GROUP BY GROUPING SETS((A.설비ID), (B.에너지코드),  (A.설비ID, B.에너지코드),())
4) X    ()  전체빠짐    


✅ 46~63번 (110~127): 실무형 SQL 로직, 집계, 조건부 연산
[문제 110]    
자재발주 테이블에 SQL을 수행하여 아래와 같은 결과를 얻었다. 다음 중에 (가) 들어갈 문장으로 옳은 것은?

SELECT CASE WHEN GROUPING(자재번호) = 1 THEN '자재전체'
        ELSE 자재번호 END AS 자재번호
     , CASE WHEN GROUPING(발주처ID) = 1 THEN '발주처전체'
        ELSE 발주처ID END AS 발주처ID
     , CASE WHEN GROUPING(발주일자) = 1 THEN '발주일자전체'
        ELSE 발주일자 END AS 발주일자
     , SUM(발주수량) AS 발주수량합계
FROM 자재발주
(가)
ORDER BY 자재번호, 발주처ID, 발주일자

--------------------------------------------------(4)
자재번호	발주처ID	발주일자	발주수량합계
자재전체	발주처전체	발주일자전체	900
1	발주처전체	발주일자전체	300
2	발주처전체	발주일자전체	300
3	발주처전체	발주일자전체	300
자재전체	001	20150102	300
자재전체	001	20150103	300
자재전체	002	20150102	100
자재전체	002	20150103	200

SELECT CASE WHEN GROUPING(자재번호) = 1 THEN '자재전체'
        ELSE 자재번호 END AS 자재번호
     , CASE WHEN GROUPING(발주처ID) = 1 THEN '발주처전체'
        ELSE 발주처ID END AS 발주처ID
     , CASE WHEN GROUPING(발주일자) = 1 THEN '발주일자전체'
        ELSE 발주일자 END AS 발주일자
     , SUM(발주수량) AS 발주수량합계
FROM 자재발주
(가)  GROUP BY GROUPING SETS (자재번호, (발주처ID, 발주일자))
ORDER BY 자재번호, 발주처ID, 발주일자


--------------------------------------------------(3)
자재번호	발주처ID	발주일자	발주수량합계 
1	발주처전체	발주일자전체	300
2	발주처전체	발주일자전체	300
3	발주처전체	발주일자전체	300
자재전체	001	20150102	300
자재전체	001	20150103	300
자재전체	002	20150102	100
자재전체	002	20150103	200
SELECT CASE WHEN GROUPING(자재번호) = 1 THEN '자재전체'
        ELSE 자재번호 END AS 자재번호
     , CASE WHEN GROUPING(발주처ID) = 1 THEN '발주처전체'
        ELSE 발주처ID END AS 발주처ID
     , CASE WHEN GROUPING(발주일자) = 1 THEN '발주일자전체'
        ELSE 발주일자 END AS 발주일자
     , SUM(발주수량) AS 발주수량합계
FROM 자재발주
(가)  GROUP BY GROUPING SETS (자재번호,  발주처ID, 발주일자 )
ORDER BY 자재번호, 발주처ID, 발주일자



[문제 111] 2
GROUP BY GROUPING SETS((상품ID, 월));

두개로 묶은거 확인 :  GROUP BY GROUPING SETS((상품ID, 월));


[문제 112]   3
다음 중 윈도우 함수(Window Function, Analytic Function)에 대한 설명으로 가장 부적절한 것은?

① Partition과 Group By 구문은 의미적으로 유사하다. (? 비슷)
② Partition 구분이 없으면 전체 집합을 하나의 Partition으로 정의한 것과 동일하다. (o)
③ 윈도우 함수 처리로 인해 결과 건수가 줄어든다. (유지함. 계산값 추가 X)
④ 윈도우 함수 적용 범위는 Partition을 넘을 수 없다. (O 파티션내에서만)


[문제 113]  
다음 중 아래와 같은 테이블에서 SQL

[SQL]
SELECT 고객번호, 고객명, 매출액
      , RANK() OVER(ORDER BY 매출액 DESC) AS 순위
FROM (
    SELECT A.고객번호
        , MAX(A.고객명) AS 고객명
        , SUM(B.매출액) AS 매출액
    FROM 고객 A INNER JOIN 월별매출 B
    ON (A.고객번호 = B.고객번호)
    GROUP BY A.고객번호
    )
ORDER BY 순위;

RANK() OVER(ORDER BY 매출액 DESC) AS 순위


※ RANK()  OVER(정렬)  동일순서, 다음순위 건너뜀   1 1  3 4 
※ DENSE_RANK         동일순서, 다음순위로 이어짐  1 1 2
※ ROW_NUMBER         순위1 2 3 4 


[문제 114]  4
아래 데이터 모델에서 
활동점수가 높은 고객을 게임상품ID별로 10등까지 선별하여 사은행사를 진행하려고 한다. 다음 SQL 중 가장 적절한 것은? (단, 활동점수가 동일한 고객은 동일등수로 한다. 아래 결과 예제 참조)


활동점수가 높은 고객을   ORDER BY 활동점수 DESC
게임상품ID별     PARTITION BY 게임상품ID
RANK() OVER(PARTITION BY 게임상품ID ORDER BY 활동점수 DESC) AS 순위 


※ RANK()  OVER(정렬)  동일순서, 다음순위 건너뜀   1 1  3 4 
※ DENSE_RANK         동일순서, 다음순위로 이어짐  1 1 2
※ ROW_NUMBER         순위1 2 3 4 


[문제 115]    3
다음 중 추천내역 테이블에서 아래와 같은 SQL을 수행하였을 때의 결과로 가장 적절한 것은?

[SQL]
SELECT 추천경로, 추천인, 피추천인, 추천점수
FROM (SELECT 추천경로, 추천인, 피추천인, 추천점수 , 
        ROW_NUMBER() OVER(PARTITION BY 추천경로 ORDER BY 추천점수 DESC) AS RNUM
      FROM 추천내역)
WHERE RNUM = 1;
>>>>>>>
ROW_NUMBER() OVER(
  PARTITION BY 추천경로    -- 그룹핑
  ORDER BY 추천점수 DESC   -- 내림차순
)
WHERE RNUM = 1;   -- 최고건 1개만


추천경로	추천인	피추천인	추천점수
SNS	이순신	강감찬	80 

이벤트응모	홍길동	강감찬	88 

홈페이지	홍두깨	심청이	98 



[문제 116] 
다음 중 아래의 SQL에 대한 설명으로 가장 적절한 것은?
[SQL]
SELECT 상품분류코드
        ,AVG(상품가격) AS 상품가격
        ,COUNT(*) OVER(ORDER BY AVG(상품가격)
                        RANGE BETWEEN 10000 PRECEDING
                    AND 10000 FOLLOWING) AS 유사개수
FROM 상품
GROUP BY 상품분류코드;

① WINDOW FUNCTION을 GROUP BY 절과 함께 사용하였으므로 위의 SQL은 오류가 발생한다.  → (X) 사용가능
② WINDOW FUNCTION의 ORDER BY절에 AVG 집계 함수를 사용하였으므로 위의 SQL은 오류가 발생한다.   →  (X) ORDER BY절에 AVG 집계 함수를 사용불가능
③ 유사개수 컬럼은 상품분류코드별 평균상품가격을 서로 비교하여 -10000 ~ +10000 사이에 존재하는 상품분류코드의 개수를 구한 것이다. (O)  GROUP BY 상품분류코드
④ 유사개수 컬럼은 상품전체의 평균상품가격을 서로 비교하여 -10000 ~ +10000 사이에 존재하는 상품의 개수를 구한 것이다. (X) 전체평균아님


[문제 117]  1
다음 중 [사원] 테이블에 대하여 아래와 같은 SQL을 수행하였을 때 예상되는 결과로 가장 적절한 것은?

[SQL]
SELECT Y.사원ID, Y.부서ID, Y.사원명, Y.연봉
FROM (SELECT 사원ID, MAX(연봉) OVER(PARTITION BY 부서ID) AS 최고연봉 
      FROM 사원) X, 사원 Y
WHERE X.사원ID = Y.사원ID
AND   X.최고연봉 = Y.연봉

1) PARTITION BY 부서ID 부서별
2)  MAX(연봉)   최고연봉

사원ID	부서ID	사원이름	연봉
002	100	강감찬	3000
003	200	김유신	4500
006	300	변사또	4500


[문제 118]  1
다음 중 아래 SQL의 실행 결과로 가장 적절한 것은?
1)
START_VAL   START_VAL = LAG(END_VAL)
            시작       = 이전(END_VAL)

END_VAL     END_VAL   = LEAD(START_VAL) OVER
            마지막     =  다음의(START_VAL)

2) 연속되지 않은 구간
WHERE FLAG1 = 0  OR FLAG2=0

※ LAG  이전
※ LEAD 다음



[문제 119] 
아래 설명 중 (가), (나)에 해당하는 내용을 작성하시오.

DBMS에 생성된 USER와 다양한 권한들 사이에서 중개 역할을 할 수 있도록 DBMS에서는 ROLE을 제공한다. 이러한 ROLE을 DBMS USER에게 부여하기 위해서는 (가) 명령을 사용하며, ROLE을 회수하기 위해서는 (나) 명령을 사용한다.

가 -  G(RANT)
나 -  R(EVOKE)

-R
■DDL(정의어) - CADR
  - C(REATE), A(LATER) , D(ROP) , R(NAME)
■DML(조작어) - CRUD
  - C(insert), R(select), U(update), D(delete)
■DCL(제어어-권한) - RG
  - R(EVOKE) 빼기 , G(RANT) 주기
■TCL(제어어-트랜잭션) -CR
  - C(OMMIT) , R(OLLBAK)


[문제 120]    4
다음 중 B_User가 아래의 작업을 수행할 수 있도록 권한을 부여하는 DCL로 가장 적절한 것은?

UPDATE A_User.TB_A
SET   coll='AAA'
WHERE col2=3

④ GRANT SELECT, UPDATE ON A_User.TB_A TO B_User;


[문제 121]      ROLE
아래의 (가)에 들어갈 내용을 쓰시오.     [다양한 권한을 그룹]

DBMS 사용자를 생성하면 기본적으로 많은 권한을 부여해야 한다. 많은 DBMS에서는 DBMS 관리자가 사용자별로 권한을 관리해야 하는 부담과 복잡함을 줄이기 위하여 다양한 권한을 그룹으로 묶어 관리할 수 있도록 사용자와 권한 사이에서 중개 역할을 수행하는 (가)을 제공한다. 


[문제 122]   1,2
사용자 Lee가 릴레이션 R을 생성한 후, 아래와 같은 권한부여 SQL문들을 실행하였다. 그 이후에 기능이 실행 가능한 SQL을 2개 고르시오. (단, A, B의 데이터 타입은 정수형이다)

Lee: GRANT SELECT, INSERT, DELETE ON R TO Kim WITH GRANT OPTION;
Kim: GRANT SELECT, INSERT, DELETE ON R TO Park;
Lee: REVOKE DELETE ON R FROM Kim;
Lee: REVOKE INSERT ON R FROM Kim CASCADE;

① Park: SELECT * FROM R WHERE A = 400;
② Park: INSERT INTO R VALUES (400, 600);
③ Park: DELETE FROM R WHERE B = 800;
④ Kim : INSERT INTO R VALUES (500, 600);


KIM  :  SELECT, INSERT, DELETE / GRANT OPTION(권한주기)
Park :  SELECT, INSERT, DELETE /

KIM  :  SELECT  / GRANT OPTION(권한주기)
Park :  SELECT, DELETE /


[문제 123]   
다음 중 PL/SQL에 대한 설명으로 가장 부적절한 것은?  3

① 변수와 상수 등을 사용하여 일반 SQL 문장을 실행할 때 WHERE절의 조건 등으로 대입할 수 있다.  (O)
② Procedure, User Defined Function, Trigger 객체를 PL/SQL로 작성할 수 있다. (O)
③ PL/SQL로 작성된 Procedure, User Defined Function은 전체가 하나의 트랜젝션으로 처리되어야 한다.  (X)   - 트랜잭션은 COMMIT / ROLLBACK
④ Procedure 내부에 작성된 절차적 코드는 PL/SQL엔진이 처리하고 일반적인 SQL 문장은 SQL실행기가 처리한다.  (O)



[문제 124] 3
아래는 임시부서(TMP_DEPT) 테이블로부터 부서(DEPT) 테이블에 데이터를 입력하는 PL/SQL 이다. 부서 테이블에 데이터를 입력하기 전에 부서 테이블의 모든 데이터를 ROLLBACK이 불가능 하도록 삭제하려고 한다. 다음 중 (가)에 들어갈 내용으로 옳은 것은?
[PL/SQL]
create or replace procedure insert_dept_authid current_user
as
begin
(가)
INSERT /*+ APPEND */ INTO DEPT (DEPTNO, DNAME, LOC)
SELECT DEPTNO, DNAME, LOC
FROM TMP_DEPT;
commit;
end;
/

> ROLLBACK이 불가능 하도록 삭제 : TRUNCATE TABLE DEPT
> execute immediate 'TRUNCATE TABLE DEPT';


[문제 125]   
다음 중 절차형 SQL 모듈에 대한 설명으로 가장 부적절한 것은?  4

① 저장형 프로시져는 SQL을 로직과 함께 데이터베이스 내에 저장해 놓은 명령문의 집합을 의미한다. (O)
② 저장형 함수(사용자 정의 함수)는 단독적으로 실행되기 보다는 다른 SQL문을 통하여 호출되고 그 결과를 리턴하는 SQL의 보조적인 역할을 한다. (O)
③ 트리거는 특정한 테이블에 INSERT, UPDATE, DELETE와 같은 DML문이 수행되었을 때 데이터베이스에서 자동으로 동작하도록 작성된 프로그램이다.  (o)
④ 데이터의 무결성과 일관성을 위해서 사용자 정의 함수를 사용한다.  > 외래키, 일관성, 제약조건


[문제 126] 
다음 중 Trigger에 대한 설명으로 가장 부적절한 것은? 3

① Trigger는 데이터베이스에 의해서 자동으로 호출되고 수행된다. (O)
② Trigger는 특정 테이블에 대해서 INSERT, UPDATE, DELETE 문이 수행되었을 때 호출되도록 정의할 수 있다. (O)
③ Trigger는 TCL을 이용하여 트랜젝션을 제어할 수 있다. (X)
④ Trigger는 데이터베이스에 로그인하는 작업에도 정의할 수 있다.  (O)

[문제 127]  4
다음 중 특정한 테이블에 INSERT, UPDATE, DELETE와 같은 DML문이 수행되었을 때, 데이터베이스에서 자동으로 동작하도록 작성된 저장 프로그램으로 가장 적절한 것은?(단, 사용자가 직접 호출하여 사용하는 것이 아니고 데이터베이스에 서 자동적으로 수행하게 된다.)

① PROCEDURE
② USER DEFINED FUNCTION
③ PACKAGE
④ TRIGGER


📁 SQL OPTIMIZATION

[문제 128]통계 정보를 활용해 실행계획을 선택하는 옵티마이저는?
CBO (Cost Based Optimizer) , 비용기반 옵티마이저


[문제 129]  
다음 중 실행계획을 통해서 알 수 있는 정보로 가장 부적절한 것은? 4

① 액세스 기법
② 질의 처리 예상 비용(Cost)
③ 조인 순서
④ 실제 처리 건수


[문제 130]  
아래 실행계획의 실행순서에 맞게 ㉠, ㉡, ㉢ 을 작성하시오.

1  NESTED LOOPS (6)

2    HASH JOIN                       (3)
3      TABLE ACCESS (FULL) TAB1      (1)
4      TABLE ACCESS (FULL) TAB2      (2)

5    TABLE ACCESS (BY ROWID) TAB3    (5)
6      INDEX (UNIQUE SCAN) PK TAB3   (4)


    ㉠3 → ㉡ 4→ ㉢2 → 6 → 5 → 1


 [문제 131]   
다음 중 실행계획에 대한 설명으로 가장 부적절한 것은? 3

① 실행계획은 SQL 처리를 위한 실행 절차와 방법을 표현한 것이다.
② 실행계획은 조인 방법, 조인 순서, 액세스 기법 등이 표현된다.
③ 동일 SQL문에 대해 실행계획이 다르면 실행 결과도 달라질 수 있다.  (X) 성능이 달라짐
④ CBO(Cost Based Optimizer)의 실행계획에는 단계별 예상 비용 및
건수 등이 표시된다.   

[문제 132]  
다음 중 아래와 같은 SQL 처리 흐름도(Access Flow Diagram)에 대한 설명으로 가장 적절한 것을 2개 고르시오. 2,4


[문제 133]  
다음 중 옵티마이저와 실행계획에 대한 설명으로 부적절한 것을 2개 고르시오.  1,4

① SQL 처리 흐름도는 성능적인 측면의 표현은 고려하지 않는다.  (X)
② 규칙기반 옵티마이저에서 제일 높은 우선순위는 행에 대한 고유 주소를 사용하는 방법이다.
③ SQL 처리 흐름도는 인덱스 스캔 및 전체 테이블 스캔 등의 액세스 기법을 표현할 수 있다.
④ 인덱스 범위 스캔은 항상 여러 건의 결과가 반환된다. -> (X)

[문제 134] 
PK 중복불가, NULL X


[문제 135]
대량의 데이터 ,조회 