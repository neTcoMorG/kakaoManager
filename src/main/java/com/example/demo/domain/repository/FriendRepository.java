package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend, Long> {

    Optional<Friend> findByUuid(String uuid);
    List<Friend> findByUserId(Long userId);
}
