package com.example.spring_security_02;

import com.example.spring_security_02.member.Service.MemberService;
import com.example.spring_security_02.member.entity.Member;
import com.example.spring_security_02.security.auth.CustomUserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    CustomUserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember() {
        Member member = member.builder()
                .email("test@email.com")
                .name("테스트")
                .password("1111")
                .role("ROLE_USER")
                .build();
        return Member.createMember(member, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest() {
        Member member = createMember();
        Member savedMember = memberService.registerNewMember(member);

        assertEquals(member.getEmail(), savedMember.getEmail());
    }


}
