package com.api.questtech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.questtech.models.GameModeModel;
import com.api.questtech.repositories.GameModeRepository;

import jakarta.transaction.Transactional;

@Service
public class GameModeService {
	
	@Autowired
	GameModeRepository repository;

	public List<GameModeModel> findAll() {
		return repository.findAll();
	}
	
	@Transactional
	public GameModeModel insert(GameModeModel mode) {
		return repository.save(mode);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public GameModeModel update(Long id, GameModeModel mode) {
		GameModeModel modeModel = repository.getReferenceById(id);
		updateData(modeModel, mode);
		return repository.save(modeModel);
	}

	private void updateData(GameModeModel modeModel, GameModeModel mode) {
		modeModel.setName(mode.getName());
	}
}
