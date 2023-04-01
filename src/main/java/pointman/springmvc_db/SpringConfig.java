package pointman.springmvc_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pointman.springmvc_db.aop.TimeTraceAop;
import pointman.springmvc_db.reposirory.*;
import pointman.springmvc_db.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

//수동 bean 등록 방법

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    private EntityManager em;
    private MemberRepository memberRepository;





    public SpringConfig(DataSource dataSource, EntityManager em, MemberRepository memberRepository) {
        this.dataSource = dataSource;       //스프링 부트는 DataSource를 스프링 빈으로 자동 등록해준다.
                                            //자동 등록되는 스프링 빈의 이름은 dataSource다.
        this.em = em;                       //스프링 부트는 JPA EntityManager를 스프링 빈으로 자동 등록해준다.
        this.memberRepository = memberRepository; // springDataJpa 사용시 JpaRepository 인터페이스를 자동으로 구현체를 만들어 주입
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
        //return new MemberService(memberRepository());
    }
//    @Bean
//    public MemberRepository memberRepository(){
//        //return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return  new JdbcTemplateMemberRepository(dataSource);
//        //return  new JpaMemberRepository(em);
//    }

//  AOP 수동 bean 등록
//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }
}
