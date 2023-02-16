package com.api.questtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.questtech.models.GameModeModel;

@Repository
public interface GameModeRepository extends JpaRepository<GameModeModel, Long> {

}
