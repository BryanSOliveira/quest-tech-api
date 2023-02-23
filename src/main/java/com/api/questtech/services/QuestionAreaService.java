package com.api.questtech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.questtech.models.QuestionAreaModel;
import com.api.questtech.repositories.QuestionAreaRepository;

import jakarta.transaction.Transactional;

@Service
public class QuestionAreaService {

	@Autowired
	QuestionAreaRepository repository;
	
	public List<QuestionAreaModel> findAll() {
		return repository.findAll();
	}
	
	@Transactional
	public QuestionAreaModel insert(QuestionAreaModel area) {
		return repository.save(area);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public QuestionAreaModel update(Long id, QuestionAreaModel area) {
		QuestionAreaModel areaModel = repository.getReferenceById(id);
		updateData(areaModel, area);
		return repository.save(areaModel);
	}
	
	private void updateData(QuestionAreaModel areaModel, QuestionAreaModel area) {
		areaModel.setName(area.getName());
	}
}
