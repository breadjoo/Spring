# Spring Day 1

### 문제 1: @RunWith 어노테이션 이 안되는 문제<br>
-> Spring, JUnit의 의존성 추가
maven 사용시, gradle 사용시 의 차이점을 배움.<br>
maven에서 의존성 추가하는 방법 : pom.xml 파일에 들어가서 <dependencies> 안에
   <dependency> 를 추가해야한다.<br><br>

gradle에서 의존성 추가하는 방법 :<br>
    // Spring Test<br>
    testImplementation 'org.springframework:spring-test:5.3.23' // 사용 중인 Spring 버전에 맞게 수정<br>
    // JUnit<br>
    testImplementation 'junit:junit:4.13.2'<br>
방식의 차이 내용은 잘 찾아서 퍼와야한다.<br>


### 문제2: Log4j 어노테이션 관련 오류<br>
@RunWith와 마찬가지로 의존성 추가가 필요함<br>
현재 xml을 이용하고 있으므로 위에서 했던 방식과 비슷하게<br>
pom.xml 에 들어가서    <dependency> 를 추가해야한다.<br><br>
또한 Lombok 라이브러리를 추가해둬야하고, lombok의 의존성도 추가해주어야 한다.



### 문제3: bean이 제대로 등록되지 않는 경우<br>
@component @RequiredArgsConstructor 등 어노테이션을 달아야 하고,<br>
'root-context.xml'파일에서 스캔패키지 설정을 확인해야 한다.<br>
<context:component-scan base-package="com.myspring.sample" /><br>
방식으로 ""안에는 해당 패키지명을 집어넣어야 검색을 해준다.<br>
lombok설치를 잘 해두어야 함, @autowired보다 훨씬 테스트에 용이하고 불변성을 유지하며<br>
코드의간결함, 실시간피드백 등을 받을 수 있다.




### 문제4: http://localhost:8080/ 에 들어갔을 때 한글이 깨져나와서 패치하는 방법<br>
web.xml과 server.xml 두가지 다 변경해야함<br>
web.xml - > utf-8로 설정하는 <filter>를 source에 추가해야함. <br>
server.xml -> source에 sonnector가 있는데 URIEncoding="UTF-8" 을 추가해야함<br>


# Spring Day 2

오류천국 Spring이었다.

### 문제 1 : mysql 연동안됨
package com.myspring.test1 -> JDBCTest 클래스에서 Test코드로 연동을 시도했다. <br>
오류내용 : java.sql.SQLException: The server time zone value <br>
"jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",<br>
test(db이름) 뒤로 serverTimeZone을 설정해주니 해결되었다. <Br>
mysql 5.0이상 버젼에서 일어날 수 있는 오류라고 하는데, 왜 일어나는건진 잘 모르겟다 ㅠㅠ <Br>

### 문제 2 : Log4j가 또 안됨
이번에는 어제와 다르게 console에서 찍히지 않았다.  <Br>
VSCode에서 해보려고 spring boot를 깔았었는데, spring boot3.1버젼 이상에서는 오류를 찍어주는 등급이 달라진다고 한다. <Br>
>>스프링 부트 3.1 부터 기본 로그 레벨을 INFO로 빠르게 설정하기 때문에 로그를 확인할 수 없는데,기본 로그 레벨을 DEBUG로 설정해서 로그를 확인할 수 있다.<<
<br>로그 레벨 순서 : ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF <br>
이 문제가 있었고, <br>
runtime을 지우는 방법도 사용했다. dependency는 각각의 scope를 가지고 그 중 runtime의 경우 <br>
의존관계가 컴파일시 필요하지 않지만, 실행시 필요함을 의미, 실행시 테스트 클래스패스에 속하지만 컴파일 클래스패스에는 속하지 않는다고 함.<br>
그래서 test에서 할 때는 잘 됐는데 main 클래스에서 할때는 안됐던것인가 싶기도 하다.<br>
하지만 정확히는 알아내지 못했고, runtime을 지워야 웬만하면 작동한다는 식으로 이해해버렸다. <br>

#### 요약
Maven Dependencies에서 log4j에 불이 안들어오는것은 모든 runtime을 다 지워버리고 해결되었고,<br>
parameter값을 안주면 안줬다고 반응하고, 값을 제대로 줘도 log가 안찍히는 지옥에서는 resource클래스 안에 <br>
logback.xml 을 만들고 log4j.xml의 info로 되어있던 레벨을 전부 debug로 바꾸고 해결되었다.<br>
하지만 너무 많은 debug가 뜨는것은 아직 불편하다.ㅜㅜ

# Spring Day 3

어제 오류가 많이뜬 만큼 찾아보고 알게된것이 많아서 오늘은 수월했다.

### 문제 1 : mybatis 연동 ( url 오류 )

어제와 같이 시간설정을 하는데 있어서 값을 줄 때 그냥 복사 붙여넣기를 했는데 안됐다. <br>
xml 파일에서 value값 " " 에 &를 넣을 땐 &amp; 를 붙여주어야 작동했다.<br>
