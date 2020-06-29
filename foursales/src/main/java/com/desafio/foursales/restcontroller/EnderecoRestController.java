package com.desafio.foursales.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.foursales.service.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/enderecos")
@CrossOrigin(origins = "*")
@Api(value = "API REST ENDEREÇO")
public class EnderecoRestController {
	
	@Autowired
	private EnderecoService enderecoService;

		@GetMapping(path = "cep")
		@ApiOperation(value = "Retorna um endereço com base no CEP")
		private ResponseEntity<?> endereco(@RequestParam(value = "cep") String cep) {
			return new ResponseEntity<>(enderecoService.buscaEnderecoViaCep(cep), HttpStatus.OK);
		}


}
