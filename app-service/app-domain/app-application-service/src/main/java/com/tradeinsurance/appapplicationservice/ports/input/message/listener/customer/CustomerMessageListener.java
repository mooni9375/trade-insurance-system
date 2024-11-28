package com.tradeinsurance.appapplicationservice.ports.input.message.listener.customer;

import com.tradeinsurance.appapplicationservice.dto.message.AppRequest;

public interface CustomerMessageListener {

    void onAppReceived(AppRequest appRequest);
}

