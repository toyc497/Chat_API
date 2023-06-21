package com.api.bbmnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.bbmnet.entity.CredenciaisEntity;
import com.api.bbmnet.entity.SistemaEntity;

@Repository
public interface CredenciaisRepository extends JpaRepository<CredenciaisEntity, Long>{

	@Query("SELECT c FROM CredenciaisEntity c WHERE sistema = :sistema")
	CredenciaisEntity searchBySystemId(@Param("sistema") SistemaEntity sistema);
	
}
