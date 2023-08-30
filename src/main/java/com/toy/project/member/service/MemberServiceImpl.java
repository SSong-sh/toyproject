package com.toy.project.member.service;

import com.toy.project.exception.UserNotFoundException;
import com.toy.project.member.controller.MemberController;
import com.toy.project.member.domain.Member;
import com.toy.project.member.repository.MemberJpaRepository;
import com.toy.project.member.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberJpaRepository memberJpaRepository; //jpa
    private final MemberMapper memberMapper; // mapper


    @Override
    public ResponseEntity<Member> createUser(Member member) {
        Member savedMember = memberJpaRepository.save(member);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedMember.getMember_num())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public EntityModel<Optional<Member>> findMemberById(long member_num) {
        Optional<Member> member = memberJpaRepository.findById(member_num);

        //hateoas
        EntityModel<Optional<Member>> model = EntityModel.of(member);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(MemberController.class).findAllMembers());
        model.add(linkTo.withRel("all-members"));

        return model;
    }

    @Override
    public void deleteMember(long member_num) {
        memberMapper.deleteMember(member_num);
    }

    @Override
    public ResponseEntity<Member> updateMember(Member member, long member_num) {
        if (member.getMember_num() != member_num) {
            throw new UserNotFoundException(String.format("ID[$s] not found", member_num));
        }

        Member updateMember = memberMapper.updateMember(member, member_num);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(updateMember.getMember_num())
                .toUri();


        return ResponseEntity.created(location).build();
    }

    @Override
    public List<Member> findAllMembers() {
        return memberJpaRepository.findAll();
    }
}
