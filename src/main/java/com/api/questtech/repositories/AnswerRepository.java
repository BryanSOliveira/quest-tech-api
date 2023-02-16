package com.api.questtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.questtech.models.AnswerModel;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerModel, Long> {

}
