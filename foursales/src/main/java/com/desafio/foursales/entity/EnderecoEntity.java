package com.desafio.foursales.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ENDERECO")
public class EnderecoEntity implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2453776015917000016L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "logradouro", length = 50)
	private String logradouro;
	@Column(name = "complemento", length = 50)
	private String complemento;
	@Column(name = "bairro", length = 50)
	private String bairro;
	@Column(name = "localidade", length = 20)
	private String localidade;
	@Column(name = "uf", length = 2)
	private String uf;
	@Column(name = "cep", length = 8)
	private String cep;

	@ManyToOne
	@JoinColumn(name = "candidato_id")
	@JsonIgnore
	private CandidatoEntity candidato;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setEstado(String localidade) {
		this.localidade = localidade;
	}

	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
		this.candidato = candidato;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}