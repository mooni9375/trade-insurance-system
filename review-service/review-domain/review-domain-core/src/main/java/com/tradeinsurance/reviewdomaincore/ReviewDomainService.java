package com.tradeinsurance.reviewdomaincore;

import com.tradeinsurance.reviewdomaincore.entity.Review;
import com.tradeinsurance.reviewdomaincore.event.ReviewCreatedEvent;

public interface ReviewDomainService {

    ReviewCreatedEvent validateAndInitiateReview(Review review);
}
