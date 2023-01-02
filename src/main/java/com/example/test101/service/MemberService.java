package com.example.test101.service;

import com.example.test101.entity.Member;
import com.example.test101.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final Map<String, Member> userRegistry = new HashMap<>();
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

    @Override
    public UserDetails loadUserByUsername(String memberid) throws
        UsernameNotFoundException {
            Member member = memberRepository.findByMemberid(memberid);

            if(member == null){
                throw new UsernameNotFoundException(memberid);
            }

            return User.builder()
                    .username(member.getMemberid())
                    .password(member.getPassword())
                    .roles(member.getRole().toString())
                    .build();
    }
}
