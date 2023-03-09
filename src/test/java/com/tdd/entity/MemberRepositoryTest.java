package com.tdd.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;

    @Test
     void save() {
        //given
         Member member=Member.builder()
                .email("342sad5")
                .pwd("325asd4")
                .address("325asd4")
                .tel("00223324553234")
                .build();
        //when
        Long id=repository.save(member).getId();
        //then
        Member entity = repository.findById(id).get();
        assertThat(entity.getEmail()).isEqualTo(member.getEmail());
        assertThat(entity.getAddress()).isEqualTo(member.getAddress());
        assertThat(entity.getTel()).isEqualTo(member.getTel());
    }



}