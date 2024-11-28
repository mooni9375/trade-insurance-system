package com.tradeinsurance.reviewdomaincore.exception;

import com.tradeinsurance.commonlibrary.domain.exception.DomainException;

public class ReviewNotFoundException extends DomainException {

    public ReviewNotFoundException(String message) {
        super(message);
    }

    public ReviewNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
