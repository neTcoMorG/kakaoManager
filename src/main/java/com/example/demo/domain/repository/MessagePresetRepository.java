package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.common.MessagePreset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagePresetRepository extends JpaRepository<MessagePreset,Long> {
}
