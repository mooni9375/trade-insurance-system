package com.tradeinsurance.appdataaccess.mapper;

import com.tradeinsurance.appdataaccess.entity.AppEntity;
import com.tradeinsurance.appdataaccess.entity.AppStreetAddressEntity;
import com.tradeinsurance.appdomaincore.entity.App;
import com.tradeinsurance.appdomaincore.valueobject.StreetAddress;
import com.tradeinsurance.commonlibrary.domain.valueobject.AppId;
import com.tradeinsurance.commonlibrary.domain.valueobject.CustomerId;
import com.tradeinsurance.commonlibrary.domain.valueobject.Money;

import java.util.ArrayList;
import java.util.Arrays;

import static com.tradeinsurance.appdomaincore.entity.App.FAILURE_MESSAGE_DELIMITER;

public class AppDataAccessMapper {

    public AppEntity appToAppEntity(App app) {

        AppEntity appEntity = AppEntity.builder()
                .id(app.getId().getValue())
                .customerId(app.getCustomerId().getValue())
                .exporterName(app.getExporterName())
                .exporterAddress(streetAddressToAppStreetAddressEntity(app.getExporterAddress()))
                .importerCountryCode(app.getImporterCountryCode())
                .importerName(app.getImporterName())
                .importerAddress(streetAddressToAppStreetAddressEntity(app.getImporterAddress()))
                .exportProduct(app.getExportProduct())
                .appAmount(app.getAppAmount().getAmount())
                .appStatus(app.getAppStatus())
                .failureMessages(app.getFailureMessages() != null ?
                        String.join(FAILURE_MESSAGE_DELIMITER, app.getFailureMessages()) : "")
                .build();

        // 양방향 연관관계 설정
        appEntity.getExporterAddress().setApp(appEntity);

        return appEntity;
    }

    public App appEntityToApp(AppEntity appEntity) {
        return App.builder()
                .appId(new AppId(appEntity.getId()))
                .customerId(new CustomerId(appEntity.getCustomerId()))
                .exporterName(appEntity.getExporterName())
                .exporterAddress(appStreetAddressEntityToStreetAddress(appEntity.getExporterAddress()))
                .importerCountryCode(appEntity.getImporterCountryCode())
                .importerName(appEntity.getImporterName())
                .importerAddress(appStreetAddressEntityToStreetAddress(appEntity.getImporterAddress()))
                .exportProduct(appEntity.getExportProduct())
                .appAmount(new Money(appEntity.getAppAmount()))
                .appStatus(appEntity.getAppStatus())
                .failureMessages(appEntity.getFailureMessages().isEmpty() ? new ArrayList<>() :
                        new ArrayList<>(Arrays.asList(appEntity.getFailureMessages()
                                .split(FAILURE_MESSAGE_DELIMITER))))
                .build();
    }


    private AppStreetAddressEntity streetAddressToAppStreetAddressEntity(StreetAddress streetAddress) {
        return AppStreetAddressEntity.builder()
                .id(streetAddress.getId())
                .street(streetAddress.getStreet())
                .postalCode(streetAddress.getPostalCode())
                .city(streetAddress.getCity())
                .build();
    }

    private StreetAddress appStreetAddressEntityToStreetAddress(AppStreetAddressEntity appStreetAddressEntity) {
        return new StreetAddress(appStreetAddressEntity.getId(),
                appStreetAddressEntity.getStreet(),
                appStreetAddressEntity.getPostalCode(),
                appStreetAddressEntity.getCity());
    }

}
