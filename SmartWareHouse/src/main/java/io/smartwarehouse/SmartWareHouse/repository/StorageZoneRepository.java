package io.smartwarehouse.SmartWareHouse.repository;

import io.smartwarehouse.SmartWareHouse.domain.StorageZone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StorageZoneRepository extends JpaRepository<StorageZone, Long> {
    List<StorageZone> findByWarehouseId(Long warehouseId);
}
