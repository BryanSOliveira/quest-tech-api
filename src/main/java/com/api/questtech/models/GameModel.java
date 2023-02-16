package com.api.questtech.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game")
public class GameModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "mode_id")
	private GameModeModel mode;
	
	@ManyToMany
	@JoinTable(name = "tb_game_player",
			joinColumns = @JoinColumn(name = "game_id"), 
			inverseJoinColumns = @JoinColumn(name = "player_id"))
	private List<PlayerModel> players = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "tb_game_question",
			joinColumns = @JoinColumn(name = "game_id"), 
			inverseJoinColumns = @JoinColumn(name = "question_id"))
	private List<QuestionModel> questions = new ArrayList<>();
	
	@Column(columnDefinition = "boolean default false")
	private boolean finish;
	
	public GameModel() {
	}

	public GameModel(Long id, boolean finish, GameModeModel mode) {
		this.id = id;
		this.finish = finish;
		this.mode = mode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public GameModeModel getMode() {
		return mode;
	}

	public void setMode(GameModeModel mode) {
		this.mode = mode;
	}

	public List<PlayerModel> getPlayers() {
		return players;
	}

	public List<QuestionModel> getQuestions() {
		return questions;
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
		GameModel other = (GameModel) obj;
		return Objects.equals(id, other.id);
	}
}
