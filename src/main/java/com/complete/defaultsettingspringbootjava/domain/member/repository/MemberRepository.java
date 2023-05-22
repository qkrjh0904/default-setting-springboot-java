package com.complete.defaultsettingspringbootjava.domain.member.repository;

import com.complete.defaultsettingspringbootjava.db.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
