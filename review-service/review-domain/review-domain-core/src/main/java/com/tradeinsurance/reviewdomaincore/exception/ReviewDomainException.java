package com.tradeinsurance.reviewdomaincore.exception;

import com.tradeinsurance.commonlibrary.domain.exception.DomainException;

public class ReviewDomainException extends DomainException {

    public ReviewDomainException(String message) {
        super(message);
    }

    public ReviewDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
