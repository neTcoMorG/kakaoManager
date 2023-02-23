package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
  Optional<Group> findByIdAndUserId(Long id, Long userId);
}
