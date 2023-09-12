package com.example.spring_security_02.member.Repository;

import com.example.spring_security_02.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 기능 구현
 * CRUD를 처리하기 위한 공통 메서드는 스프링 데이터 JPA가 제공하는 JpaRepository 인터페이스에 존재
 */

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
     Optional<Member> findByEmail(String Email);

}
