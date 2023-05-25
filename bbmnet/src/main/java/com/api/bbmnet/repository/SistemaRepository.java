package com.api.bbmnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bbmnet.entity.SistemaEntity;

@Repository
public interface SistemaRepository extends JpaRepository<SistemaEntity, Long>{

}
