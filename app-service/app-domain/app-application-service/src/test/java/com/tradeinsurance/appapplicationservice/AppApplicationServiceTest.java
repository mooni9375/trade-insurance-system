package com.tradeinsurance.appapplicationservice;

import com.tradeinsurance.appapplicationservice.dto.create.AppStreetAddress;
import com.tradeinsurance.appapplicationservice.dto.create.CreateAppCommand;
import com.tradeinsurance.appapplicationservice.dto.create.CreateAppResponse;
import com.tradeinsurance.appapplicationservice.mapper.AppDataMapper;
import com.tradeinsurance.appapplicationservice.ports.input.service.AppApplicationService;
import com.tradeinsurance.appapplicationservice.ports.output.repository.AppRepository;
import com.tradeinsurance.appapplicationservice.ports.output.repository.CustomerRepository;
import com.tradeinsurance.appdomaincore.entity.App;
import com.tradeinsurance.appdomaincore.entity.Customer;
import com.tradeinsurance.appdomaincore.exception.AppDomainException;
import com.tradeinsurance.commonlibrary.domain.valueobject.AppId;
import com.tradeinsurance.commonlibrary.domain.valueobject.AppStatus;
import com.tradeinsurance.commonlibrary.domain.valueobject.CountryCode;
import com.tradeinsurance.commonlibrary.domain.valueobject.CustomerId;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = TestConfiguration.class)
public class AppApplicationServiceTest {

    // Configuration 클래스에 정의된 Bean 주입
    // 단, 다른 클래스들과 다르게, AppDomainService 객체는 Mock 객체가 아닌 실제 객체 사용

    private AppApplicationService appApplicationService;
    private AppDataMapper appDataMapper;
    private AppRepository appRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public AppApplicationServiceTest(AppApplicationService appApplicationService,
                                     AppDataMapper appDataMapper,
                                     AppRepository appRepository,
                                     CustomerRepository customerRepository) {
        this.appApplicationService = appApplicationService;
        this.appDataMapper = appDataMapper;
        this.appRepository = appRepository;
        this.customerRepository = customerRepository;
    }

    private CreateAppCommand createAppCommand;
    private CreateAppCommand createAppCommandAppAmountIsUnder5000;
    private CreateAppCommand createAppCommandAppAmountIsNotUnitOf1000;

    private final UUID CUSTOMER_ID = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb41");
    private final UUID APP_ID      = UUID.fromString("15a497c1-0f4b-4eff-b9f4-c402c8c07afb");

    private final BigDecimal APP_AMOUNT = new BigDecimal("7000.00");

    @BeforeAll
    public void init() {
        createAppCommand = CreateAppCommand.builder()
                .customerId(CUSTOMER_ID)
                .exporterName("Exporter Tester")
                .exporterAddress(AppStreetAddress.builder()
                        .city("SEOUL")
                        .street("JONGRO")
                        .postalCode("12345")
                        .build())
                .importerCountryCode(CountryCode.UNITED_KINGDOM)
                .importerName("Importer Exeter")
                .importerAddress(AppStreetAddress.builder()
                        .city("EXETER")
                        .street("EXETER STREET")
                        .postalCode("77777")
                        .build())
                .exportProduct("Test Product")
                .appAmount(new BigDecimal("7000.00"))
                .build();

        createAppCommandAppAmountIsUnder5000 = CreateAppCommand.builder()
                .customerId(CUSTOMER_ID)
                .exporterName("Exporter Tester")
                .exporterAddress(AppStreetAddress.builder()
                        .city("SEOUL")
                        .street("JONGRO")
                        .postalCode("12345")
                        .build())
                .importerCountryCode(CountryCode.UNITED_KINGDOM)
                .importerName("Importer Exeter")
                .importerAddress(AppStreetAddress.builder()
                        .city("EXETER")
                        .street("EXETER STREET")
                        .postalCode("77777")
                        .build())
                .exportProduct("Test Product")
                .appAmount(new BigDecimal("4999.00"))
                .build();

        createAppCommandAppAmountIsNotUnitOf1000 = CreateAppCommand.builder()
                .customerId(CUSTOMER_ID)
                .exporterName("Exporter Tester")
                .exporterAddress(AppStreetAddress.builder()
                        .city("SEOUL")
                        .street("JONGRO")
                        .postalCode("12345")
                        .build())
                .importerCountryCode(CountryCode.UNITED_KINGDOM)
                .importerName("Importer Exeter")
                .importerAddress(AppStreetAddress.builder()
                        .city("EXETER")
                        .street("EXETER STREET")
                        .postalCode("77777")
                        .build())
                .exportProduct("Test Product")
                .appAmount(new BigDecimal("7500.00"))
                .build();


        // Customer 생성
        Customer customer = new Customer(new CustomerId(CUSTOMER_ID));

        // App 생성
        App app = appDataMapper.createAppCommandToApp(createAppCommand);
        app.setId(new AppId(APP_ID));


        // Mocking - customerRepository.findCustomer(CUSTOMER_ID) 호출 시, Optional.of(customer) 반환
        when(customerRepository.findCustomerById(CUSTOMER_ID)).thenReturn(Optional.of(customer));

        // Mocking - appRepository.save(app) 호출 시, app 반환
        when(appRepository.save(any(App.class))).thenReturn(app);
    }

    @Test
    public void testCreateApp() {
        CreateAppResponse createAppResponse = appApplicationService.createApp(createAppCommand);

        log.info("createAppResponse.getMessage() :: >> " + createAppResponse.getMessage());
        assertEquals( AppStatus.SUBMITTED, createAppResponse.getAppStatus());
        assertEquals("App created successfully.", createAppResponse.getMessage());
    }

    @Test
    public void testAppAmountIsUnder5000() {
        AppDomainException appDomainException = assertThrows(AppDomainException.class,
                () -> appApplicationService.createApp(createAppCommandAppAmountIsUnder5000));

        assertEquals("App amount must be Greater than $ 5,000", appDomainException.getMessage());
    }

    @Test
    public void testAppAmountIsNotUnitOf1000() {
        AppDomainException appDomainException = assertThrows(AppDomainException.class,
                () -> appApplicationService.createApp(createAppCommandAppAmountIsNotUnitOf1000));

        assertEquals("App amount is not multiple of $ 1,000", appDomainException.getMessage());
    }
































}
