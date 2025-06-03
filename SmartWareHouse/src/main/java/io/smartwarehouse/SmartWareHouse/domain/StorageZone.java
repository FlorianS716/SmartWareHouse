package io.smartwarehouse.SmartWareHouse.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class StorageZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
    private List<StorageLocation> locations;

    public StorageZone(){}

    public StorageZone(Warehouse warehouse, String name) {
        this.warehouse = warehouse;
        this.name = name;
    }

}
