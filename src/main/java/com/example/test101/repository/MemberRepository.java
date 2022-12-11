package com.example.test101.repository;

import com.example.test101.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByMemberid(String memberid);
    Member findByEmail(String email);

}
