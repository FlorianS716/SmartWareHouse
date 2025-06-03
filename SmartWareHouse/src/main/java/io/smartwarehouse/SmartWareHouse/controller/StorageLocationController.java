package io.smartwarehouse.SmartWareHouse.controller;

import io.smartwarehouse.SmartWareHouse.domain.StorageLocation;
import io.smartwarehouse.SmartWareHouse.domain.StorageZone;
import io.smartwarehouse.SmartWareHouse.dto.StorageLocationRequest;
import io.smartwarehouse.SmartWareHouse.repository.StorageLocationRepository;
import io.smartwarehouse.SmartWareHouse.repository.StorageZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/storage-locations")
public class StorageLocationController {

    private final StorageLocationRepository storageLocationRepository;
    private final StorageZoneRepository storageZoneRepository;

    @Autowired
    public StorageLocationController(StorageLocationRepository storageLocationRepository,
                                     StorageZoneRepository storageZoneRepository) {
        this.storageLocationRepository = storageLocationRepository;
        this.storageZoneRepository = storageZoneRepository;
    }


    // Lagerplatz anlegen
    @PostMapping
    public ResponseEntity<?> createStorageLocation(@RequestBody StorageLocationRequest request) {
        Optional<StorageZone> optionalZone = storageZoneRepository.findById(request.getStorageZoneId());

        if (optionalZone.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body("StorageZone mit ID " + request.getStorageZoneId() + " nicht gefunden.");
        }

        StorageLocation location = new StorageLocation();
        location.setCode(request.getCode());
        location.setBezeichnung(request.getBezeichnung());
        location.setStorageZone(optionalZone.get());

        StorageLocation savedLocation = storageLocationRepository.save(location);
        return ResponseEntity.ok(savedLocation);
    }

    // Alle Lagerplätze abrufen
    @GetMapping
    public ResponseEntity<List<StorageLocation>> getAllLocations() {
        return ResponseEntity.ok(storageLocationRepository.findAll());
    }

    // Einzelnen Lagerplatz nach Code abrufen
    @GetMapping("/by-code/{code}")
    public ResponseEntity<?> getByCode(@PathVariable String code) {
        return storageLocationRepository.findByCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.status(404).build()
                );
    }


}

