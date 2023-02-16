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
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_player")
public class PlayerModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private UserModel user;
	
	@Column(nullable = false)
	private int level;
	
	@Column(nullable = false)
	private int points;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "players")
	private List<GameModel> games = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "player")
	private List<PlayerAnswerModel> answers = new ArrayList<>();
	
	public PlayerModel() {
	}

	public PlayerModel(Long id, UserModel user, int level, int points) {
		this.id = id;
		this.user = user;
		this.level = level;
		this.points = points;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public List<GameModel> getGames() {
		return games;
	}

	public List<PlayerAnswerModel> getAnswers() {
		return answers;
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
		PlayerModel other = (PlayerModel) obj;
		return Objects.equals(id, other.id);
	}
}
