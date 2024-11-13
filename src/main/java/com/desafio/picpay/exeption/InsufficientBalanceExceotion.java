package com.desafio.picpay.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsufficientBalanceExceotion extends PicPayExeption{

    @Override
    public ProblemDetail tProblemDetail() {
     var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

     pb.setTitle("Insuficiente balance");
     pb.setDetail("Seu saldo é insuficiente");

     return pb;
    }

}
