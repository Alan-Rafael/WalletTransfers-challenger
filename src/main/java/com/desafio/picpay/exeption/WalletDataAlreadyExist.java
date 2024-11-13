package com.desafio.picpay.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletDataAlreadyExist extends PicPayExeption{

    public String detail;

    

    public WalletDataAlreadyExist(String detail) {
        this.detail = detail;
    }



    @Override
    public ProblemDetail tProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        
        pb.setTitle("Wallet data already exists");
        pb.setDetail(detail);

        return pb;
    }

    
}
