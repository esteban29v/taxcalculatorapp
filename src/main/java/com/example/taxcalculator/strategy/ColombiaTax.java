package com.example.taxcalculator.strategy;

import org.springframework.stereotype.Component;

@Component
public class ColombiaTax implements TaxStrategyInterface {

	public String getCountryCode() {
		return "CO";
	}

	public double calculateTax(double value) {
		return value * 0.1;
	}

}
