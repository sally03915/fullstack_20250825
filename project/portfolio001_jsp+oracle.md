 

## ✅ 공통 사용자 모듈 (필수 테이블만)


#### 1. `MbtiType`
| 필드명 | 타입 | 설명 |
|--------|------|------|
| mbti_type_id | INT (PK) | MBTI 유형 ID |
| name | VARCHAR(10) | 유형 이름 (예: ENFP) |
| description | TEXT | 성향 설명 |

**예시 데이터**
```sql
(3, 'ENFP', '열정적이고 창의적인 성향')
(7, 'INTJ', '논리적이고 전략적인 성향')
```


#### 2. `AppUser`
| 필드명 | 타입 | 설명 |
|--------|------|------|
| app_user_id | INT (PK) | 사용자 고유 ID |
| email | VARCHAR(100) | 이메일 주소 |
| password | VARCHAR(255) | 암호화된 비밀번호 |
| mbti_type_id | INT (FK → MbtiType.mbti_type_id) | 연결된 MBTI 유형 |
| created_at | DATETIME | 가입일 |

**예시 데이터**
```sql
(1, 'alice@example.com', 'hashed_pw_123', 3, 2, '2025-10-01 10:00:00')
(2, 'bob@example.com', 'hashed_pw_456', 7, 1, '2025-10-02 14:30:00')
```




```sql
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
```

※ `UserRole`, `JwtToken`, `UserLoginLog` 등은 인증 서버 구축 시 필요하므로 JSP 단독 프로젝트에서는 생략 가능합니다.




---




## 💡 PROJECT1: MBTI 테스트 + 결과보기

```sql
-- 질문 테이블
CREATE TABLE Question (
  question_id NUMBER(5) PRIMARY KEY,
  text VARCHAR2(500),
  created_by NUMBER(5),
  created_at DATE,
  FOREIGN KEY (created_by) REFERENCES AppUser(app_user_id)
);

-- 보기 테이블
CREATE TABLE Choice (
  choice_id NUMBER(5) PRIMARY KEY,
  question_id NUMBER(5),
  text VARCHAR2(255),
  mbti_type_id NUMBER(3),
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (mbti_type_id) REFERENCES MbtiType(mbti_type_id)
);

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
```
 