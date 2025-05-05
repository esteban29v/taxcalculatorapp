package com.example.taxcalculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxcalculator.model.TaxResponse;
import com.example.taxcalculator.service.TaxService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/")
public class IndexController {

	private final TaxService taxService;

	public IndexController(TaxService taxService) {
		this.taxService = taxService;
	}

	@GetMapping("/tax/calculate")
	public ResponseEntity<TaxResponse> calculateTax(
		@RequestParam(required = true) Double value,
		@RequestParam(required = true) String country
	) {
		try {
			Double result = taxService.calculateTax(value, country);
			return ResponseEntity.ok(new TaxResponse(true, "Tax calculated successfully", result));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new TaxResponse(true, "An error was ocurred while calculating tax", 0));
		}
	}
}
