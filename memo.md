책 정리


Ch1. IntelliJ에서 spring boot 시작하기
- 툴박스: 앱젯브레인 제품 관리
- 인텔리제이 설치 및 사용법
- mavenCentral, jcenter 비교
- 스프링부트 프로젝트와 그레이들 연동 방법 (`.gradle` 파일에서 의존성 입)
- 인텔리제이에서 깃허브 사용 방법

Ch2. spring boot에서 테스트 코드 작성하
- 패키지명: 주로 url을 반대로


 
Ch3. sprint boot에서 JPA로 데이터베이스를 다뤄보자
1. JPA 소개   
    1)문제점   
    - SQL의 문제 : 테이블의 몇 배 의 SQL을 생성 및 유지보수 해야함. 단순 반복 작업
    - 패러다임 불일치 : RDB; 데이터 저장 기술, OOP; 기능과 속성을 한곳에서 관리하는 기술
JPA: 자바 표준 명세서
Sprint Data JPA: JPA 구현체

# 테스트 코드 설명
package
- web: 컨트롤러 관련 클래스 포함
- dto: 응답 dto 관련 클래스 포함
- domain: 도메인(게시글, 댓글 등 SW 요구사항 혹은 문제 영역)을 담은 패키지
 