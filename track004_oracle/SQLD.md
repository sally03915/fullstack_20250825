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