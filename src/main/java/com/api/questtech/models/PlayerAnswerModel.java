package com.api.questtech.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_player_answer")
public class PlayerAnswerModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "player_id")
	private PlayerModel player;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private QuestionModel question;
	
	@ManyToOne
	@JoinColumn(name = "answer_id")
	private AnswerModel answer;
	
	public PlayerAnswerModel() {
	}

	public PlayerAnswerModel(Long id, PlayerModel player, QuestionModel question, AnswerModel answer) {
		this.id = id;
		this.player = player;
		this.question = question;
		this.answer = answer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlayerModel getPlayer() {
		return player;
	}

	public void setPlayer(PlayerModel player) {
		this.player = player;
	}

	public QuestionModel getQuestion() {
		return question;
	}

	public void setQuestion(QuestionModel question) {
		this.question = question;
	}

	public AnswerModel getAnswer() {
		return answer;
	}

	public void setAnswer(AnswerModel answer) {
		this.answer = answer;
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
		PlayerAnswerModel other = (PlayerAnswerModel) obj;
		return Objects.equals(id, other.id);
	}
}
