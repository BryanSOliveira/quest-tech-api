package com.api.questtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.questtech.models.PlayerAnswerModel;

@Repository
public interface PlayerAnswerRepository extends JpaRepository<PlayerAnswerModel, Long> {

}
