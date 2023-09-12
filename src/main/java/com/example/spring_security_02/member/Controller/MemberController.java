package com.example.spring_security_02.member.Controller;

import com.example.spring_security_02.member.Service.MemberService;
import com.example.spring_security_02.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ResponseBody : 문자열 그대로 return , 안쓰면 페이지로 이동 -> 안썼을때 OK.jsp, OK.html
 */
@RequiredArgsConstructor
@Controller
@ResponseBody
@RequestMapping("/member")
public class MemberController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final MemberService memberService;

    @PostMapping("/join")
    public String join(@RequestBody Member member){
        try{
            memberService.registerNewMember(member);
            return "ok";
        }catch(Exception e){
            log.error("============================ 회원 가입 에러 : " + e.getMessage());
            return "fail";
        }
    }

}
