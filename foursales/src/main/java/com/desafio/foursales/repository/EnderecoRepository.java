package com.desafio.foursales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.foursales.entity.EnderecoEntity;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

	EnderecoEntity findById(long id);

}
