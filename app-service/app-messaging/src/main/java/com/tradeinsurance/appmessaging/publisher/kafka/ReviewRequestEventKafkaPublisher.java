package com.tradeinsurance.appmessaging.publisher.kafka;

import com.tradeinsurance.appapplicationservice.ports.output.message.publisher.review.ReviewRequestMessagePublisher;
import com.tradeinsurance.appdomaincore.event.AppCreatedEvent;

public class ReviewRequestEventKafkaPublisher implements ReviewRequestMessagePublisher {

    @Override
    public void publish(AppCreatedEvent appCreatedEvent) {

    }
}
