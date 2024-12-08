package com.tradeinsurance.appcontainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tradeinsurance.appapplication",
        "com.tradeinsurance.appcontainer",
        "com.tradeinsurance.appapplicationservice",
        "com.tradeinsurance.appdomaincore"})
@EnableDiscoveryClient
public class AppContainerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppContainerApplication.class, args);
    }

}
