package com.api.bbmnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bbmnet.entity.EditalEntity;

@Repository
public interface EditalRepository extends JpaRepository<EditalEntity, Long>{

}
