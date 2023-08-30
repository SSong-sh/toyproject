package com.toy.project.member.repository;

import com.toy.project.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    void deleteMember(long member_num);

    Member updateMember(@Param("member") Member member ,@Param("member_num") long memberNum);
}
