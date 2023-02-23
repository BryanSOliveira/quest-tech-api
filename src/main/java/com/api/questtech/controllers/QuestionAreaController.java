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

import com.api.questtech.dto.QuestionAreaDTO;
import com.api.questtech.models.QuestionAreaModel;
import com.api.questtech.services.QuestionAreaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/areas")
public class QuestionAreaController {

	@Autowired
	QuestionAreaService service;
	
	@GetMapping
	public ResponseEntity<List<QuestionAreaDTO>> findAll() {
		List<QuestionAreaModel> list = service.findAll();
		List<QuestionAreaDTO> areasDto = list.stream().map(areaModel -> new QuestionAreaDTO(areaModel)).collect(Collectors.toList());
		return ResponseEntity.ok().body(areasDto);
	}
	
	@PostMapping
	public ResponseEntity<QuestionAreaDTO> insert(@RequestBody @Valid QuestionAreaDTO area) {
		QuestionAreaModel areaModel = new QuestionAreaModel();
		BeanUtils.copyProperties(area, areaModel);
		areaModel = service.insert(areaModel);
		BeanUtils.copyProperties(areaModel, area);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(area.getId()).toUri();
		return ResponseEntity.created(uri).body(area);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<QuestionAreaDTO> update(@PathVariable Long id, @RequestBody @Valid QuestionAreaDTO area) {
		QuestionAreaModel areaModel = new QuestionAreaModel();
		BeanUtils.copyProperties(area, areaModel);
		areaModel = service.update(id, areaModel);
		BeanUtils.copyProperties(areaModel, area);
		return ResponseEntity.ok().body(area);
	}
}
