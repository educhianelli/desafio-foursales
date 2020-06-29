package com.desafio.foursales.entity.enums;

import java.util.Arrays;
import java.util.Optional;

public enum BandeiraEnum {
	VISA("VISA","Visa"),
	MASTERCARD("MASTERCARD","Mastercard"),
	ELO("ELO","Elo"),
	AMERICANEXPRESS("AMERICAN EXPRESS","America Express");
	
	private String nome;
	private String sigla;
	
	private BandeiraEnum(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public static Optional<BandeiraEnum> findBySigla(String sigla) {
		return Arrays.asList(BandeiraEnum.values()).stream().filter(bandeira -> bandeira.getSigla().equalsIgnoreCase(sigla))
				.findFirst();

	}

	public static String getSiglaByNome(String nome) {
		return Arrays.asList(BandeiraEnum.values()).stream().filter(bandeira -> bandeira.getNome().equalsIgnoreCase(nome))
				.findFirst().get().getSigla();
	}
}
