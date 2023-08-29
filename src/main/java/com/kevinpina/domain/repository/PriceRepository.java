package com.kevinpina.domain.repository;

import java.util.Date;

import com.kevinpina.domain.model.Price;

public interface PriceRepository {

	Price findAllByProductIdAndDateBetweenStartDateAndEndDate(Long productId, Date date);

}
