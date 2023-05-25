package com.api.bbmnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bbmnet.entity.ColorGroupEntity;

@Repository
public interface ColorGroupRepository extends JpaRepository<ColorGroupEntity, Long>{

}
