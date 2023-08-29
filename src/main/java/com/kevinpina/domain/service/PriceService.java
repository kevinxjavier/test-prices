package com.kevinpina.domain.service;

import java.util.Date;
import java.util.Optional;

import com.kevinpina.domain.model.Price;

public interface PriceService {

	Optional<Price> findAllByProductIdAndDateBetweenStartDateAndEndDate(Long productId, Date date);

}
