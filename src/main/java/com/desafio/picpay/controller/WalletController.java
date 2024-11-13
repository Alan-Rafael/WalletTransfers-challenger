package com.desafio.picpay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.picpay.dtos.WalletCreateDto;
import com.desafio.picpay.entity.Wallet;
import com.desafio.picpay.repository.WalletRepository;
import com.desafio.picpay.services.WalletService;

@RestController
public class WalletController {

    final WalletService walletService;
    final WalletRepository walletRepository;
    
    public WalletController(WalletService walletService, WalletRepository walletRepository) {
        this.walletService = walletService;
        this.walletRepository = walletRepository;
    }

    @PostMapping("/wallet")
        public ResponseEntity<Wallet>createWallet(@RequestBody WalletCreateDto walletDto){ 
            var wallet = walletService.create(walletDto);
            return ResponseEntity.ok(wallet);
    }
}
    

