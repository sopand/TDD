package com.tdd.service;

import com.tdd.dto.MemberRequest;
import com.tdd.dto.MemberResponse;
import com.tdd.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    @Transactional
    public MemberResponse createMember(MemberRequest request){
        MemberResponse member=new MemberResponse(memberRepository.save(request.memberEntity()));
        return member;
    }

    public MemberResponse findMember(Long id){
        MemberResponse member=new MemberResponse(memberRepository.findById(id).get());
        return member;
    }

}
