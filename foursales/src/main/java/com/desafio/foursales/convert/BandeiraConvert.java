package com.desafio.foursales.convert;

import java.util.Optional;

import javax.persistence.AttributeConverter;

import com.desafio.foursales.entity.enums.BandeiraEnum;

public class BandeiraConvert implements AttributeConverter<BandeiraEnum, String> {

	@Override
	public String convertToDatabaseColumn(BandeiraEnum user) {
		// TODO Auto-generated method stub
		return user.getSigla();
	}

	@Override
	public BandeiraEnum convertToEntityAttribute(String sigla) {
		// TODO Auto-generated method stub
		Optional<BandeiraEnum> temp = BandeiraEnum.findBySigla(sigla);
		return temp.orElseThrow(IllegalArgumentException::new);
	}

}
