package com.example.demo.domain.repository;

import com.example.demo.domain.entity.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> { }
