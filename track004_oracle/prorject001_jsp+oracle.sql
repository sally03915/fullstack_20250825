--## ✅ 공통 사용자 모듈 (필수 테이블만)
--1. ✅ 사용자 정보 관리
--AppUser 테이블: 사용자 계정 정보(email, password 등)와 함께, 테스트 결과로 도출된 MBTI 유형을 저장합니다.
--MbtiType 테이블: 16가지 MBTI 유형과 그에 대한 설명을 저장합니다.

-- MBTI 유형 테이블
CREATE TABLE MbtiType (
  mbti_type_id NUMBER(3) PRIMARY KEY,
  name VARCHAR2(10),
  description VARCHAR2(100)
);
 

-- 사용자 테이블
CREATE TABLE AppUser (
  app_user_id NUMBER(5) PRIMARY KEY,
  email VARCHAR2(100),
  password VARCHAR2(255),
  mbti_type_id NUMBER(3),
  created_at DATE,
  FOREIGN KEY (mbti_type_id) REFERENCES MbtiType(mbti_type_id)
); 
select * from
--※ `UserRole`, `JwtToken`, `UserLoginLog` 등은 인증 서버 구축 시 필요하므로 JSP 단독 프로젝트에서는 생략 가능합니다.

INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (1, 'ISTJ', '신중하고 책임감 있는 현실주의자');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (2, 'ISFJ', '헌신적이고 따뜻한 보호자');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (3, 'INFJ', '통찰력 있고 조용한 이상주의자');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (4, 'INTJ', '논리적이고 전략적인 성향');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (5, 'ISTP', '실용적이고 분석적인 문제 해결자');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (6, 'ISFP', '조용하고 감성적인 예술가');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (7, 'INFP', '이상과 가치 중심의 중재자');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (8, 'INTP', '호기심 많고 논리적인 사색가');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (9, 'ESTP', '활동적이고 현실적인 행동가');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (10, 'ESFP', '사교적이고 즉흥적인 즐거움 추구자');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (11, 'ENFP', '열정적이고 창의적인 성향');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (12, 'ENTP', '재치 있고 논쟁을 즐기는 혁신가');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (13, 'ESTJ', '체계적이고 단호한 관리자');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (14, 'ESFJ', '친절하고 협력적인 조정자');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (15, 'ENFJ', '카리스마 있고 타인을 이끄는 지도자');
INSERT INTO MbtiType (mbti_type_id, name, description) VALUES (16, 'ENTJ', '결단력 있고 효율적인 통솔자');
commit;




---
--## 💡 PROJECT1: MBTI 테스트 + 결과보기
--2. ❓ 질문과 선택지 구성
--Question 테이블: MBTI 테스트에 사용되는 질문들을 저장합니다.
--Choice 테이블: 각 질문에 대한 보기(선택지)를 저장하며, 각 선택지는 특정 MBTI 유형과 연결되어 있습니다.

--| 질문 번호 | MBTI 축 | 분류 방향 |
--|-----------|---------|------------|
--| 20001, 20002  | E/I     | 내향 vs 외향 |
--| 20003, 20004  | S/N     | 감각 vs 직관 |
--| 20005, 20006  | T/F     | 사고 vs 감정 |
--| 20007, 20008  | J/P     | 판단 vs 인식 |
--| 20009, 21000  | 보조    | 창의성, 감정 표현 |

 
-- 질문 테이블
CREATE TABLE Question (
  question_id NUMBER(5) PRIMARY KEY,
  text VARCHAR2(500),
  created_by NUMBER(5),
  created_at DATE,
  FOREIGN KEY (created_by) REFERENCES AppUser(app_user_id)
);

INSERT INTO Question (question_id, text, created_by, created_at)
VALUES (20001, '새로운 사람들과 어울리는 것이 즐거운 편인가요?', 24910, SYSDATE);

INSERT INTO Question (question_id, text, created_by, created_at)
VALUES (20002, '계획을 세우고 따르는 것을 좋아하나요?', 24910, SYSDATE);

INSERT INTO Question (question_id, text, created_by, created_at)
VALUES (20003, '감정보다 논리로 판단하는 편인가요?', 24910, SYSDATE);

INSERT INTO Question (question_id, text, created_by, created_at)
VALUES (20004, '혼자 시간을 보내는 것이 편안한가요?', 24910, SYSDATE);

INSERT INTO Question (question_id, text, created_by, created_at)
VALUES (20005, '즉흥적인 결정을 자주 하나요?', 24910, SYSDATE);

INSERT INTO Question (question_id, text, created_by, created_at)
VALUES (20006, '타인의 감정을 잘 알아차리는 편인가요?', 24910, SYSDATE);

INSERT INTO Question (question_id, text, created_by, created_at)
VALUES (20007, '상상력보다는 현실적인 접근을 선호하나요?', 24910, SYSDATE);

INSERT INTO Question (question_id, text, created_by, created_at)
VALUES (20008, '갈등 상황에서 직접적으로 표현하는 편인가요?', 24910, SYSDATE);

INSERT INTO Question (question_id, text, created_by, created_at)
VALUES (20009, '일을 시작하기 전에 충분히 계획을 세우나요?', 24910, SYSDATE);

INSERT INTO Question (question_id, text, created_by, created_at)
VALUES (20010, '새로운 아이디어를 떠올리는 것을 좋아하나요?', 24910, SYSDATE);
commit;



