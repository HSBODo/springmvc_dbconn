package pointman.springmvc_db.reposirory;

import pointman.springmvc_db.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save (Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String  name);
    List<Member> findAll();
}
