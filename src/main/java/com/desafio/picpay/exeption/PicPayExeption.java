package com.desafio.picpay.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PicPayExeption extends RuntimeException{
    
    public ProblemDetail tProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("Pic pay internal server error");
        pb.setDetail(getLocalizedMessage());

        return pb;
    }

}
