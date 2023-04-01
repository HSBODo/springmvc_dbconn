package pointman.springmvc_db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pointman.springmvc_db.reposirory.MemberRepository;
import pointman.springmvc_db.reposirory.MemoryMemberRepository;
import pointman.springmvc_db.service.MemberService;

//수동 bean 등록 방법

//@Configuration
//public class SpringConfig {
//
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
//}
