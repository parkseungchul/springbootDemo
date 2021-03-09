# demo001
1. JPA
2. log-back.xml
3. JPA 기반의 EMP, DEPT 테이블을 이용하여 CRUD
4. JUnit 을 이용한 CRUD Test, Assert 를 이용한 결과 체크
TODO
- Table에 PK가 두 개 이상일 경우
- LOB 타입 추가
- DB Table 날짜 자동 업데이트 방법
<code><pre>docker run -d --name mariaDB \
  -e MYSQL_DATABASE=demo \
  -e MYSQL_USER=user01 \
  -e MYSQL_PASSWORD=user01 \
  -e MYSQL_ROOT_PASSWORD=password \
  -p 13306:3306 \
  -v /app/maria:/var/lib/mysql \
  mariadb</pre></code>
  
# demo002
1. Thymeleaf 기반  Layout 개발
2. Single, Multiple 화면 표준 개발
3. Spring Initialization 클래스 구현
TODO
- 세션 값 표현하기
- get, post junit 만들기 

# demo003
1. Spring Security 적용
- 아이디/패스워드
  member/member
  manager/manager
  admin/admin
2. JWT token 적용
- 윈도우 cmd창 UTF-8 설정: chcp 65001
- 테스트 방법
  curl -i -d "username=admin&password=admin" -X POST http://localhost:8080/loginAction
  curl -X POST -H "Authorization: ${token}" http://localhost:8080/api/test
3. Redis 적용 
   sudo docker run -d --name redis_c1 -p 6379:6379 redis redis-server --appendonly yes
4. 스프링 시큐리티  + 레디스 설정 OK

# demo004 
1. SpringBoot in Mybatis (2개의 데이터 소스)
2. 기존의 디비에 스키마 추가
<code><pre>docker exec -it mariaDB bash
mysql -u root -p 
create schema demo2;
grant all privileges on demo2.* to 'user01'@'%';</pre></code>
3. 트랜잭션 테스트

# demo0041 
1. SpringBoot in JPA (2개의 데이터 소스)
2. 기존의 디비에 스키마 추가
   <code><pre>docker exec -it mariaDB bash
   mysql -u root -p
   create schema demo2;
   grant all privileges on demo2.* to 'user01'@'%';</pre></code>
3. 트랜잭션 테스트

# demo0042 
1. 이 기종 트랜잭션 JPA, Mybatis, oracle , mariadb
<code><pre>docker run -d -p 1521:1521 --name ora11g parkseungchul/db:ora11g
sqlplus system/oracle   
create user user01 identified  by user01;
grant connect, resource, dba to user01;</pre></code>