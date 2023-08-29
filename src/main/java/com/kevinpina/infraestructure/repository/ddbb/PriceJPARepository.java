package com.kevinpina.infraestructure.repository.ddbb;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kevinpina.infraestructure.model.entity.PriceEntity;

public interface PriceJPARepository extends JpaRepository<PriceEntity, UUID> {

	List<PriceEntity> findByProductId(Long productId);

	@Query(value = "SELECT * FROM prices WHERE product_id = :productId AND :date BETWEEN start_date AND end_date", nativeQuery = true)
	List<PriceEntity> findAllByProductIdAndDateBetweenStartDateAndEndDate(Long productId, Date date);

}
