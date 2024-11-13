package com.desafio.picpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.picpay.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, String>{

    Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);


    
}