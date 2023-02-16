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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_question")
public class QuestionModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String question;
	
	@ManyToMany
	@JoinTable(name = "tb_question_alternative",
	joinColumns = @JoinColumn(name = "question_id"), 
	inverseJoinColumns = @JoinColumn(name = "alternative_id"))
	List<AnswerModel> alternatives = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "questions")
	private List<GameModel> games = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "area_id")
	private QuestionAreaModel area;
	
	@JsonIgnore
	@OneToMany(mappedBy = "question")
	private List<PlayerAnswerModel> playersAnswers = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "answer_id")
	private AnswerModel answer;
	
	public QuestionModel() {
	}

	public QuestionModel(Long id, String question, QuestionAreaModel area, AnswerModel answer) {
		this.id = id;
		this.question = question;
		this.area = area;
		this.answer = answer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<AnswerModel> getAlternatives() {
		return alternatives;
	}

	public List<GameModel> getGames() {
		return games;
	}

	public QuestionAreaModel getArea() {
		return area;
	}

	public void setArea(QuestionAreaModel area) {
		this.area = area;
	}

	public AnswerModel getAnswer() {
		return answer;
	}

	public void setAnswer(AnswerModel answer) {
		this.answer = answer;
	}

	public List<PlayerAnswerModel> getPlayersAnswers() {
		return playersAnswers;
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
		QuestionModel other = (QuestionModel) obj;
		return Objects.equals(id, other.id);
	}
}
