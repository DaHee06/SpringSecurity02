package com.example.spring_security_02.security.auth;

import com.example.spring_security_02.member.Repository.MemberRepository;
import com.example.spring_security_02.member.entity.Member;
import com.example.springsecurity.dto.AddUserRequest;
import com.example.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final MemberRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(Member member) {
        return userRepository.save(member.builder()
                .email(member.getEmail())
                //패스워드 암호화
                .password(bCryptPasswordEncoder.encode(member.getPassword()))
                .build()).getId();
    }
}
