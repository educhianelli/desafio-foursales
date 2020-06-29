package com.desafio.foursales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.desafio.foursales.entity.CartaoEntity;

public interface CartaoRepository extends JpaRepository<CartaoEntity, Long>{
	List<CartaoEntity> findByNumeroContaining(@Param("numero") String numero);

}
