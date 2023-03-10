package com.tdd.entity;

import com.tdd.dto.MemberResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository repository;

    //@BeforeAll //테스트 시작전 한번만 실행
    /*
    @BeforeEach // 각 테스트 시작전 한번씩 실행
    public void 데이터(){
        Member member = Member.builder()
                .email("테스트Email")
                .pwd("111")
                .build();
        repository.save(member).getId();

    }*/
    @Test
    public void save() {
        //given ( 데이터 준비 )
        Member member = Member.builder()
                .email("테스트EmailCreate")
                .pwd("111")
                .build();
        //when ( 테스트 실행 )
        Member memberPersistence = repository.save(member);
        //then ( 검증 )
        assertThat(memberPersistence.getEmail()).isEqualTo(member.getEmail());
        assertThat(memberPersistence.getPwd()).isEqualTo(member.getPwd());
    }

    @Test
    public void findMember(){
        //given
        String email="a";
        String pwd="a";
        //when
        Member entity=repository.findById(1L).get();
        //then
        assertThat(entity.getEmail()).isEqualTo(email);
        assertThat(entity.getPwd()).isEqualTo(pwd);
    }
    @Test
    public void deleteMember(){
        //given
        Long id=1L;
        //when
        repository.deleteById(id);
        //then
        assertThat(repository.findById(1L)).isEmpty();
    }
    @Test
    public void modifyMember(){
        Member m=Member.builder().email("b").pwd("b").id(1L).build ();
        Member member=repository.save(m);
        assertThat(m.getEmail()).isEqualTo(member.getEmail());
        assertThat(m.getPwd()).isEqualTo(member.getPwd());
        assertThat(m.getId()).isEqualTo(member.getId());

    }


}