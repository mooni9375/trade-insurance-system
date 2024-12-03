package com.tradeinsurance.reviewapplicationservice.dto.message;

import com.tradeinsurance.commonlibrary.domain.valueobject.CountryCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class ReviewRequest {

    private String appId;
    private BigDecimal appAmount;
    private String importerCountryCode;
    private Instant createdAt;
}
