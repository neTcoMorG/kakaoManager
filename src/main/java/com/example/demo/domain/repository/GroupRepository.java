package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
