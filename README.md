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
