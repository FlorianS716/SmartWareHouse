package io.smartwarehouse.SmartWareHouse.service;


import io.smartwarehouse.SmartWareHouse.domain.Item;
import io.smartwarehouse.SmartWareHouse.domain.StorageLocation;
import io.smartwarehouse.SmartWareHouse.dto.Itemdto;
import io.smartwarehouse.SmartWareHouse.repository.ItemRepository;
import io.smartwarehouse.SmartWareHouse.repository.StorageLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final StorageLocationRepository storageLocationRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, StorageLocationRepository storageLocationRepository) {
        this.itemRepository = itemRepository;
        this.storageLocationRepository = storageLocationRepository;
    }

    public Item createItem(Itemdto itemDto) {
        Item item = new Item();
        item.setCode(itemDto.getCode());
        item.setName(itemDto.getName());
        item.setWeight(itemDto.getWeight());
        item.setAnzahl(itemDto.getAnzahl());
        item.setLocationCode(itemDto.getLocationCode());

        StorageLocation location = storageLocationRepository
                .findByCode(itemDto.getLocationCode())
                .orElseThrow(() -> new RuntimeException("Lagerplatz wurde nicht gefunden: " + itemDto.getLocationCode()));

        item.setLocation(location);

        return itemRepository.save(item);
    }

    public Itemdto convertToDto(Item item) {
        return new Itemdto(
                item.getCode(),
                item.getName(),
                item.getWeight(),
                item.getAnzahl(),
                item.getLocationCode()
        );
    }

    public List<Itemdto> findAll() {
        return itemRepository.findAll().stream()
                .map(this::convertToDto)
                .toList();
    }
}
