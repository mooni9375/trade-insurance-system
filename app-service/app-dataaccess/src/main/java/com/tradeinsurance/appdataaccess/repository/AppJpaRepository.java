package com.tradeinsurance.appdataaccess.repository;

import com.tradeinsurance.appdataaccess.entity.AppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppJpaRepository extends JpaRepository<AppEntity, UUID> {

}
