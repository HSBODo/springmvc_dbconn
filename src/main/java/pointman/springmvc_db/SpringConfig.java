package pointman.springmvc_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pointman.springmvc_db.reposirory.JdbcMemberRepository;
import pointman.springmvc_db.reposirory.MemberRepository;
import pointman.springmvc_db.reposirory.MemoryMemberRepository;
import pointman.springmvc_db.service.MemberService;

import javax.sql.DataSource;

//수동 bean 등록 방법

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
