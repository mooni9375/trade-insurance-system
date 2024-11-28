package com.tradeinsurance.appapplicationservice;

import com.tradeinsurance.appapplicationservice.ports.output.message.publisher.review.ReviewRequestMessagePublisher;
import com.tradeinsurance.appapplicationservice.ports.output.repository.AppRepository;
import com.tradeinsurance.appapplicationservice.ports.output.repository.CustomerRepository;
import com.tradeinsurance.appdomaincore.AppDomainService;
import com.tradeinsurance.appdomaincore.AppDomainServiceImpl;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.tradeinsurance")
public class TestConfiguration {

    @Bean
    public ReviewRequestMessagePublisher reviewRequestMessagePublisher() {
        return Mockito.mock(ReviewRequestMessagePublisher.class);
    }

    @Bean
    public AppRepository appRepository() {
        return Mockito.mock(AppRepository.class);
    }

    @Bean
    public CustomerRepository customerRepository() {
        return Mockito.mock(CustomerRepository.class);
    }

    // mock 객체를 사용하지 않고, 실제 객체 사용
    @Bean
    public AppDomainService appDomainService() {
        return new AppDomainServiceImpl();
    }
}
