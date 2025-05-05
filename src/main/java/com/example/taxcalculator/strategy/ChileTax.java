package com.example.taxcalculator.strategy;

import org.springframework.stereotype.Component;

@Component
public class ChileTax implements TaxStrategyInterface {

	@Override
	public String getCountryCode() {
		return "CL";
	}

	@Override
	public double calculateTax(double value) {
		return calculateTaxPlusDividendos(value, 0.1);
	}

	private double calculateTaxPlusDividendos(double value, double rate) {
		return value + (value * rate);
	}
}
