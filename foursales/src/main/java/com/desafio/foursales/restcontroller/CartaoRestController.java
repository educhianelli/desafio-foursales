package com.desafio.foursales.restcontroller;

import java.util.List;

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
import com.desafio.foursales.entity.CartaoEntity;
import com.desafio.foursales.service.CartaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cartoes")
@CrossOrigin(origins = "*")
@Api(value = "API REST CARTÃO")
public class CartaoRestController {

	@Autowired
	private CartaoService service;

	@GetMapping(path = "listaTodos")
	@ApiOperation(value = "Retorna uma lista de cartões.")
	private ResponseEntity<?> listaCartoes() {
		return new ResponseEntity<>(service.listaCartoes(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	@ApiOperation(value = "Busca um cartão pelo ID")
	private ResponseEntity<?> buscaCartaoPorId(@PathVariable(value = "id") long id) throws Exception {
		CartaoEntity cartao = service.buscaCartaoPorId(id);
		if (cartao == null)
			throw new Exception("Candidato não encontrado!");

		return new ResponseEntity<>(cartao, HttpStatus.OK);
	}

	@DeleteMapping(path = "{id}")
	@ApiOperation(value = "Deleta um cartão")
	public ResponseEntity<?> deletaCandidato(@PathVariable(value = "id") long id) throws Exception {
		return new ResponseEntity<>(service.deletaCartao(id), HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "/{id}")
	@ApiOperation(value = "Atualiza um cartão")
	public ResponseEntity<?> atualizaCartao(@Valid @RequestBody CartaoEntity cartao,
			@PathVariable(value = "id") long id) throws Exception {
		return new ResponseEntity<>(service.atualizaCartao(cartao, id), HttpStatus.OK);
	}
}
