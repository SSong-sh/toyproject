package com.toy.project.controller;

import com.toy.project.domain.Member;
import com.toy.project.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @PostMapping("test")
    public void testInsert(Member member) {
        member.setName("test");
        testRepository.save(member);
    }

    @GetMapping("test")
    public List<Member> testSelect() {
        return testRepository.findAll();
    }
}
