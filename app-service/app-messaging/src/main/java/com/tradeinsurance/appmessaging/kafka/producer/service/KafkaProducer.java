package com.tradeinsurance.appmessaging.kafka.producer.service;

public interface KafkaProducer<String, V> {

    public void send(String topic, V message);
}
