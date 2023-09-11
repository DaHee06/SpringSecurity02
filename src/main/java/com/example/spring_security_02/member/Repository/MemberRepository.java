package com.example.spring_security_02.member.Repository;

import com.example.spring_security_02.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 기능 구현
 * 1.회원가입
 * 2.로그인 / 아이디,비번 찾기
 * 3.권한 페이지 이동
 * 4.회원 탈퇴
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Object save(Member member);
    Optional<Member> findByEmail(String username);

    List<Member> findAll();

}
