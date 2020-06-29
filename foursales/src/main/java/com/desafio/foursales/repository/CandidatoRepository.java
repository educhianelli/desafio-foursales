package com.desafio.foursales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.desafio.foursales.entity.CandidatoEntity;

public interface CandidatoRepository extends JpaRepository<CandidatoEntity, Long> {
	
	List<CandidatoEntity> findByNomeContaining(@Param("nome") String nome);

}	
