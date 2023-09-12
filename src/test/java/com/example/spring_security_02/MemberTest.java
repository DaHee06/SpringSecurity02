package com.example.spring_security_02;

import com.example.spring_security_02.member.Repository.MemberRepository;
import com.example.spring_security_02.member.Service.MemberService;
import com.example.spring_security_02.member.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    //MemberRepository - save 테스트 진행
    @Test
    @DisplayName("save 테스트 진행")
    public void saveMemberTest(){
        Member member = Member.builder().name("테스트").email("1234@naver.com").password("1234").role("USER").build();

        memberRepository.save(member);

        Assertions.assertEquals(member.getEmail(), "1234@naver.com");


    }
}
