package com.desafio.picpay.dtos;


import java.math.BigDecimal;

import com.desafio.picpay.entity.Wallet;
import com.desafio.picpay.entity.WalletType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record WalletCreateDto(
    @NotBlank String fullName,
    @NotBlank String cpfCnpj,
    @NotBlank String email,
    @NotNull  BigDecimal balance,
    @NotBlank String password,
    @NotBlank WalletType.Enum walletType){ 

    public Wallet toWallet(){
        return new Wallet(
            fullName,
            cpfCnpj,
            email,
            balance,
            password,
            walletType.get()
        );
    }
    } 
