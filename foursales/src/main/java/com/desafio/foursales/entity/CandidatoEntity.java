package com.desafio.foursales.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "CANDIDATO")
public class CandidatoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 971992678729521631L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;

	@NotEmpty
	@Size(min = 3, max = 100)
	//@Pattern(regexp = "[a-zA-Z]", message = "Não é permitido caracter especial!")
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@NotEmpty
	@CPF(message = "CPF inválido!")
	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;

	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CartaoEntity> cartoes;

	@OneToOne(mappedBy = "candidato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private EnderecoEntity endereco;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<CartaoEntity> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoEntity> cartoes) {
		this.cartoes = cartoes;
	}

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

}
