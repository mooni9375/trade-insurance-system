package com.tradeinsurance.appcontainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppContainerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppContainerApplication.class, args);
    }

}
