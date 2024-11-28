package com.tradeinsurance.appdomaincore.event;

import com.tradeinsurance.appdomaincore.entity.App;

import java.time.ZonedDateTime;

public class AppCreatedEvent extends AppEvent {

    public AppCreatedEvent(App app, ZonedDateTime createdAt) {
        super(app, createdAt);
    }
}
