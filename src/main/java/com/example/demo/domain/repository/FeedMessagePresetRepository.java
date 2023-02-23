package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.feed.FeedMessagePreset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeedMessagePresetRepository extends JpaRepository<FeedMessagePreset,Long>, FeedMessagePresetCustomRepository {
  List<FeedMessagePreset> findByUserId(Long userId);
  Optional<FeedMessagePreset> findByIdAndUserId(Long id, Long userId);

}
