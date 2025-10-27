 
#### 🛠️ SQL DDL 생성 (공통 모듈)

```sql
-- 공통 사용자 모듈

CREATE TABLE MbtiType (
  mbti_type_id INT PRIMARY KEY,
  name VARCHAR(10),
  description TEXT
);

CREATE TABLE UserRole (
  user_role_id INT PRIMARY KEY,
  name VARCHAR(50)
);

CREATE TABLE AppUser (
  app_user_id INT PRIMARY KEY,
  email VARCHAR(100),
  password VARCHAR(255),
  mbti_type_id INT,
  user_role_id INT,
  created_at DATETIME,
  FOREIGN KEY (mbti_type_id) REFERENCES MbtiType(mbti_type_id),
  FOREIGN KEY (user_role_id) REFERENCES UserRole(user_role_id)
);

CREATE TABLE JwtToken (
  token_id INT PRIMARY KEY,
  app_user_id INT,
  access_token TEXT,
  issued_at DATETIME,
  expires_at DATETIME,
  FOREIGN KEY (app_user_id) REFERENCES AppUser(app_user_id)
);

CREATE TABLE UserLoginLog (
  log_id INT PRIMARY KEY,
  app_user_id INT,
  login_time DATETIME,
  ip_address VARCHAR(50),
  FOREIGN KEY (app_user_id) REFERENCES AppUser(app_user_id)
);
```


<br/>
<br/>
<br/>


#### 🛠️ SQL DDL 생성 (공통 모듈 + PROJECT1)
```sql
-- PROJECT1: MBTI 테스트

CREATE TABLE Question (
  question_id INT PRIMARY KEY,
  text TEXT,
  created_by INT,
  created_at DATETIME,
  FOREIGN KEY (created_by) REFERENCES AppUser(app_user_id)
);

CREATE TABLE Choice (
  choice_id INT PRIMARY KEY,
  question_id INT,
  text VARCHAR(255),
  mbti_type_id INT,
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (mbti_type_id) REFERENCES MbtiType(mbti_type_id)
);

CREATE TABLE QuestionLog (
  log_id INT PRIMARY KEY,
  app_user_id INT,
  question_id INT,
  choice_id INT,
  timestamp DATETIME,
  FOREIGN KEY (app_user_id) REFERENCES AppUser(app_user_id),
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (choice_id) REFERENCES Choice(choice_id)
);

CREATE TABLE Tag (
  tag_id INT PRIMARY KEY,
  name VARCHAR(50)
);

CREATE TABLE QuestionTagMap (
  question_id INT,
  tag_id INT,
  PRIMARY KEY (question_id, tag_id),
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (tag_id) REFERENCES Tag(tag_id)
);

CREATE TABLE QuestionAudit (
  audit_id INT PRIMARY KEY,
  question_id INT,
  action_type VARCHAR(50),
  changed_by INT,
  changed_at DATETIME,
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (changed_by) REFERENCES AppUser(app_user_id)
);
```
 