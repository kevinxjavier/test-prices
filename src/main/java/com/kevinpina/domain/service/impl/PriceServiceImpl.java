package com.kevinpina.domain.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinpina.domain.model.Price;
import com.kevinpina.domain.repository.PriceRepository;
import com.kevinpina.domain.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceRepository;

	public Optional<Price> findAllByProductIdAndDateBetweenStartDateAndEndDate(Long productId, Date date) {
		return Optional
				.ofNullable(priceRepository.findAllByProductIdAndDateBetweenStartDateAndEndDate(productId, date));
	}

}
