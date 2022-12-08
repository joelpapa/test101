package com.example.test101.service;

import com.example.test101.entity.Member;
import com.example.test101.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member save(Member member){
        validateDup(member);
        return memberRepository.save(member);
    }

    private void validateDup(Member member){
        Member findMember = memberRepository.findByMemberid(member.getMemberid());
        if(findMember != null) {
            throw new IllegalStateException("이미 존재하는 아이디");

        }
        findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null) {
            throw new IllegalStateException("이미 존재하는 email");
        }
    }
}
