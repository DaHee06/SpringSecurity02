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

    @Builder
    public Member(String name, String email, String password, MemberRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = String.valueOf(role);
    }

    public static Member createMember(Member member, PasswordEncoder passwordEncoder) {
        Member member = Member.builder()
                .name(member.getName())
                .email(member.getEmail())
                .password(passwordEncoder.encode(member.getPassword()))  //암호화처리
                .role(MemberRole.USER)
                .build();
        return member;
    }

}
