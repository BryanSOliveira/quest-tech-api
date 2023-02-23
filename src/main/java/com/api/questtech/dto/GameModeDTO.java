package com.api.questtech.dto;

import java.io.Serializable;

import com.api.questtech.models.GameModeModel;

import jakarta.validation.constraints.NotBlank;

public class GameModeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;

	@NotBlank
	private String name;
	
	private boolean singleplayer;
	
	public GameModeDTO() {
	}

	public GameModeDTO(Long id, String name, boolean singleplayer) {
		this.id = id;
		this.name = name;
		this.singleplayer = singleplayer; 
	}

	public GameModeDTO(GameModeModel modeModel) {
		this.id = modeModel.getId();
		this.name = modeModel.getName();
		this.singleplayer = modeModel.getSingleplayer();
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

	public boolean isSingleplayer() {
		return singleplayer;
	}

	public void setSingleplayer(boolean singleplayer) {
		this.singleplayer = singleplayer;
	}
}
