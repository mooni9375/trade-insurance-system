package com.tradeinsurance.appmessaging.mapper;

import com.tradeinsurance.appapplicationservice.dto.message.AppReviewMessage;
import com.tradeinsurance.appmessaging.kafka.model.ReviewRequestModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AppMessagingDataMapper {

    public ReviewRequestModel appReviewMessageToReviewRequestModel(AppReviewMessage appReviewMessage) {

        return ReviewRequestModel.builder()
                .id(UUID.randomUUID().toString())
                .appId(appReviewMessage.getAppId())
                .appAmount(appReviewMessage.getAppAmount())
                .importerCountryCode(appReviewMessage.getImporterCountryCode())
                .createdAt(appReviewMessage.getCreatedAt())
                .build();

    }

}
