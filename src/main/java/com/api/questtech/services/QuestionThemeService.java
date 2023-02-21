package com.api.questtech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.questtech.models.QuestionAreaModel;
import com.api.questtech.models.QuestionThemeModel;
import com.api.questtech.repositories.QuestionAreaRepository;
import com.api.questtech.repositories.QuestionThemeRepository;

import jakarta.transaction.Transactional;

@Service
public class QuestionThemeService {

	@Autowired
	QuestionThemeRepository repository;
	
	@Autowired
	QuestionAreaRepository areaRepository;
	
	public List<QuestionThemeModel> findAll() {
		return repository.findAll();
	}
	
	@Transactional
	public QuestionThemeModel insert(QuestionThemeModel theme) {
		Optional<QuestionAreaModel> areaModel = areaRepository.findById(theme.getArea().getId());
		theme.setArea(areaModel.get());
		return repository.save(theme);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public QuestionThemeModel update(Long id, QuestionThemeModel theme) {
		QuestionThemeModel themeModel = repository.getReferenceById(id);
		updateData(themeModel, theme);
		return repository.save(themeModel);
	}
	
	private void updateData(QuestionThemeModel themeModel, QuestionThemeModel theme) {
		themeModel.setName(theme.getName());
		if(theme.getArea() != null) {
			Optional<QuestionAreaModel> areaModel = areaRepository.findById(theme.getArea().getId());
			themeModel.setArea(areaModel.get());
		}
	}
}
