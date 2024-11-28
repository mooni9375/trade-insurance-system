package com.tradeinsurance.appdomaincore.entity;

import com.tradeinsurance.commonlibrary.domain.entity.AggregateRoot;
import com.tradeinsurance.commonlibrary.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {

    public Customer() {
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }

}
