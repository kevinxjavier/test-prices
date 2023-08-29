package com.kevinpina.infraestructure.adapter.repository;

import java.util.Comparator;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kevinpina.domain.model.Price;
import com.kevinpina.domain.repository.PriceRepository;
import com.kevinpina.infraestructure.mapper.PriceMapper;
import com.kevinpina.infraestructure.model.entity.PriceEntity;
import com.kevinpina.infraestructure.repository.ddbb.PriceJPARepository;

@Repository
@Transactional
public class PriceRepositoryImpl implements PriceRepository {

	@Autowired
	private PriceJPARepository priceJPARepository;

	private PriceMapper priceMapper;

	public PriceRepositoryImpl() {
		this.priceMapper = PriceMapper.INSTANCE;
	}

	@Override
	public Price findAllByProductIdAndDateBetweenStartDateAndEndDate(Long productId, Date date) {
		return priceMapper
				.convertFrom(priceJPARepository.findAllByProductIdAndDateBetweenStartDateAndEndDate(productId, date)
						.stream().max(Comparator.comparing(PriceEntity::getPriority)).orElse(null));
	}

}
