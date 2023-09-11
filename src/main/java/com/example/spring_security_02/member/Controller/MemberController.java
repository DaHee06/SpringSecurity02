package com.example.spring_security_02.member.Controller;

import com.example.spring_security_02.member.Service.MemberService;
import com.example.spring_security_02.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/member")
public class MemberController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final MemberService memberService;

    @PostMapping("/join")
    public String join(@RequestBody Member member){
        try{
            memberService.registerNewMember(member);
            return "ok";
        }catch(Exception e){
            return "fail";
//            log.error("============================ 회원 가입 에러 : " + e.getMessage());
        }
    }

}
