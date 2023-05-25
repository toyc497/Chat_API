package com.api.bbmnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bbmnet.entity.MensagemEntity;

@Repository
public interface MensagemRepository extends JpaRepository<MensagemEntity, Long>{

}
