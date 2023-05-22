package com.complete.defaultsettingspringbootjava.domain.member.model.rs;

import com.complete.defaultsettingspringbootjava.domain.member.model.dto.FindAllMemberDto;

import java.util.List;

public record FindAllMemberRs(
        List<FindAllMemberDto> memberList
) {
    public static FindAllMemberRs create(List<FindAllMemberDto> list) {
        return new FindAllMemberRs(list);
    }
}
