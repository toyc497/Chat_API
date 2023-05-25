package com.api.bbmnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bbmnet.entity.ColorGroupEntity;
import com.api.bbmnet.repository.ColorGroupRepository;

@Service
public class ColorGroupService {

	@Autowired
	private ColorGroupRepository colorGroupRepository;
	
	public List<ColorGroupEntity> findAllColorsGroups(){
		
		return colorGroupRepository.findAll();
		
	}
	
	public ColorGroupEntity saveColorGroup(ColorGroupEntity colorGroup) {
		
		return colorGroupRepository.save(colorGroup);
		
	}
	
	public void deleteColorGroup(Long id) {
		
		colorGroupRepository.deleteById(id);
		
	}
	
}
