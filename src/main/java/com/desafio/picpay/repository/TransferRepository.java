package com.desafio.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.picpay.entity.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, String> {

    
} 
