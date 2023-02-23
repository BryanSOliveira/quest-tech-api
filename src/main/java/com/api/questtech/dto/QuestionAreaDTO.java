package com.api.questtech.dto;

import java.io.Serializable;

import com.api.questtech.models.QuestionAreaModel;

import jakarta.validation.constraints.NotBlank;

public class QuestionAreaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank
	private String name;
	
	public QuestionAreaDTO() {
	}

	public QuestionAreaDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public QuestionAreaDTO(QuestionAreaModel areaModel) {
		this.id = areaModel.getId();
		this.name = areaModel.getName();
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
}
