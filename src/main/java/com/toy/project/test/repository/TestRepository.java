package com.toy.project.test.repository;

import com.toy.project.test.domain.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestMember, Long> {
}
