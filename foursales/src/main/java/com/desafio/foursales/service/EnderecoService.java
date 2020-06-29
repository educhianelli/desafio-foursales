package com.desafio.foursales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.desafio.foursales.entity.EnderecoEntity;
import com.desafio.foursales.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	public EnderecoEntity cadastraEndereco(@RequestBody EnderecoEntity endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public EnderecoEntity deletaEndereco(@RequestBody EnderecoEntity endereco) {
		enderecoRepository.delete(endereco);
		return endereco;
	}
	
	
	public List<EnderecoEntity> listaEndereco() {
		List<EnderecoEntity> listaEndereco = enderecoRepository.findAll();
		return listaEndereco;
	}
	
	public EnderecoEntity buscarEnderecoPorId(long id) {
		return enderecoRepository.findById(id);
	}
	
	public EnderecoEntity buscaEnderecoViaCep(String cep) {
		 String URI = "https://viacep.com.br/ws/";
		 RestTemplate restTemplate = new RestTemplate();
		 EnderecoEntity end = restTemplate.getForObject(URI  + cep + "/json", EnderecoEntity.class);
		 return end;
	}
	
	
}
