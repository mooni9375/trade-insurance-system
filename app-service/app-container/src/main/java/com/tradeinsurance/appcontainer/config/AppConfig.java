package com.tradeinsurance.appcontainer.config;

import com.tradeinsurance.appdomaincore.AppDomainService;
import com.tradeinsurance.appdomaincore.AppDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public AppDomainService appDomainService() {
        return new AppDomainServiceImpl();
    }

}
