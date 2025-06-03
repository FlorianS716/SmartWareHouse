package io.smartwarehouse.SmartWareHouse.controller;

import io.smartwarehouse.SmartWareHouse.domain.Item;
import io.smartwarehouse.SmartWareHouse.dto.Itemdto;
import io.smartwarehouse.SmartWareHouse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Itemdto> createItem(@RequestBody Itemdto itemDto) {
        Item savedItem = itemService.createItem(itemDto);
        Itemdto responseDto = itemService.convertToDto(savedItem);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<Itemdto>> getAllItems() {
        return ResponseEntity.ok(itemService.findAll());
    }
}
