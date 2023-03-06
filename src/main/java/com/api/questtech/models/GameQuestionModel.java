package com.api.questtech.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.api.questtech.models.pk.GameQuestionPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game_question")
public class GameQuestionModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GameQuestionPK id = new GameQuestionPK();
	
	private Instant moment;
	
	public GameQuestionModel() {
	}
	
	public GameQuestionModel(GameModel game, QuestionModel question, Instant moment) {
		this.id.setGame(game);
		this.id.setQuestion(question);
		this.moment = moment;
	}

	public GameQuestionPK getId() {
		return id;
	}

	public void setId(GameQuestionPK id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
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
		GameQuestionModel other = (GameQuestionModel) obj;
		return Objects.equals(id, other.id);
	}
}
