package com.tradeinsurance.commonlibrary.domain.event.publisher;
import com.tradeinsurance.commonlibrary.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent>{

    void publish(T domainEvent);

}

