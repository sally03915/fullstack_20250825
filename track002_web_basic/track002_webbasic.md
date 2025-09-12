## Track002 - html + css + js/jquery (WEB BASIC) 
#### 1. 웹의 작업순서
   1) html 구조
   2) css 꾸미기
   3) js/jquery / react 동작
   4) jsp + oracle  서버전송 + 데이터저장

#### 2. html 파일템플릿
- ! + enter
- html : 문서의 시작과 끝
- head : 문서 정보
- body : 사용자에게 보이는 내용
- 다소문자 / 시작태그와~ 끝나는태그

```bash
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>web basic001</title>
</head>
<body>
   안녕 Html 
</body>
</html>
```

#### 3. Tag
1. 웹페이지의 구성요소를 알려주는 표시언어
2. h1~h6  제목
   - h1 : 로고, 상호명
   - h2 : 주메뉴
   - h3~h6 : 중요도 상세메뉴 (소제목)
3. p, pre : 문단
   - p : 일반문단
   - pre : 줄바꿈과 공백을 유지하는 서식텍스트
4. img  : 이미지
   - src : 경로  , alt : 대체용어 
5. a : 링크
   - href : 다른페이지나 파일로 연결 , target="_blank" 새창열기
6. 리스트태그 : ul , ol, dl
   - ul  : 순서없는리스트
   - ol  : 순서있는리스트
   - dl  : 설명리스트  
7. 그룹핑 : div




### 4. CSS
1. 여백 - margin / padding
   1. margin : 바깥쪽여백
   2. padding : 안쪽여백

2. 글자스타일
   1.글자색상
      color:red
   2.글자크기
      font-size:16px
   3.정렬
      text-align:center /left /right/justify 문단의 정렬을 체크해주는 부분인데 left(왼쪽정렬) , right(오른쪽정렬) , center(중앙) , justify(수평정렬)
   4.밑줄
      text-decoration:none; 깃허브
   5. 글꼴
      font-family:sans-serif;
   6. 굵게
      font-weight:bold;

3. 배경꾸미기
      background-color: gold;
      background:black;
      background:linear-gradient(to right, pink, orange) background:linear-gradient(45deg, pink, orange)
      background: red url(./img/five.png) repeat center / 20px 20px
                  색상 경로 반복여부 중앙배치 가로사이즈 세로사이즈  

4. 박스디자인
   1. 가로 : width:300px
   2. 선 : border:3px solid red
   3. 둥근모서리 : borer-radius : 20px
   4. 그림자효과 : box-shadow: 0 4px 12px rgba(0,0,0,0.5)


 
## 5. css 내부적용 id  vs  class
1. id? 유일한 값
2. id 특징
- html 문서에서 한번만 사용가능
- 중복불가
- css에서 #id명
- 우선순위가 id와 class모두 있을때 id가 더 높음

3.class? 여러개 선택시
4. class 의 특징
- 재사용가능 : 여러요소에 class 지정
- 하나의 요소에 여러개의 class 사용가능
- css에서 .class명
- 반복스타일에 적합



## 6 배치요소
### 1. block vs inline
1) box model  
- 콘텐츠가 자리하는 영역을 의미하며, 박스의 구성 요소는 
   content(내용)  ,  padding , border , margin 로 이루어진다.

2) block 요소  
- width/height 설정이 (O/X): O  
- 앞뒤 줄바꿈이 (O/X): O  
- 대표 태그: div , p , h3

3) inline 요소  
- width/height 설정이 (O/X): X  
- 앞뒤 줄바꿈이 (O/X): X  
- 대표 태그: a, strong , span


### 2. 배치(1) - float
- 요소를 좌우로 배치할 때 사용하는 속성은  float 이다.  
- 다음 요소의 흐름을 정리하려면 clear속성을 사용한다.  
- float를 끊는 대표적인 방법은 클래스명으로  .clear 를 사용한다.
.clear{  clear:both ; }

### 3. 배치(2) - position
- 자식 요소를 부모 기준으로 위치시키려면 부모에  relative , 자식에 absolute를 설정한다.  
- 브라우저 전체 기준으로 고정하려면 fixed 속성을 사용한다.  
- position의 주요 값 4가지는  relative , absolute , fixed , static 이다.


### 4. 배치(3) - display

- 요소의 기본 속성을 바꾸려면 display 속성을 사용한다.  
- block 요소를 inline처럼 보이게 하려면 inline,  
  inline 요소를 block처럼 보이게 하려면 block 값을 사용한다.

Q1. block요소를 inline으로,    width X , 줄바꿈 X
ul.d1  li{ display:inline; }

Q2. block요소를 inline-block으로,  width O , 줄바꿈 X
ul.d2  li{ display:inline-block;  width:100px;}

Q3. inline을 block 요소로,  링크영역확대
a.github{  display:block;  width:100px; margin:auto; }

Q4. 왼쪽, 오른쪽으로 배치시  (float) 사용해야하며 float끊을때는 (clear:both) 
div.left{  width:20%;  float:left; }
div.right{ width:20%;  float:right;}
div.clear{ clear:both; }

Q5. .space를 기준으로  .astronaut 오른쪽상단(10px 10px) 가  배치
<div class="space">
	<div class="astronaut"></div>
</div>
.space{  position:relative;  }
.astronaut { position:absolute;  top:10px; right:10px; }

Q6. 화면고정위치 브라우저에 고정( 오른쪽0 , 아래쪽:10%)
.satellite{   position:fixed;  right:0; bottom:10%;}



### 5. 배치(4) - display  
- 요소의 기본 속성을 바꾸려면 `display` 속성을 사용한다.  
- block 요소를 inline처럼 보이게 하려면 `inline`,  
  inline 요소를 block처럼 보이게 하려면 `block` 값을 사용한다.  
- 여러 요소를 가로로 정렬하고 싶다면 `flex`를 사용한다.  
  → 부모 요소에 `display: flex`를 주면 자식 요소들이 한 줄에 나란히 배치된다.

.container {
  display: flex; /* 부모 요소를 flex 컨테이너로 설정 */

  flex-direction: row; /* 요소들을 가로 방향으로 배치 (기본값) */
  /* flex-direction: column; → 세로 방향으로 배치 */

  justify-content: center; /* 주축(가로) 정렬: 가운데 정렬 */
  /* 다른 값: flex-start, flex-end, space-between, space-around */

  align-items: center; /* 교차축(세로) 정렬: 가운데 정렬 */
  /* 다른 값: stretch, flex-start, flex-end */
} 





## 7.  bootstrap

1. bootstrap?
- 프론트엔드 프레임워크 , 
- HTML, CSS, Js들을 다이양 디자인요소들을 미리많들어 놓은 도구모음 

2. 템플릿
   1.  ctrl + shift + p
   2.  Configure Snippets - html
   3. 

   {
   "Bootstrap Template": {
      "prefix": "my",
      "body": [
         "<!DOCTYPE html>",
         "<html lang=\"ko\">",
         "<head>",
         "  <meta charset=\"UTF-8\">",
         "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">",
         "  <title>BOOTSTRAP</title>",
         "  <!-- Latest compiled and minified CSS -->",
         "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">",
         "",
         "  <!-- Latest compiled JavaScript -->",
         "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>",
         "</head>",
         "<body>",
         "  <!-- 여기에 콘텐츠를 추가하세요 -->",
         "</body>",
         "</html>"
      ],
      "description": "부트스트랩 5.3.3 기반 HTML 템플릿"
   }
   }


3. 그리드시스템
