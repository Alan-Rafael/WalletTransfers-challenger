package com.desafio.picpay.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends PicPayExeption {

    private String walletId;

    public WalletNotFoundException(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public ProblemDetail tProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Wallet not found");
        pb.setDetail("There is no wallet whit id "+ walletId);
        return pb;
        
    }

}
