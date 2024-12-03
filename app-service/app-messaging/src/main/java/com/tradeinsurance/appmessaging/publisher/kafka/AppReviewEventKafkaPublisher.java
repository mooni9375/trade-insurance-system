package com.tradeinsurance.appmessaging.publisher.kafka;

import com.tradeinsurance.appapplicationservice.dto.message.AppReviewMessage;
import com.tradeinsurance.appapplicationservice.ports.output.message.publisher.review.ReviewRequestMessagePublisher;
import com.tradeinsurance.appdomaincore.event.AppCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 현재는 AppDomainService.AppCreateCommandHandler.createApp() 에서 직접 호출
 */
@Slf4j
@Component
public class AppReviewEventKafkaPublisher implements ReviewRequestMessagePublisher {

    @Override
    public void publish(AppReviewMessage appReviewMessage) {

        // AppReviewMessage -> reviewRequestJsonModel : 변환 필요

    }
}
