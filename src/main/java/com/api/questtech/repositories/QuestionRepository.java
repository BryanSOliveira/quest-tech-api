package com.api.questtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.questtech.models.QuestionModel;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {

}
