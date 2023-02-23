package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.common.Button;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ButtonRepository extends JpaRepository<Button, Long> {
}
