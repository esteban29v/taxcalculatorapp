package com.example.taxcalculator.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.example.taxcalculator.strategy.TaxStrategyInterface;

@Service
public class TaxService implements InitializingBean {

	private final List<TaxStrategyInterface> TaxRates;
	private final Map<String, TaxStrategyInterface> TaxRatesMap = new HashMap<>();

	public TaxService(List<TaxStrategyInterface> taxRates) {
		this.TaxRates = taxRates;
	}

	@Override
	public void afterPropertiesSet() {
		System.out.println("Initializing Tax Service");
		for (TaxStrategyInterface taxRate : TaxRates) {
			TaxRatesMap.put(taxRate.getCountryCode(), taxRate);
		}
	}

	public double calculateTax(double value, String contryCode) {

		TaxStrategyInterface taxRate = TaxRatesMap.get(contryCode);

		if (taxRate == null) {
			throw new RuntimeException("Country code not found");
		}

		return taxRate.calculateTax(value);
	}
}
