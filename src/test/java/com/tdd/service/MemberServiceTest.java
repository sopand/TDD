package com.tdd.service;

import com.tdd.dto.MemberRequest;
import com.tdd.dto.MemberResponse;
import com.tdd.entity.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void createMember(){
        //given
        MemberRequest member=new MemberRequest();
        String email="d";
        String pwd="d";
        member.setEmail(email);
        member.setPwd(pwd);
        //when
        MemberService service=new MemberService(memberRepository);
        MemberResponse memberResponse=service.createMember(member);
        //then
        assertEquals(member.getEmail(),memberResponse.getEmail());
        assertEquals(member.getPwd(),memberResponse.getPwd());

    }
}