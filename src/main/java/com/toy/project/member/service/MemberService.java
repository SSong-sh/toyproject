package com.toy.project.member.service;

import com.toy.project.member.domain.Member;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    /**
     * 회원가입
     * @param member
     * @return responseEntity<Member>
     */
    public ResponseEntity<Member> createUser(Member member);

    /**
     * id값으로 member 찾기
     * @param member_num
     * @return hateoas
     */
    public EntityModel<Optional<Member>> findMemberById(long member_num);

    /**
     * 모든 멤버 검색
     * @return 멤버리스트
     */
    public List<Member> findAllMembers();

    /**
     * 회원탈퇴(status로 제어)
     * @param member_num
     */
    public void deleteMember(long member_num);

    /**
     * 회원정보 수정
     * @param member
     * @param member_num
     * @return hateoas
     */
    public ResponseEntity<Member> updateMember(Member member, long member_num);
}
