package com.example.taxcalculator.strategy;

public interface TaxStrategyInterface {
	String getCountryCode();
	double calculateTax(double value);
}
