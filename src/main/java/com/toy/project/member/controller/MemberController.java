package com.toy.project.member.controller;

import com.toy.project.member.domain.Member;
import com.toy.project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 멤버 아이디로 멤버찾기
     *
     * @param member_num
     * @return hateoas
     */
    @GetMapping("/members/{member_num}")
    public EntityModel<Optional<Member>> findByIdMember(@PathVariable long member_num) {
        return memberService.findMemberById(member_num);
    }

    /**
     * 모든멤버찾기
     *
     * @return List<Member>
     */
    @GetMapping("/members")
    public List<Member> findAllMembers() {
        return memberService.findAllMembers();
    }

    /**
     * 회원가입
     *
     * @param member
     * @return hateoas
     */
    @PostMapping("/members")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return memberService.createUser(member);
    }

    /**
     * 회원정보 수정
     *
     * @param member
     * @param member_num
     * @return hateoas
     */
    @PutMapping("/members/{member_num}")
    public ResponseEntity<Member> updateMember(@RequestBody Member member, @PathVariable long member_num) {
        return memberService.updateMember(member, member_num);
    }

    /**
     * 회원탈퇴
     * @param member_num
     * status로 제어
     */
    @DeleteMapping("/members/{member_num}")
    public void deleteMember(@PathVariable long member_num) {
        memberService.deleteMember(member_num);
    }



}
