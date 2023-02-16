package com.api.questtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.questtech.models.QuestionAreaModel;

@Repository
public interface QuestionAreaRepository extends JpaRepository<QuestionAreaModel, Long> {

}
