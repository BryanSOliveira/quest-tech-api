package com.api.questtech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.questtech.models.GameModel;
import com.api.questtech.models.PlayerModel;
import com.api.questtech.repositories.GameRepository;

import jakarta.transaction.Transactional;

@Service
public class GameService {
	
	@Autowired
	GameRepository repository;

	public List<GameModel> findAll() {
		return repository.findAll();
	}
	
	@Transactional
	public GameModel insert(GameModel game) {
		return repository.save(game);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public GameModel update(Long id, GameModel game) {
		GameModel gameModel = repository.getReferenceById(id);
		updateData(gameModel, game);
		return repository.save(gameModel);
	}

	private void updateData(GameModel gameModel, GameModel game) {
		for (PlayerModel player : game.getPlayers()) {
			gameModel.getPlayers().add(player);
		}
	}
}
