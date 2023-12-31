package com.example.spring_security_02.member.Service;

import com.example.spring_security_02.member.Repository.MemberRepository;
import com.example.spring_security_02.member.entity.Member;
import com.example.spring_security_02.security.auth.CustomUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * @param member
     * 회원가입시 중복 여부를 확인 후 Member 엔티티와 User(Security)를 위한 엔티티에 저장한다.
     */
    public void registerNewMember(Member member) {

        validateDuplicateMember(member);

        // Member 엔티티에 회원 정보 저장
        // password Encoder 추가 --> 날짜 추가
        try {
            memberRepository.save(member.builder()
                    .name(member.getName())
                    .password(bCryptPasswordEncoder.encode(member.getPassword()))
                    .email(member.getEmail())
                    .role(member.getRole())
                    .build()).getId();
        }catch(Exception e){
            log.error("memberService 회원 가입 중 에러 발생 : " + e.getMessage());
        }

        // UserDetailsService를 통해 사용자 정보를 로드
//        UserDetails userDetails = userDetailsService.loadUserByUsername(member.getEmail());
        // userDetails 객체를 활용하여 추가 작업을 수행할 수 있음

    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember.isPresent()) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }



}
