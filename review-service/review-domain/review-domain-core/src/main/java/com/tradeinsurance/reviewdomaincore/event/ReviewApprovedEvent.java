package com.tradeinsurance.reviewdomaincore.event;

import com.tradeinsurance.reviewdomaincore.entity.Review;

import java.time.ZonedDateTime;
import java.util.Collections;

public class ReviewApprovedEvent extends ReviewEvent {

    public ReviewApprovedEvent(Review review,
                               ZonedDateTime createdAt) {
        super(review, createdAt, Collections.emptyList());
    }
}
