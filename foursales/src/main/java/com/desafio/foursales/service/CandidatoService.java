package com.desafio.foursales.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.desafio.foursales.entity.CandidatoEntity;
import com.desafio.foursales.entity.CartaoEntity;
import com.desafio.foursales.repository.CandidatoRepository;
import com.desafio.foursales.repository.CartaoRepository;
import com.desafio.foursales.repository.EnderecoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository repository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private CartaoRepository cartaoRepository;

	@Transactional
	public CandidatoEntity cadastraCandidato(@RequestBody CandidatoEntity candidato) {
		CandidatoEntity candidatoPersist = repository.save(candidato);
		candidatoPersist.getEndereco().setCandidato(candidatoPersist);
		candidatoPersist.getCartoes().forEach(c -> c.setCandidato(candidatoPersist));
		enderecoRepository.save(candidatoPersist.getEndereco());
		cartaoRepository.saveAll(candidatoPersist.getCartoes());
		return candidatoPersist;
	}

	public CandidatoEntity deletaCandidato(Long id) throws ObjectNotFoundException {
		CandidatoEntity c = buscaCandidatoPorId(id);
		repository.deleteById(id);
		return c;

	}

	public CandidatoEntity buscaCandidatoPorId(long id) throws ObjectNotFoundException {
		Optional<CandidatoEntity> candidato = repository.findById(id);
		return candidato.orElseThrow(() -> new ObjectNotFoundException("Candidato: " + id + " não encontrado!"));
	}

	public CandidatoEntity atualizaCandidato(CandidatoEntity candidatoEntity, Long id) throws ObjectNotFoundException {
		CandidatoEntity candidato = buscaCandidatoPorId(id);
		candidato.setNome(candidatoEntity.getNome());
		candidato.setCpf(candidatoEntity.getCpf());


		for (CartaoEntity c : candidatoEntity.getCartoes()) {
			c.setCandidato(candidato);
			candidato.getCartoes().add(c);
		}


		candidato = repository.save(candidato);

		cartaoRepository.saveAll(candidato.getCartoes());
		
		return candidato;
	}

	public List<CandidatoEntity> buscaCandidatoLikeNome(String nome) {
		List<CandidatoEntity> candidatos = repository.findByNomeContaining(nome);
		return candidatos;
	}

	public List<CandidatoEntity> listaCandidatos() {
		List<CandidatoEntity> listaCandidato = repository.findAll();
		return listaCandidato;
	}

}
