package com.tradeinsurance.reviewcontainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tradeinsurance.reviewapplication", "com.tradeinsurance.reviewcontainer"})
@EnableDiscoveryClient
public class ReviewContainerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReviewContainerApplication.class, args);
    }

}
