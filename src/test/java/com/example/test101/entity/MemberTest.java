package com.example.test101.entity;

import com.example.test101.constant.Role;
import com.example.test101.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
 public class MemberTest {
@Autowired
    MemberRepository memberRepository;

@PersistenceContext
    EntityManager em;
@Test
    @DisplayName("auditing test")
    @WithMockUser(username =  "gildong", roles = "USER")
    public void auditingTest(){
    Member newMember = new Member();
    newMember.setEmail("aaa@b.com");
    newMember.setMemberid("allice");
    newMember.setName("gildong");
    newMember.setPassword("234234");
    newMember.setRole(Role.USER);
    memberRepository.save(newMember);

    em.flush();
    em.clear();

    Member member = memberRepository.findById(newMember.getId())
            .orElseThrow(EntityNotFoundException::new);
    System.out.println("regiter time: " + member.getRegTime());
    System.out.println("update time: " + member.getUpdateTime());
    System.out.println("create member: " + member.getCreatedBy());
    System.out.println("modify member: " + member.getModifiedBy());

}
}