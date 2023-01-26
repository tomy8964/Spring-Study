# 회원 관리 예제 - 웹 MVC 개발  

-----

#### 회원 웹 기능 - 홈 화면 추가
```java
@Controller
public class HomeController {
     @GetMapping("/")
     public String home() {
        return "home";
     }
}
```
```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
    <body>
        <div class="container">
             <div>
                <h1>Hello Spring</h1>
                <p>회원 기능</p>
                <p>
                    <a href="/members/new">회원 가입</a>
                    <a href="/members">회원 목록</a>
                </p>
             </div>
        </div> <!-- /container -->
    </body>
</html>
```
*  참고: 컨트롤러가 정적 파일보다 우선순위가 높다.
#### 회원 웹 기능 - 등록
##### 회원 등록 폼 개발
```java
@Controller
public class MemberController {
     private final MemberService memberService;
     
     @Autowired
     public MemberController(MemberService memberService) {
        this.memberService = memberService;
     }
     
     @GetMapping(value = "/members/new")
     public String createForm() {
        return "members/createMemberForm";
     }
}
```
```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<body>
    <div class="container">
     <form action="/members/new" method="post">
         <div class="form-group">
             <label for="name">이름</label>
             <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
         </div>
     <button type="submit">등록</button>
     </form>
    </div> <!-- /container -->
</body>
</html>
```
##### 회원 컨트롤러에서 회원을 실제 등록하는 기능
```java
@PostMapping(value = "/members/new")
public String create(MemberForm form){
        Member member=new Member();
        member.setName(form.getName());
        memberService.join(member);

        return"redirect:/";
        }
```
#### 회원 웹 기능 - 조회


----  

###### References: 김영한 - [스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술]





