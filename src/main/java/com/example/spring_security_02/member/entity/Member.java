package com.example.spring_security_02.member.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    private String loginId;

    @Column
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

}
