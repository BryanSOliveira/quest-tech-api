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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_question_theme")
public class QuestionThemeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "area_id")
	private QuestionAreaModel area;
	
	@JsonIgnore
	@OneToMany(mappedBy = "theme")
	private List<QuestionModel> questions = new ArrayList<>();
	
	public QuestionThemeModel() {
	}

	public QuestionThemeModel(Long id, String name, QuestionAreaModel area) {
		this.id = id;
		this.name = name;
		this.area = area;
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
		QuestionThemeModel other = (QuestionThemeModel) obj;
		return Objects.equals(id, other.id);
	}
}
