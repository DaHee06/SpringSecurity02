package com.example.spring_security_02.member.Service;

import com.example.spring_security_02.member.Repository.MemberRepository;
import com.example.spring_security_02.member.entity.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberRepository {

    private MemberRepository memberRepository;

    @Override
    public Long join(Member member){
       Member member = Member.builder()
    }
}
