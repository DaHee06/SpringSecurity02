package com.example.spring_security_02.member.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private String role;

    @Column
    private String name;

    @Column(name = "pwd")
    private String password;

    @Column
    private String email;

    @Column
    private String isUsed;

    @Column
    private String isDel;

    @Column
    private LocalDateTime regDt;

    @Column
    private LocalDateTime updDt;

    //빌더 패턴 사용 : 어느 필드에 들어가는 값이 어떤 것인지 파악하기 쉽다. 어느 필드에 어느 값이 매칭되는지 바로 보이며 객체 생성 코드의 가독성을 높일 수 있다.
    //@Builder 애너테이션 사용시 빌더 패턴을 사용하기 위한 코드를 자동으로 생성하므로 간편하게 빌더 패컨 객체를 만들 수 있다.
    @Builder
    public Member(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

//    public static Member createMember(Member member, PasswordEncoder passwordEncoder) {
//        Member member = Member.builder()
//                .name(member.getName())
//                .email(member.getEmail())
//                .password(passwordEncoder.encode(member.getPassword()))  //암호화처리
//                .role(MemberRole.USER)
//                .build();
//        return member;
//    }

}
