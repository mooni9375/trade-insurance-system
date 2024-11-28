package com.tradeinsurance.appdomaincore.event;

import com.tradeinsurance.appdomaincore.entity.App;
import com.tradeinsurance.commonlibrary.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public class AppEvent implements DomainEvent<App> {

    private final App app;
    private final ZonedDateTime createdAt;

    public AppEvent(App app, ZonedDateTime createdAt) {
        this.app = app;
        this.createdAt = createdAt;
    }

    public App getApp() {
        return app;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
