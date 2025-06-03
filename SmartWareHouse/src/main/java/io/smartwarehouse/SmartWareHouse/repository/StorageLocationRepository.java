package io.smartwarehouse.SmartWareHouse.repository;

import io.smartwarehouse.SmartWareHouse.domain.StorageLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageLocationRepository extends JpaRepository<StorageLocation, Long> {
    Optional<StorageLocation> findByCode(String code);
}

