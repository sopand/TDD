package com.tdd.service;

import com.tdd.dto.MemberRequest;
import com.tdd.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    @Transactional
    public void createMember(MemberRequest request){
        memberRepository.save(request.memberEntity());
    }
}
