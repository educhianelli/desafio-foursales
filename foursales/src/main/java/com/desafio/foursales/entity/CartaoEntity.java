package com.desafio.foursales.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.desafio.foursales.convert.BandeiraConvert;
import com.desafio.foursales.entity.enums.BandeiraEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CARTAO")
public class CartaoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3255353578936124765L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "numero", length = 16)
	private String numero;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datavalidade")
	private Date dataValidade;
	@Column(name = "codigoseguranca", length = 3)
	private long codigoSeguranca;
	@Convert(converter = BandeiraConvert.class)
	private BandeiraEnum bandeira;
	
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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	public long getCodigoSeguranca() {
		return codigoSeguranca;
	}
	public void setCodigoSeguranca(long codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}
	public BandeiraEnum getBandeira() {
		return bandeira;
	}
	public void setBandeira(BandeiraEnum bandeira) {
		this.bandeira = bandeira;
	}
	public CandidatoEntity getCandidato() {
		return candidato;
	}
	public void setCandidato(CandidatoEntity candidato) {
		this.candidato = candidato;
	}
	
	
		
}
