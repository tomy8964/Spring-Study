# [Spring] 스프링 핵심 원리 - 기본편

# 목차
1. [객체 지향 설계와 스프링](https://github.com/tomy8964/Spring-Study/blob/master/project/%EC%8A%A4%ED%94%84%EB%A7%81%20%ED%95%B5%EC%8B%AC%20%EC%9B%90%EB%A6%AC%20-%20%EA%B8%B0%EB%B3%B8%ED%8E%B8/1.%20%EA%B0%9D%EC%B2%B4%20%EC%A7%80%ED%96%A5%20%EC%84%A4%EA%B3%84%EC%99%80%20%EC%8A%A4%ED%94%84%EB%A7%81.md)
2. [스프링 핵심 원리 이해1 - 예제 만들기](https://github.com/tomy8964/Spring-Study/blob/master/project/%EC%8A%A4%ED%94%84%EB%A7%81%20%ED%95%B5%EC%8B%AC%20%EC%9B%90%EB%A6%AC%20-%20%EA%B8%B0%EB%B3%B8%ED%8E%B8/2.%20%EC%8A%A4%ED%94%84%EB%A7%81%20%ED%95%B5%EC%8B%AC%20%EC%9B%90%EB%A6%AC%20%EC%9D%B4%ED%95%B41%20-%20%EC%98%88%EC%A0%9C%20%EB%A7%8C%EB%93%A4%EA%B8%B0.md)
3. [스프링 핵심 원리 이해2 - 객체 지향 원리 적용](https://github.com/tomy8964/Spring-Study/blob/master/project/%EC%8A%A4%ED%94%84%EB%A7%81%20%ED%95%B5%EC%8B%AC%20%EC%9B%90%EB%A6%AC%20-%20%EA%B8%B0%EB%B3%B8%ED%8E%B8/3.%20%EC%8A%A4%ED%94%84%EB%A7%81%20%ED%95%B5%EC%8B%AC%20%EC%9B%90%EB%A6%AC%20%EC%9D%B4%ED%95%B42%20-%20%EA%B0%9D%EC%B2%B4%20%EC%A7%80%ED%96%A5%20%EC%9B%90%EB%A6%AC%20%EC%A0%81%EC%9A%A9.md)
4. [스프링 컨테이너와 스프링 빈](https://github.com/tomy8964/Spring-Study/blob/master/project/%EC%8A%A4%ED%94%84%EB%A7%81%20%ED%95%B5%EC%8B%AC%20%EC%9B%90%EB%A6%AC%20-%20%EA%B8%B0%EB%B3%B8%ED%8E%B8/4.%20%EC%8A%A4%ED%94%84%EB%A7%81%20%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88%EC%99%80%20%EC%8A%A4%ED%94%84%EB%A7%81%20%EB%B9%88.md)
5. [싱글톤 컨테이너](https://github.com/tomy8964/Spring-Study/blob/master/project/%EC%8A%A4%ED%94%84%EB%A7%81%20%ED%95%B5%EC%8B%AC%20%EC%9B%90%EB%A6%AC%20-%20%EA%B8%B0%EB%B3%B8%ED%8E%B8/5.%20%EC%8B%B1%EA%B8%80%ED%86%A4%20%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88.md)
6. [컴포넌트 스캔](https://github.com/tomy8964/Spring-Study/blob/master/project/%EC%8A%A4%ED%94%84%EB%A7%81%20%ED%95%B5%EC%8B%AC%20%EC%9B%90%EB%A6%AC%20-%20%EA%B8%B0%EB%B3%B8%ED%8E%B8/6.%20%EC%BB%B4%ED%8F%AC%EB%84%8C%ED%8A%B8%20%EC%8A%A4%EC%BA%94.md)
7. [의존관계 자동 주입](https://github.com/tomy8964/Spring-Study/blob/master/project/%EC%8A%A4%ED%94%84%EB%A7%81%20%ED%95%B5%EC%8B%AC%20%EC%9B%90%EB%A6%AC%20-%20%EA%B8%B0%EB%B3%B8%ED%8E%B8/7.%20%EC%9D%98%EC%A1%B4%EA%B4%80%EA%B3%84%20%EC%9E%90%EB%8F%99%20%EC%A3%BC%EC%9E%85.md)
8. [빈 생명주기 콜백](https://github.com/tomy8964/Spring-Study/blob/master/project/%EC%8A%A4%ED%94%84%EB%A7%81%20%ED%95%B5%EC%8B%AC%20%EC%9B%90%EB%A6%AC%20-%20%EA%B8%B0%EB%B3%B8%ED%8E%B8/8.%20%EB%B9%88%20%EC%83%9D%EB%AA%85%EC%A3%BC%EA%B8%B0%20%EC%BD%9C%EB%B0%B1.md)
9. [빈 스코프](https://github.com/tomy8964/Spring-Study/blob/master/project/%EC%8A%A4%ED%94%84%EB%A7%81%20%ED%95%B5%EC%8B%AC%20%EC%9B%90%EB%A6%AC%20-%20%EA%B8%B0%EB%B3%B8%ED%8E%B8/9.%20%EB%B9%88%20%EC%8A%A4%EC%BD%94%ED%94%84.md)


----
* 개발환경

  * IDE: IntelliJ
  * Spring Boot 2.7.6
  * JAVA 11
  * Gradle
  * Spring Web 
  * Thymeleaf
  * Spring Data Jpa
  * Thymeleaf
  * H2 1.4.200
  * Spring Boot Test
  * Tomcat
