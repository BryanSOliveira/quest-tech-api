package com.api.questtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.questtech.models.GameQuestionModel;

@Repository
public interface GameQuestionRepository extends JpaRepository<GameQuestionModel, Long> {

}
