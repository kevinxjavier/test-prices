package com.kevinpina.application.api;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kevinpina.application.model.PriceDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Price", description = "Price management APIs")
@RequestMapping("/api")
public interface PriceAPI {

	@Operation(summary = "Retrieve the price by productId", description = "Return as output data: product identifier, chain identifier, rate to apply, dates of application and final price to apply.", tags = {
			"Price" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = PriceDTO.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Products Not found", content = {
					@Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", description = "Unexpected error", content = {
					@Content(schema = @Schema()) }) })
	@GetMapping("/price/{productId}/{date}")
	ResponseEntity<PriceDTO> getPrice(@PathVariable("productId") @Valid Long productId,
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Valid Date date);

}
