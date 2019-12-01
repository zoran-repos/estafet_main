package com.estafet.training.kafkaProject.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payments {
    private String paymentId;
    private String timestamp;
    private Float amount;
    private String currency;
    private String senderName;
    private String senderIBAN;
    private String receiverName;
    private String receiverIBAN;
}
