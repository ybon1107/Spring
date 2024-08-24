# Github 레포지토리 운영 기본 방법
=============
명령어
-------------

>  현재 경로를 git이 추적할 수 있도록 초기화하는 작업
  ```
  git init
  ```

>  원격 저장소 추가
  ```
   git remote add "별칭" "git 주소.git" //향후 push or pull 작업을 진행할 때 "별칭"으로 지정한 원격 저장소에 접근할 수 있음. git clone시 default 별칭은 origin
   git remote -v //연결된 원격저장소 목록 조회
  ```

> 원격 저장소 데이터 로컬 저장소로 가져오기
  ```
  git fetch "별칭" "브랜치명" // 로컬에는 없지만, 원격 저장소에는 있는 데이터를 가져오며 자동으로 Merge 되지 않음
  git pull "별칭" "브랜치명" // 이미 로컬에 존재하는 Git 저장소에 원격 저장소의 최신 변경사항을 가져오고 병합. 원격 저장소에 새로운 커밋이 추가되었을 때, 그 변경사항을 현재 로컬 저장소에 반영(git fetch와 git merge의 조합)
  git clone "git 주소.git" // 원격 저장소의 전체 복사본을 로컬에 새로 만드는 작업으로 새로운 디렉토리가 생성되며 그 안에 원격 저장소의 모든 파일과 폴더, 그리고 모든 커밋 히스토리가 포함됨. 일반적으로 저장소를 처음 시작할 때 사용
  ```

> git branch 관리
  ```
  git checkout -b "브랜치명" // git branch 생성
  git switch -c "브랜치명" // 선택한 branch로 이동
  git branch // git branch 생성 확인
  ``

> 로컬 작업 원격 저장소로 보내기
  ```
  git status // 변경 사항 추적(스테이징된 파일 및 스테이징되지 않은 파일 그리고 깃 추적이 되지 않은 파일)
  git add "파일이름 또는 경로" // 스테이징에 변경 사항 저장
  git commit -m "커밋 메세지" // 본인이 수정한 사항들에 대한 기록 남기며 깃 저장소에 넘기기 직전 단계
  git push "별칭" "브랜치명" // 선택한 원격저장소 그리고 branch에 변경 사항들 저장
  ``` 



오류 발생에 대한 대응
-------------


* * *
# Spring 프로젝트 목록
* board: java Spring + jsp 기반 게시판 template
* boardapi: api 연결 template
* security: Spring security 활용 template

1. board
2. boardapi
3. security
