package pointman.springmvc_db.reposirory;

import org.springframework.data.jpa.repository.JpaRepository;
import pointman.springmvc_db.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {

    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
