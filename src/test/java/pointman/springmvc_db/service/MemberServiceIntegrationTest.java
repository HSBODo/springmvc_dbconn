package pointman.springmvc_db.service;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import pointman.springmvc_db.domain.Member;
import pointman.springmvc_db.reposirory.MemberRepository;
import pointman.springmvc_db.reposirory.MemoryMemberRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest //통합테스트
@Transactional //테스트 완료후 테스트 했던 데이터 rollback처리
class MemberServiceIntegrationTest {
    //테스트용도로는 필드 주입을 사용해 편하게 사용해도 된다.
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    //@Commit //테스트 종료후 DB커밋
    void 회원가입() {

        //given
        Member member = new Member();
        member.setName("홍길동");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("홍길동");
        Member member2 = new Member();
        member2.setName("홍길동");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//      1.방식
//        try {
//            memberService.join(member2);
//            System.out.println("테스트 실패");
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then

    }

    @Test
    void findMembers() {
        //given
        Member member1 = new Member();
        member1.setName("홍길동");
        Member member2 = new Member();
        member2.setName("임꺽정");
        //when
        memberService.join(member1);
        memberService.join(member2);
        List<Member> members = memberService.findMembers();
        //then
        assertThat(members.size()).isEqualTo(4);

    }

    @Test
    void findOne() {
        //given
        Member member1 = new Member();
        member1.setName("홍길동");

        //when
        memberService.join(member1);
        Member result = memberService.findOne(member1.getId()).get();

        //then
        assertThat(result.getName()).isEqualTo(member1.getName());
    }
}