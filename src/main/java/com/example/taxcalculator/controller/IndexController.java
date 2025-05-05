package com.example.taxcalculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxcalculator.model.TaxRequest;
import com.example.taxcalculator.model.TaxResponse;
import com.example.taxcalculator.service.TaxService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/")
public class IndexController {

	private final TaxService taxService;

	public IndexController(TaxService taxService) {
		this.taxService = taxService;
	}

	@PostMapping("/tax/calculate")
	public ResponseEntity<TaxResponse> calculateTax(
		@Valid @RequestBody TaxRequest request
	) {
		try {
			Double value = request.getValue();
			String country = request.getCountry();

			Double result = taxService.calculateTax(value, country);
			return ResponseEntity.ok(new TaxResponse(true, "Tax calculated successfully", result));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new TaxResponse(true, "An error was ocurred while calculating tax", 0));
		}
	}
}
