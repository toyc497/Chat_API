package com.api.bbmnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bbmnet.entity.PalavraChaveEntity;

@Repository
public interface PalavraChaveRepository extends JpaRepository<PalavraChaveEntity, Long>{

}
