package com.desafio.picpay.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAuthorizedException extends PicPayExeption{

    @Override
    public ProblemDetail tProblemDetail() {
      var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

      pb.setTitle("Transfer not authorized");
      pb.setDetail("Authorization service not authtoried this transfer");

      return pb;
    }
    
    
}
