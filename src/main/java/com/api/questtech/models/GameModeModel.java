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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game_mode")
public class GameModeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "mode")
	private List<GameModel> games = new ArrayList<>();
	
	@Column(columnDefinition = "boolean default false")
	private boolean singleplayer;
	
	public GameModeModel() {
	}

	public GameModeModel(Long id, String name, boolean singleplayer) {
		this.id = id;
		this.name = name;
		this.singleplayer = singleplayer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GameModel> getGames() {
		return games;
	}

	public void setGames(List<GameModel> games) {
		this.games = games;
	}

	public boolean getSingleplayer() {
		return singleplayer;
	}

	public void setSingleplayer(boolean singleplayer) {
		this.singleplayer = singleplayer;
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
		GameModeModel other = (GameModeModel) obj;
		return Objects.equals(id, other.id);
	}
}
