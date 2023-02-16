package com.api.questtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.questtech.models.GameModel;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Long> {

}
