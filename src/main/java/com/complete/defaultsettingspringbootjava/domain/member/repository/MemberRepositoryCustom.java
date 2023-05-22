package com.complete.defaultsettingspringbootjava.domain.member.repository;

import com.complete.defaultsettingspringbootjava.db.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findAllQuery();
}
