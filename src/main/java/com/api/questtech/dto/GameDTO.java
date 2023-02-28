package com.api.questtech.dto;

import java.io.Serializable;
import java.util.List;

import com.api.questtech.models.GameModeModel;
import com.api.questtech.models.GameModel;
import com.api.questtech.models.PlayerModel;

public class GameDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	
	private GameModeModel mode;
	
	private List<PlayerModel> players;
	
	public GameDTO() {
	}

	public GameDTO(long id, GameModeModel mode, List<PlayerModel> players) {
		this.id = id;
		this.mode = mode;
		this.players = players;
	}
	
	public GameDTO(GameModel gameModel) {
		this.id = gameModel.getId();
		this.mode = gameModel.getMode();
		this.players = gameModel.getPlayers();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
}
