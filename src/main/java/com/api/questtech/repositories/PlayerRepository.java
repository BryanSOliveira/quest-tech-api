package com.api.questtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.questtech.models.PlayerModel;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {

}
