package pointman.springmvc_db.service;

import pointman.springmvc_db.domain.Member;
import pointman.springmvc_db.reposirory.MemberRepository;
import pointman.springmvc_db.reposirory.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private  final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복회원은 가입 안된다(요구사항)
        validateDuplicateMember(member); //회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();

    }
    /**
     * 회원 ID조회
     */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m->{
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }
}
