package com.desafio.foursales.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.foursales.entity.CandidatoEntity;
import com.desafio.foursales.repository.CandidatoRepository;
import com.desafio.foursales.service.CandidatoService;
import com.desafio.foursales.service.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/candidatos")
@CrossOrigin(origins = "*")
@Api(value = "API REST CANDIDATO")
public class CandidatoRestController {

	@Autowired
	private CandidatoService service;

	@Autowired
	private CandidatoRepository candidatoRepository;

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping(path = "listaTodos")
	@ApiOperation(value = "Retorna uma lista de candidatos.")
	private ResponseEntity<?> listaCandidatos() {
		return new ResponseEntity<>(service.listaCandidatos(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	@ApiOperation(value = "Busca um candidato pelo ID")
	private ResponseEntity<?> buscaCandidatoPorId(@PathVariable(value = "id") long id) throws Exception {
		CandidatoEntity candidato = service.buscaCandidatoPorId(id);
		if (candidato == null)
			throw new Exception("Candidato não encontrado!");

		return new ResponseEntity<>(candidato, HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Cadastra um candidato")
	public ResponseEntity<?> cadastraCandidato(@Valid @RequestBody CandidatoEntity candidato) {
		return new ResponseEntity<>(service.cadastraCandidato(candidato), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "{id}")
	@ApiOperation(value = "Deleta um candidato")
	public ResponseEntity<?> deletaCandidato(@PathVariable(value = "id") long id) throws Exception {
		return new ResponseEntity<>(service.deletaCandidato(id), HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "/{id}")
	@ApiOperation(value = "Atualiza um candidato")
	public ResponseEntity<?> atualizaCandidato(@Valid @RequestBody CandidatoEntity candidato,
			@PathVariable(value = "id") long id) throws Exception {
		return new ResponseEntity<>(service.atualizaCandidato(candidato, id), HttpStatus.OK);
	}
}
