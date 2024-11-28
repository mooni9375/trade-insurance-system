package com.tradeinsurance.appdataaccess.adapter;

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

}





