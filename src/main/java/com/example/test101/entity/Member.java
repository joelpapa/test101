package com.example.test101.entity;

import com.example.test101.constant.Role;
import com.example.test101.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Setter
@ToString

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String memberid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;


    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String mobile;

    public static Member createMember(MemberFormDto memberFormDto,
                                      PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setMemberid(memberFormDto.getMemberid());
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setMobile(memberFormDto.getMobile());
        String pwd = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(memberFormDto.getPassword());
        member.setRole(Role.USER);
        return member;

    }


}
