#1. project 만들기 
    Q. boot002번으로 프로젝트만들기 (연습용프로젝트)
    - dev tools (변경시 자동시작) , lombok, mybatis, oraclce, spring web , thymeleaf
    - java 11
    - port 9494 
    - db설정

#2. model
    Q1.  테이블확인
    Q2.  Dto
    Q3.  Dao 
        SQL>
        SQL> desc sboard2;
        Name                                      Null?    Type
        ----------------------------------------- -------- ----------------------------
        ID                                        NOT NULL NUMBER
        APP_USER_ID                               NOT NULL NUMBER
        BTITLE                                    NOT NULL VARCHAR2(1000)
        BCONTENT                                  NOT NULL CLOB
        BPASS                                     NOT NULL VARCHAR2(255)
        BFILE                                              VARCHAR2(255)
        BHIT                                               NUMBER
        BIP                                       NOT NULL VARCHAR2(255)
        CREATED_AT                                         DATE

        SQL>


#3. 이미지 업로드 - 서비스
#4. VIEW 템플릿설정
#5. CONTROLLER

#6. 페이징
    Q) 페이징 + 검색

#7. 시큐리티
    Q) 멤버연습 

    SQL> desc appuser;
    Name                                      Null?    Type
    ----------------------------------------- -------- ----------------------------
    APP_USER_ID                               NOT NULL NUMBER(5)
    EMAIL                                     NOT NULL VARCHAR2(100)
    PASSWORD                                           VARCHAR2(100)
    MBTI_TYPE_ID                                       NUMBER(3)
    CREATED_AT                                         DATE
    UFILE                                              VARCHAR2(255)
    MOBILE                                             VARCHAR2(50)
    NICKNAME                                           VARCHAR2(50)
    PROVIDER                                  NOT NULL VARCHAR2(50)
    PROVIDER_ID                                        VARCHAR2(100)

    SQL> desc authorities;
    Name                                      Null?    Type
    ----------------------------------------- -------- ----------------------------
    AUTH_ID                                   NOT NULL NUMBER(5)
    EMAIL                                              VARCHAR2(255)
    AUTH                                      NOT NULL VARCHAR2(255)
    APP_USER_ID                                        NUMBER(5)

    SQL>  create sequence authorities_seq;


    ◎Q1.  테이블확인
    ○ Q2.  Dto
    ○ Q3.  Dao   > sql 찾기
        1. 회원가입
        2-1. 로그인 (이메일로 이메일, 비밀번호, 권한가져오기) 
        2-2. 이메일로 유저정보찾기    
        2-3. 이메일로 아이디중복검사   
        3. 회원수정
        4. 회원삭제

        5. 권한삽입
        6. 권한삭제

    ○ Q4.  Service



#8. api      
◎ 스케쥴링 
- naver 개발자 (api 보기 기본)
- mail★ 
- 크롤링
- map
- chatgpt ★ 
- kma★ 
- coolsms
- kakaopay



##### 포트폴리오
※ API 사용
◎1. 주제          :
◎2. 주요역할(CRUD) : 
   - API이용해서 번뜩이는 아이디어....
   - 앞에 구글시트 샘플예시
---
○3. 흐름도 + 피그마
○4. 프로젝트 깃허브에 올리기 (팀장 : 팀원들은 내려받아서 테스트)
○5. ERD
    1) 주요기능 - api
    2) 기능 또는 api 맞춰서 테이블   (상담)

    create : sql
    read   : 
    update : 
    delete :  

---
6. 개발
- MODEL      (자동테스트)
- SERVICE    (자동테스트)
- CONTROLLER  

> 구글시트 작성예시)
https://docs.google.com/spreadsheets/d/1s5dTXFDuNB1LPfwZl9G2DNnVyv8UcdMAdDu_rVy5AEk/edit?gid=576642430#gid=576642430

sally03915@gmail.com


 