package com.example.taxcalculator.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaxRequest {

    @NotBlank(message = "El código del país no puede estar vacío")
    private String country;

    @NotNull(message = "El monto no puede ser nulo")
    @Min(value = 0, message = "El monto debe ser mayor o igual a 0")
    private Double value;

    public TaxRequest(Double value, String country) {
        this.country = country;
        this.value = value;
    }
}