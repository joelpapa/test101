package com.example.test101.service;

import com.example.test101.dto.MemberFormDto;
import com.example.test101.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember(){
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setMemberid("jpop001");
        memberFormDto.setName("정영민");
        memberFormDto.setEmail("jung.youngmin@gmail.com");
        memberFormDto.setMemberid("010-3767-0327");
        memberFormDto.setPassword("123123123");
        return Member.createMember(memberFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("회워가입테스트")
    public void saveMemberTest(){
        Member member = createMember();
        Member savedMember = memberService.save(member);
        assertEquals(member.getEmail(), savedMember.getEmail());
        assertEquals(member.getMemberid(), savedMember.getMemberid());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getPassword(), savedMember.getPassword());
        assertEquals(member.getRole(), savedMember.getRole());
    }
}