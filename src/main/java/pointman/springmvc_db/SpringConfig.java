package pointman.springmvc_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pointman.springmvc_db.reposirory.*;
import pointman.springmvc_db.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

//수동 bean 등록 방법

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    private EntityManager em;


    //스프링 부트는 DataSource를 스프링 빈으로 자동 등록해준다.
    //자동 등록되는 스프링 빈의 이름은 dataSource다.
    //스프링 부트는 EntityManager를 스프링 빈으로 자동 등록해준다.
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return  new JdbcTemplateMemberRepository(dataSource);
        return  new JpaMemberRepository(em);
    }
}
