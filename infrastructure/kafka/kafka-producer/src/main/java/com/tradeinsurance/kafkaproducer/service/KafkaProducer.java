package com.tradeinsurance.kafkaproducer.service;

public interface KafkaProducer<String, V>  {

    public void send(String topic, V message);
}
