package pointman.springmvc_db.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pointman.springmvc_db.service.MemberService;

@Controller //스프링 컨테이너에 bean으로 등록하여 관리하도록 설정 @Component 등록방식
public class MemberController {
    private  MemberService memberService;

//    @Autowired 의존성주입 방법1. 필드 주입방법  변경이 불가능해서 유연하지 못함 추천안함
//    private final MemberService memberService;

//    @Autowired 의존성주입 방법2. setter 주입방법 public하게 setter가 열려있어 어디서 호출 될지 모름 위험성 큼 추천안함
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    @Autowired  //의존성주입 방법3. 생성자 주입방법 가장 추천 유연하게 의존성을 바꿀 수 있음
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


}
