package com.example.taxcalculator.model;

import lombok.Data;

@Data
public class TaxResponse {

	private boolean success;
	private String message;
	private double tax;

	public TaxResponse() {}

	public TaxResponse(boolean success, String message, double tax) {
		this.success = success;
		this.message = message;
		this.tax = tax;
	}
}
