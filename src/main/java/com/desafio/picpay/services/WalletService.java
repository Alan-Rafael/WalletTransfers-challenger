package com.desafio.picpay.services;

import org.springframework.stereotype.Service;

import com.desafio.picpay.dtos.WalletCreateDto;
import com.desafio.picpay.entity.Wallet;
import com.desafio.picpay.exeption.WalletDataAlreadyExist;
import com.desafio.picpay.repository.WalletRepository;

@Service
public class WalletService {

    final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet create(WalletCreateDto walletDto){
        
        var wallet = walletRepository.findByCpfCnpjOrEmail(walletDto.cpfCnpj(), walletDto.email());
        if(wallet.isPresent()){
            throw new WalletDataAlreadyExist("Cpf/Cnpj or email already exist");
        }
        return walletRepository.save(walletDto.toWallet());
    }

    

}
