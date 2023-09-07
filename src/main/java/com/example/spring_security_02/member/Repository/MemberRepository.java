package com.example.spring_security_02.member.Repository;

import com.example.spring_security_02.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByLoginId(String username);

    Long join(Member member);
}
