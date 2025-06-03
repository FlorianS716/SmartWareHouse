package io.smartwarehouse.SmartWareHouse.repository;

import io.smartwarehouse.SmartWareHouse.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByNameIgnoreCase(String name);
    List<Item> findByLocationCode(String code);
}
