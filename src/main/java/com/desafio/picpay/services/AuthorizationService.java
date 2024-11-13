package com.desafio.picpay.services;

import org.springframework.stereotype.Service;

import com.desafio.picpay.exeption.PicPayExeption;
import com.desafio.picpay.client.AuthorizationClient;
import com.desafio.picpay.dtos.TransferDto;

@Service
public class AuthorizationService {
    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    @SuppressWarnings("null")
    public boolean isAuthorized(TransferDto dto){

        var resp = authorizationClient.isAuthorized();

        if (resp.getStatusCode().isError()) {
            throw new PicPayExeption();
        }

        return resp.getBody().authorized();
    }
    
}
