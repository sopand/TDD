package com.tdd.service;

import com.tdd.dto.MemberRequest;
import com.tdd.dto.MemberResponse;
import com.tdd.entity.Member;
import com.tdd.entity.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Transactional
@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
    //Mock = 익명 클래스 느낌( 가짜 객체 생성 )
    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;


    @Test
    public void createMember(){
        //given
        MemberRequest member=new MemberRequest();
        member.setEmail("d");
        member.setPwd("d");
        //stub ( 행동 정의 )
        when(memberRepository.save(any())).thenReturn(member.memberEntity());
        //when
        MemberResponse memberResponse=memberService.createMember(member);
        //then
        assertThat(member.getEmail()).isEqualTo(memberResponse.getEmail());
        assertThat(member.getPwd()).isEqualTo(memberResponse.getPwd());
    }

    @Test
    public void findMember(){
        //given
        Long id=1L;
        //stub
        Optional<Member> memberOP=Optional.of(Member.builder().email("a").pwd("a").build());
        when(memberRepository.findById(id)).thenReturn(memberOP);
        //when
        MemberResponse findMember=memberService.findMember(id);
        //then
        assertThat(findMember.getEmail()).isEqualTo(memberOP.get().getEmail());

    }
}