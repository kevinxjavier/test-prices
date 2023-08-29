package com.kevinpina.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kevinpina.domain.model.Price;
import com.kevinpina.infraestructure.model.entity.PriceEntity;

@Mapper
public interface PriceMapper {

	PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

	Price convertFrom(PriceEntity priceEntity);

}
