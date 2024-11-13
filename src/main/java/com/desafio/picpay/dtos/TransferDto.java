package com.desafio.picpay.dtos;

import java.math.BigDecimal;

// import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TransferDto(
    @DecimalMin("0.1")
    @NotNull BigDecimal value,
    @NotBlank String payer,
    @NotBlank String payee
) {
    
}
