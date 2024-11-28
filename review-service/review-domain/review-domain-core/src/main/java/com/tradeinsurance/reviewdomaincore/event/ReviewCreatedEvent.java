package com.tradeinsurance.reviewdomaincore.event;

import com.tradeinsurance.reviewdomaincore.entity.Review;

import java.time.ZonedDateTime;
import java.util.List;

public class ReviewCreatedEvent extends ReviewEvent {

    public ReviewCreatedEvent(Review review, ZonedDateTime createdAt) {
        super(review, createdAt);
    }
}
