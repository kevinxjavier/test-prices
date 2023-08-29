package com.kevinpina.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kevinpina.application.model.PriceDTO;
import com.kevinpina.domain.model.Price;

@Mapper
public interface PriceMapper {

	PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

	PriceDTO convertFrom(Price price);

}
