package com.tradeinsurance.reviewdomaincore.event;

import com.tradeinsurance.commonlibrary.domain.event.DomainEvent;
import com.tradeinsurance.reviewdomaincore.entity.Review;

import java.time.ZonedDateTime;
import java.util.List;

public class ReviewEvent implements DomainEvent<Review> {

    private final Review review;
    private ZonedDateTime createdAt;

    public ReviewEvent(Review review, ZonedDateTime createdAt) {
        this.review = review;
        this.createdAt = createdAt;
    }

    public Review getReview() {
        return review;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
