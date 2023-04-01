package pointman.springmvc_db.repository;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import pointman.springmvc_db.domain.Member;
import pointman.springmvc_db.reposirory.MemberRepository;
import pointman.springmvc_db.reposirory.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  //테스트 메서드가 끝날 때마다 호출
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("홍길동");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("홍길동");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("임꺽정");
        repository.save(member2);

        Member result = repository.findByName("홍길동").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findById() {
        Member member1 = new Member();
        member1.setName("홍길동");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("임꺽정");
        repository.save(member2);

        Member result = repository.findById(1L).get();

        assertThat(result).isEqualTo(member1);
    }

    @Test

    public void findAll() {
        Member member1 = new Member();
        member1.setName("홍길동");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("임꺽정");
        repository.save(member2);


        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);


    }
}
