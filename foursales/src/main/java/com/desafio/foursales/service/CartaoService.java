package com.desafio.foursales.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.desafio.foursales.entity.CandidatoEntity;
import com.desafio.foursales.entity.CartaoEntity;
import com.desafio.foursales.repository.CartaoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository repository;

	public CartaoEntity buscaCartaoPorId(long id) throws ObjectNotFoundException {
		Optional<CartaoEntity> cartao = repository.findById(id);
		return cartao.orElseThrow(() -> new ObjectNotFoundException("Cartão: " + id + " não encontrado!"));
	}

	public CartaoEntity atualizaCartao(CartaoEntity cartaoEntity, Long id) throws ObjectNotFoundException {
		CartaoEntity cartao = buscaCartaoPorId(id);

		cartao.setBandeira(cartaoEntity.getBandeira());
		cartao.setDataValidade(cartaoEntity.getDataValidade());
		cartao.setCodigoSeguranca(cartaoEntity.getCodigoSeguranca());
		cartao.setNumero(cartaoEntity.getNumero());

		return repository.save(cartao);
	}

	public CartaoEntity deletaCartao(Long id) throws ObjectNotFoundException {
		CartaoEntity c = buscaCartaoPorId(id);
		repository.deleteById(id);
		return c;

	}

	public List<CartaoEntity> buscaCartaoLikeNome(String numero) {
		List<CartaoEntity> cartoes = repository.findByNumeroContaining(numero);
		return cartoes;
	}

	public List<CartaoEntity> listaCartoes() {
		List<CartaoEntity> listaCartao = repository.findAll();
		return listaCartao;
	}

}
