package com.estafet.training.kafkaProject.service;

import com.estafet.training.kafkaProject.dao.PaymentsDaoImpl;
import com.estafet.training.kafkaProject.model.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class PaymentsConsumer {

    @Autowired
    PaymentsDaoImpl paymentsDaoImpl;

    @KafkaListener(topics = "payments", groupId = "consumer_for_db", clientIdPrefix = "json",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(Payments payments) {
        System.out.println("Consumed JSON Message: " + payments);
        paymentsDaoImpl.insertPayments(payments);
        System.out.println("JSON Message inserted with ID " + payments.getPaymentId());

    }

}
