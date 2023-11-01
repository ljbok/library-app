## library-app
- simple library system application
<br>

## domain
- http://www.library-system.site:8090/v1/index.html

## 프로젝트 소개
- 프로젝트 유형 : 개인 프로젝트, 참조 프로젝트, Back-End
- 참조 출처 : 인프런 
- 프로젝트 명 : Library-app / library-system
- 소개 : 사용자와 도서 등록 후 도서 반납과 대를 기능 제공
<br>

## 🕰️ 개발 소요 기간
- 사전 "학습" 및 설계, 프로젝트 구성, 배포 등 모든 과정 포함하여 약 1~2주 소요
 <br>
 
## 📌  전체 기능 구성
- **(1) 사용자 명, 나이로 사용자 정보 등록**
- **(2) 사용자 명 수정, 사용자 정보 수정 (1),(2) ==> 기본 CRUD 기능 구성**
- **(3) 도서명으로 도서 정보 등록**
- **(4) 사용자 번호와 도서 번호로 대출 및 반납 기능 구성**
<br>

## ⚙️ 개발 환경
- `Java 11`
- `JDK 11`
- **IDE** : 'IntelliJ(2023.2.3)1'
- **Framework** : 'Spring Boot(2.7.6)'
- **Database** : 'MySQL(8)'
- **ORM** : 'Gradle'
- **build tool** : 'Maven'
- **cloud & Web Hosting** : AWS, Gabia
<br>

## 파일 구성
```
📦 
├─ .DS_Store
├─ .gitignore
├─ HELP.md
├─ build.gradle
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
├─ settings.gradle
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ com
   │  │     └─ group
   │  │        └─ libraryapp
   │  │           ├─ LibraryAppApplication.java
   │  │           ├─ config
   │  │           │  └─ UserConfiguration.java
   │  │           ├─ controller
   │  │           │  ├─ book
   │  │           │  │  └─ BookController.java
   │  │           │  ├─ calculator
   │  │           │  │  └─ CalculatorController.java
   │  │           │  └─ user
   │  │           │     └─ UserController.java
   │  │           ├─ domain
   │  │           │  ├─ book
   │  │           │  │  ├─ Book.java
   │  │           │  │  └─ BookRepository.java
   │  │           │  └─ user
   │  │           │     ├─ User.java
   │  │           │     ├─ UserRepository.java
   │  │           │     └─ loanhistory
   │  │           │        ├─ UserLoanHistory.java
   │  │           │        └─ UserLoanHistoryRepository.java
   │  │           ├─ dto
   │  │           │  ├─ book
   │  │           │  │  └─ request
   │  │           │  │     ├─ BookCreateRequest.java
   │  │           │  │     ├─ BookLoanRequest.java
   │  │           │  │     └─ BookReturnRequest.java
   │  │           │  ├─ calculator
   │  │           │  │  └─ request
   │  │           │  │     ├─ CalculatorAddRequest.java
   │  │           │  │     └─ CalculatorMultiplyRequest.java
   │  │           │  └─ user
   │  │           │     ├─ request
   │  │           │     │  ├─ UserCreateRequest.java
   │  │           │     │  └─ UserUpdateRequest.java
   │  │           │     └─ response
   │  │           │        └─ UserResponse.java
   │  │           ├─ repository
   │  │           │  └─ user
   │  │           │     └─ UserJdbcRepository.java
   │  │           └─ service
   │  │              ├─ book
   │  │              │  └─ BookService.java
   │  │              └─ user
   │  │                 ├─ UserServiceV1.java
   │  │                 └─ UserServiceV2.java
   │  └─ resources
   │     ├─ application.yml
   │     └─ static
   │        ├─ .DS_Store
   │        └─ v1
   │           ├─ asset-manifest.json
   │           ├─ favicon.ico
   │           ├─ index.html
   │           ├─ logo192.png
   │           ├─ logo512.png
   │           ├─ manifest.json
   │           ├─ robots.txt
   │           └─ static
   │              ├─ css
   │              │  ├─ main.101cd0fe.css
   │              │  └─ main.101cd0fe.css.map
   │              ├─ js
   │              │  ├─ 787.61591191.chunk.js
   │              │  ├─ 787.61591191.chunk.js.map
   │              │  ├─ main.d4f24480.js
   │              │  ├─ main.d4f24480.js.LICENSE.txt
   │              │  └─ main.d4f24480.js.map
   │              └─ media
   │                 ├─ NanumSquareOTF_acR.f257b7932f7dfa5253fb.otf
   │                 ├─ book.e8aa0938ac8e06f50fb001ec8b292cbe.svg
   │                 ├─ borrow.cd6f2db9966e32ef9a1dc7364cf5ce09.svg
   │                 ├─ return.748530e2bb541a89000a913a50a9ec5a.svg
   │                 └─ user.8f52d9d1a7c82e3952a33a270e97bf20.svg
   └─ test
      └─ java
         └─ com
            └─ group
               └─ libraryapp
                  └─ LibraryAppApplicationTests.java
```

<br>

## 파일 설명
- Dto
  └─ request :사용자로 Body로 받을 객체
  └─ reponse : 사용자에게 JSON 타입으로 전달할 객체
- Controlelr
  └─ HTTP 요청에 따라 매핑을 진행
- Service
  └─ Repository 객체를 생성해서 매개변수를 전달하여 데이터 처리를 진행할 Class
- Entity - domain
  └─  Repository Class에서 JPA로 Data 연산을 진행할 때 SQL 테이블과 연동될 객체
- Repository
  └─ JpaRepository를 상속받아 Service 또는 Entity로부터 매개변수를 전달받아 DB에 Data CRUD 작업을 수행할 Class
- LibraryAppApplication.java
  └─ 서버 시작을 위해 실행될 Class

