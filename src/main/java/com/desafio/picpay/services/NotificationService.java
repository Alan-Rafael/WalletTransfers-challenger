package com.desafio.picpay.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.desafio.picpay.client.NotificationClient;
import com.desafio.picpay.entity.Transfer;

@Service
public class NotificationService {
    
    private static final Logger logger = LoggerFactory.getLogger(NotificationClient.class);


    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification(Transfer transfer){
        try{

            logger.info("Sendign notification...");

            var response = notificationClient.senn(transfer);

            if(response.getStatusCode().isError()){
                logger.error("Error while sending notification, status code is not OK");
            }

        } catch(Exception e){
            logger.error("Error while sendig notification", e);
        }
    }
}
