package com.api.questtech.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_answer")
public class AnswerModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String response;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "alternatives")
	private List<QuestionModel> alternativesQuestions = new ArrayList<>();
	
	@OneToMany(mappedBy = "answer")
	private List<QuestionModel> answersQuestions = new ArrayList<>();
	
	@OneToMany(mappedBy = "answer")
	private List<PlayerAnswerModel> playersAnswers = new ArrayList<>();
	
	public AnswerModel() {
	}

	public AnswerModel(Long id, String response) {
		this.id = id;
		this.response = response;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public List<QuestionModel> getAnswersQuestions() {
		return answersQuestions;
	}

	public List<PlayerAnswerModel> getPlayersAnswers() {
		return playersAnswers;
	}

	public List<QuestionModel> getAlternativesQuestions() {
		return alternativesQuestions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnswerModel other = (AnswerModel) obj;
		return Objects.equals(id, other.id);
	}
}
