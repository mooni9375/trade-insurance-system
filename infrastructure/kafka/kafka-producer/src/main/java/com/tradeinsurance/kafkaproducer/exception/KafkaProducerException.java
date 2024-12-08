package com.tradeinsurance.kafkaproducer.exception;

public class KafkaProducerException extends RuntimeException {

    public KafkaProducerException(String message) {
        super(message);
    }
}
