package com.api.questtech.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.questtech.dto.GameDTO;
import com.api.questtech.models.GameModel;
import com.api.questtech.services.GameService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	GameService service;

	@GetMapping
	public ResponseEntity<List<GameDTO>> findAll() {
		List<GameModel> list = service.findAll();
		List<GameDTO> gamesDto = list.stream().map(gameModel -> new GameDTO(gameModel)).collect(Collectors.toList());
		return ResponseEntity.ok().body(gamesDto);
	}
	
	@PostMapping
	public ResponseEntity<GameDTO> insert(@RequestBody @Valid GameDTO game) {
		GameModel gameModel = new GameModel(game);
		gameModel = service.insert(gameModel);
		BeanUtils.copyProperties(gameModel, game);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(game.getId()).toUri();
		return ResponseEntity.created(uri).body(game);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<GameDTO> update(@PathVariable Long id, @RequestBody @Valid GameDTO game) {
		GameModel gameModel = new GameModel(game);
		gameModel = service.update(id, gameModel);
		BeanUtils.copyProperties(gameModel, game);
		return ResponseEntity.ok().body(game);
	}
}
