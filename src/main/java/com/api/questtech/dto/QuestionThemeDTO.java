package com.api.questtech.dto;

import java.io.Serializable;
import java.util.Objects;

import com.api.questtech.models.QuestionAreaModel;
import com.api.questtech.models.QuestionThemeModel;

import jakarta.validation.constraints.NotBlank;

public class QuestionThemeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank
	private String name;
	
	private QuestionAreaModel area;
	
	public QuestionThemeDTO() {
	}

	public QuestionThemeDTO(Long id, String name, QuestionAreaModel area) {
		this.id = id;
		this.name = name;
		this.area = area;
	}
	
	public QuestionThemeDTO(QuestionThemeModel themeModel) {
		this.id = themeModel.getId();
		this.name = themeModel.getName();
		this.area = themeModel.getArea();
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

	public QuestionAreaModel getArea() {
		return area;
	}

	public void setArea(QuestionAreaModel area) {
		this.area = area;
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
		QuestionThemeDTO other = (QuestionThemeDTO) obj;
		return Objects.equals(id, other.id);
	}
}
