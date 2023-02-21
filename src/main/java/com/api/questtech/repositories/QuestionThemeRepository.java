package com.api.questtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.questtech.models.QuestionThemeModel;

@Repository
public interface QuestionThemeRepository extends JpaRepository<QuestionThemeModel, Long> {

}
