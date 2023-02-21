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

import com.api.questtech.dto.GameModeDTO;
import com.api.questtech.models.GameModeModel;
import com.api.questtech.services.GameModeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/modes")
public class GameModeController {
	
	@Autowired
	GameModeService service;

	@GetMapping
	public ResponseEntity<List<GameModeDTO>> findAll() {
		List<GameModeModel> list = service.findAll();
		List<GameModeDTO> modesDto = list.stream().map(modeModel -> new GameModeDTO(modeModel)).collect(Collectors.toList());
		return ResponseEntity.ok().body(modesDto);
	}
	
	@PostMapping
	public ResponseEntity<GameModeDTO> insert(@RequestBody @Valid GameModeDTO mode) {
		GameModeModel modeModel = new GameModeModel();
		BeanUtils.copyProperties(mode, modeModel);
		modeModel = service.insert(modeModel);
		BeanUtils.copyProperties(modeModel, mode);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mode.getId()).toUri();
		return ResponseEntity.created(uri).body(mode);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<GameModeDTO> update(@PathVariable Long id, @RequestBody @Valid GameModeDTO mode) {
		GameModeModel modeModel = new GameModeModel();
		BeanUtils.copyProperties(mode, modeModel);
		modeModel = service.update(id, modeModel);
		BeanUtils.copyProperties(modeModel, mode);
		return ResponseEntity.ok().body(mode);
	}
}
