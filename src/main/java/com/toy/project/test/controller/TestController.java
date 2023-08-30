package com.toy.project.test.controller;

import com.toy.project.test.domain.TestMember;
import com.toy.project.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world";
    }
    @PostMapping("/test")
    public void testInsert(TestMember testMember) {
        testMember.setName("test");
        testRepository.save(testMember);
    }

    @GetMapping("/test")
    public List<TestMember> testSelect() {
        return testRepository.findAll();
    }
}
