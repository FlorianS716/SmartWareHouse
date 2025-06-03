package io.smartwarehouse.SmartWareHouse.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class StorageLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private double maxWeight;
    private int maxCap;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private StorageLocation location;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private StorageZone zone;

    @OneToMany(mappedBy = "locationCode", cascade = CascadeType.ALL)
    private List<Item> items;

    public StorageLocation(){}

    public StorageLocation(Long id, String code, double maxWeight, int maxCap, StorageLocation location, StorageZone zone, List<Item> items) {
        this.id = id;
        this.code = code;
        this.maxWeight = maxWeight;
        this.maxCap = maxCap;
        this.location = location;
        this.zone = zone;
        this.items = items;
    }


    public void setBezeichnung(String bezeichnung) {
    }

    public void setStorageZone(StorageZone storageZone) {

    }
}
