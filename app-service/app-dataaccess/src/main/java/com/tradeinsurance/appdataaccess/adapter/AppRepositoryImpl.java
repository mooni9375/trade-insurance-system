package com.tradeinsurance.appdataaccess.adapter;

import com.tradeinsurance.appapplicationservice.ports.output.repository.AppRepository;
import com.tradeinsurance.appdataaccess.mapper.AppDataAccessMapper;
import com.tradeinsurance.appdataaccess.repository.AppJpaRepository;
import com.tradeinsurance.appdomaincore.entity.App;
import com.tradeinsurance.commonlibrary.domain.valueobject.AppId;

import java.util.Optional;

public class AppRepositoryImpl implements AppRepository {

    private final AppJpaRepository appJpaRepository;
    private final AppDataAccessMapper appDataAccessMapper;

    public AppRepositoryImpl(AppJpaRepository appJpaRepository,
                             AppDataAccessMapper appDataAccessMapper) {
        this.appJpaRepository = appJpaRepository;
        this.appDataAccessMapper = appDataAccessMapper;
    }


    @Override
    public App save(App app) {
        return appDataAccessMapper.appEntityToApp(
                appJpaRepository.save(appDataAccessMapper.appToAppEntity(app))
                );
    }

//    @Override
//    public Optional<App> findById(AppId appId) {
//        return Optional.empty();
//    }

}





