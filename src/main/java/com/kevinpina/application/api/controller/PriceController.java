package com.kevinpina.application.api.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kevinpina.application.api.PriceAPI;
import com.kevinpina.application.mapper.PriceMapper;
import com.kevinpina.application.model.PriceDTO;
import com.kevinpina.domain.service.PriceService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PriceController implements PriceAPI {

	private static final String NOT_FOUND_PRICE_MESSAGE = "NOT FOUND PRICE";

	@Autowired
	private PriceService priceService;

	private PriceMapper priceMapper;

	public PriceController() {
		priceMapper = PriceMapper.INSTANCE;
	}

	@Override
	public ResponseEntity<PriceDTO> getPrice(@Valid Long productId, @Valid Date date) {
		LOGGER.info("Getting price for productId {} and date {}", productId, date);
		return new ResponseEntity<>(
				priceMapper.convertFrom(
						priceService.findAllByProductIdAndDateBetweenStartDateAndEndDate(productId, date).orElseThrow(
								() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_PRICE_MESSAGE))),
				HttpStatus.OK);
	}

}
