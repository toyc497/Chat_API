package com.api.bbmnet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.bbmnet.entity.ColorGroupEntity;
import com.api.bbmnet.service.ColorGroupService;

@RestController
@RequestMapping("/colorGroup")
public class ColorGroupController {

	@Autowired
	private ColorGroupService colorGroupService;
	
	@PostMapping("/save")
	public ResponseEntity<ColorGroupEntity> saveColorGroup(@RequestBody ColorGroupEntity colorGroup){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(colorGroupService.saveColorGroup(colorGroup));
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<ColorGroupEntity>> getAllColorGroup(){
		
		return ResponseEntity.status(HttpStatus.OK).body(colorGroupService.findAllColorsGroups());
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteColorGroup(@PathVariable("id") Long id) {
		
		colorGroupService.deleteColorGroup(id);
		
	}
	
}
