package io.smartwarehouse.SmartWareHouse.repository;

import io.smartwarehouse.SmartWareHouse.domain.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse,Long> {
    List<Warehouse> findByName(String name);
}
