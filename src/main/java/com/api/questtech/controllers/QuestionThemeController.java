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

import com.api.questtech.dto.QuestionThemeDTO;
import com.api.questtech.models.QuestionThemeModel;
import com.api.questtech.services.QuestionThemeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/themes")
public class QuestionThemeController {

	@Autowired
	QuestionThemeService service;
	
	@GetMapping
	public ResponseEntity<List<QuestionThemeDTO>> findAll() {
		List<QuestionThemeModel> list = service.findAll();
		List<QuestionThemeDTO> themesDto = list.stream().map(themeModel -> new QuestionThemeDTO(themeModel)).collect(Collectors.toList());
		return ResponseEntity.ok().body(themesDto);
	}
	
	@PostMapping
	public ResponseEntity<QuestionThemeDTO> insert(@RequestBody @Valid QuestionThemeDTO theme) {
		QuestionThemeModel themeModel = new QuestionThemeModel();
		BeanUtils.copyProperties(theme, themeModel);
		themeModel = service.insert(themeModel);
		BeanUtils.copyProperties(themeModel, theme);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(theme.getId()).toUri();
		return ResponseEntity.created(uri).body(theme);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<QuestionThemeDTO> update(@PathVariable Long id, @RequestBody @Valid QuestionThemeDTO theme) {
		QuestionThemeModel themeModel = new QuestionThemeModel();
		BeanUtils.copyProperties(theme, themeModel);
		themeModel = service.update(id, themeModel);
		BeanUtils.copyProperties(themeModel, theme);
		return ResponseEntity.ok().body(theme);
	}
}
