package com.tradeinsurance.appdomaincore.exception;


import com.tradeinsurance.commonlibrary.domain.exception.DomainException;

public class AppDomainException extends DomainException {

    public AppDomainException(String message) {
        super(message);
    }

    public AppDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}


