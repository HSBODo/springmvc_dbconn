package pointman.springmvc_db.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pointman.springmvc_db.domain.Member;
import pointman.springmvc_db.service.MemberService;

import java.util.List;

@Slf4j
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


    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(Member member){
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);

        return "members/memberList";
    }

}
