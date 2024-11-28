package com.tradeinsurance.appapplicationservice.ports.output.message.publisher.review;

import com.tradeinsurance.appdomaincore.event.AppCreatedEvent;
import com.tradeinsurance.commonlibrary.domain.event.publisher.DomainEventPublisher;

public interface ReviewRequestMessagePublisher extends DomainEventPublisher<AppCreatedEvent> {
}
