package com.api.questtech.models.pk;

import java.io.Serializable;
import java.util.Objects;

import com.api.questtech.models.GameModel;
import com.api.questtech.models.QuestionModel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class GameQuestionPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "game_id")
	private GameModel game;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private QuestionModel question;

	public GameModel getGame() {
		return game;
	}

	public void setGame(GameModel game) {
		this.game = game;
	}

	public QuestionModel getQuestion() {
		return question;
	}

	public void setQuestion(QuestionModel question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, question);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameQuestionPK other = (GameQuestionPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(question, other.question);
	}
}
