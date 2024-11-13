package com.desafio.picpay.controller;

import org.springframework.web.bind.annotation.RestController;

import com.desafio.picpay.dtos.TransferDto;
import com.desafio.picpay.entity.Transfer;
import com.desafio.picpay.services.TransferService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TransferControll {
    private final TransferService transferService;

    public TransferControll(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> doTransfer(@RequestBody TransferDto transfer){
        return ResponseEntity.ok(transferService.transfer(transfer));
    }
    
    
    
}
