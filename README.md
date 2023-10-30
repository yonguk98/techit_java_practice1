# techit_java_practice

### 231024 techit 백엔드 스쿨 미션3 

시간 : 13:00 ~ 16:00

#### 명령어 
- 등록 : 명언과 작가 입력 및 저장
- 수정 : 수정?id=1 형식으로 명령어 입력 및 수정 내용 입력
- 삭제 : 삭제?id=1 형식으로 명령어 입력 후 자동삭제
- 종료 : 작성된 명언들을 자동으로 json 형식의 파일로 저장



#### 231026 수정사항
- mvc 패턴 적용
  - service : controller에서 사용할 입력데이터 확인 및 저장하는 주요 함수 존재.
  - repository : 해쉬맵 형태로 데이터를 저장 후 프로그램이 종료되면 save.json 파일에 내용 저장
  - model : 명언의 주요 값을 담는 Say class 생성. 명령어의 확장성을 고려해 열거형 Command 클래스 생성
  - view : 수정중
  - controller : 사용자의 입력을 받고 해당 명령에 맞는 SayService의 함수 실행
- 잘못된 형식의 입력값에 대한 반응 추가
- Main class와 App class 분리
- App class에서 주요 인스턴스 관리 및 의존성 주입 

#### 231027 수정사항
- mysql연결 및 hashmap을 이용한 저장방식과 jdbc를 이용한 방식의 파일 분리

#### 231030 수정사항
- github flow 적용 시작, 이슈 생성, 브랜치 구분
- JdbcSayRepository 개발부터 TDD 적용 시작
  - e/1 branch 생성