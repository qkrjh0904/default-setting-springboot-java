package com.complete.defaultsettingspringbootjava.domain.member.service;

import com.complete.defaultsettingspringbootjava.db.entity.Member;
import com.complete.defaultsettingspringbootjava.domain.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void saveMember() {
        Member member = Member.create("박정호", "asdf@naver.com");
        Member savedMember = memberRepository.save(member);

        Assertions.assertThat(member.equals(savedMember)).isTrue();

        memberRepository.delete(member);
    }

    @Test
    void findAllMember() {

    }
}