-- 보기 테이블
CREATE TABLE Choice (
  choice_id NUMBER(5) PRIMARY KEY,
  question_id NUMBER(5),
  text VARCHAR2(255),
  mbti_type_id NUMBER(3),
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (mbti_type_id) REFERENCES MbtiType(mbti_type_id)
);


--Choice
-- Question 20001: 외향성 vs 내향성
INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30001, 20001, '예, 사람들과 어울리는 걸 좋아해요.', 10); -- ESFP

INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30002, 20001, '아니요, 혼자 있는 게 더 편해요.', 4); -- INTJ

-- Question 20002: 계획성
INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30003, 20002, '네, 계획을 세우는 게 중요하다고 생각해요.', 1); -- ISTJ

INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30004, 20002, '아니요, 즉흥적인 게 더 좋아요.', 11); -- ENFP

-- Question 20003: 감정 vs 사고
INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30005, 20003, '논리적으로 판단하는 편이에요.', 5); -- ISTP

INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30006, 20003, '감정이 더 중요하다고 생각해요.', 6); -- ISFP

-- Question 20004: 내향성
INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30007, 20004, '혼자 있는 시간이 에너지를 줘요.', 3); -- INFJ

INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30008, 20004, '사람들과 함께 있을 때 더 활력이 생겨요.', 9); -- ESTP

-- Question 20005: 즉흥성
INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30009, 20005, '즉흥적으로 행동하는 걸 좋아해요.', 12); -- ENTP

INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30010, 20005, '계획을 세우고 움직이는 편이에요.', 13); -- ESTJ

-- Question 20006: 감정 인식
INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30011, 20006, '타인의 감정을 잘 공감해요.', 2); -- ISFJ

INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30012, 20006, '감정보다는 사실에 집중해요.', 8); -- INTP

-- Question 20007: 현실 vs 직관
INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30013, 20007, '현실적인 접근을 선호해요.', 14); -- ESFJ

INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30014, 20007, '상상력과 아이디어가 더 중요해요.', 7); -- INFP

-- Question 20008: 표현 방식
INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30015, 20008, '직접적으로 표현하는 편이에요.', 15); -- ENFJ

INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30016, 20008, '조심스럽게 표현하거나 피하는 편이에요.', 6); -- ISFP

-- Question 20009: 사전 계획
INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30017, 20009, '계획을 세우고 실행하는 걸 좋아해요.', 13); -- ESTJ

INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30018, 20009, '계획 없이 유연하게 움직이는 편이에요.', 11); -- ENFP

-- Question 20010: 창의성
INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30019, 20010, '새로운 아이디어를 떠올리는 걸 즐겨요.', 12); -- ENTP

INSERT INTO Choice (choice_id, question_id, text, mbti_type_id)
VALUES (30020, 20010, '실현 가능한 아이디어에 집중해요.', 1); -- ISTJ

commit;



--3. 📝 사용자 응답 기록
--QuestionLog 테이블: 사용자가 어떤 질문에 어떤 선택지를 골랐는지 기록합니다. 이 데이터를 기반으로 사용자의 MBTI 성향을 분석할 수 있어요.

-- 사용자 응답 기록
CREATE TABLE QuestionLog (
  log_id NUMBER(5) PRIMARY KEY,
  app_user_id NUMBER(5),
  question_id NUMBER(5),
  choice_id NUMBER(5),
  timestamp DATE,
  FOREIGN KEY (app_user_id) REFERENCES AppUser(app_user_id),
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (choice_id) REFERENCES Choice(choice_id)
);

CREATE SEQUENCE QuestionLog_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;


desc appuser;


--4. 🏷️ 질문 분류 및 관리
--Tag 테이블: 질문을 E/I, S/N, T/F, J/P 같은 MBTI 축으로 분류하기 위한 태그를 정의합니다.
--QuestionTagMap 테이블: 질문과 태그를 연결하여, 어떤 질문이 어떤 MBTI 축에 해당하는지 관리합니다.
--QuestionAudit 테이블: 질문이 수정되었을 때 변경 이력을 기록합니다.

-- 질문 태그 정의
CREATE TABLE Tag (
  tag_id NUMBER(3) PRIMARY KEY,
  name VARCHAR2(50)
);

-- 질문과 태그 연결 (다대다)
CREATE TABLE QuestionTagMap (
  question_id NUMBER(5),
  tag_id NUMBER(3),
  PRIMARY KEY (question_id, tag_id),
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (tag_id) REFERENCES Tag(tag_id)
);

-- 질문 변경 이력
CREATE TABLE QuestionAudit (
  audit_id NUMBER(5) PRIMARY KEY,
  question_id NUMBER(5),
  action_type VARCHAR2(50),
  changed_by NUMBER(5),
  changed_at DATE,
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (changed_by) REFERENCES AppUser(app_user_id)
); 
 
 
--### 🔄 테스트 흐름 예시
--1. 사용자가 로그인 또는 회원가입을 합니다.
--2. 시스템은 `Question` 테이블에서 질문을 불러옵니다.
--3. 각 질문에 대해 `Choice` 테이블의 보기들을 사용자에게 보여줍니다.
--4. 사용자가 선택한 보기(choice)는 `QuestionLog`에 저장됩니다.
--5. 모든 질문에 응답한 후, 선택된 보기들의 `mbti_type_id`를 기반으로 가장 많이 선택된 유형을 분석합니다.
--6. 분석 결과는 `AppUser.mbti_type_id`에 저장되고, 사용자에게 결과를 보여줍니다.
 
 