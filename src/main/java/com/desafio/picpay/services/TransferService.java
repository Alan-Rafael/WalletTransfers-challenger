package com.desafio.picpay.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.desafio.picpay.dtos.TransferDto;
import com.desafio.picpay.entity.Transfer;
import com.desafio.picpay.entity.Wallet;
import com.desafio.picpay.exeption.InsufficientBalanceExceotion;
import com.desafio.picpay.exeption.TransferNotAllowedForWalletTypeException;
import com.desafio.picpay.exeption.TransferNotAuthorizedException;
import com.desafio.picpay.exeption.WalletNotFoundException;
import com.desafio.picpay.repository.TransferRepository;
import com.desafio.picpay.repository.WalletRepository;

import jakarta.transaction.Transactional;

@Service
public class TransferService {
    final TransferRepository tranferRepository;
    final NotificationService notificationService;
    final AuthorizationService authorizationService;
    final WalletRepository walletRepository;


    public TransferService(TransferRepository tranferRepository,
                        NotificationService notificationService,
                        AuthorizationService authorizationService, 
                        WalletRepository walletRepository) {
        this.tranferRepository = tranferRepository;
        this.notificationService = notificationService;
        this.authorizationService = authorizationService;
        this.walletRepository = walletRepository;
    }

    @Transactional
    public Transfer transfer(TransferDto dto){
        System.out.println("ATE AQUI 0 ok");


        var sender = walletRepository.findById(dto.payer())
                        .orElseThrow(()-> new  WalletNotFoundException(dto.payer()));

        var reciver = walletRepository.findById(dto.payee())
                        .orElseThrow(()-> new  WalletNotFoundException(dto.payee()));

        validateTranser(dto, sender);

        sender.debit(dto.value());
        reciver.credit(dto.value());
        var transfer = new Transfer(sender, reciver, dto.value());

        walletRepository.save(sender);
        walletRepository.save(reciver);

        var transferResult = tranferRepository.save(transfer);

        CompletableFuture.runAsync(()-> notificationService.sendNotification(transferResult));
        return transferResult;
    }

    private void validateTranser(TransferDto dto, Wallet sender) {

        if(!sender.isTransferAllowdForWalletType()){
            throw new TransferNotAllowedForWalletTypeException();
        }

        if(!sender.isBalanceBiggerThan(dto.value())){
            throw new InsufficientBalanceExceotion();
        }

        if(!authorizationService.isAuthorized(dto)){
            throw new TransferNotAuthorizedException();
        }
                
    }
}
