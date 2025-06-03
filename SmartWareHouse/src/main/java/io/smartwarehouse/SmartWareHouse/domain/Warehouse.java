package io.smartwarehouse.SmartWareHouse.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<StorageZone> zones;

    public Warehouse(){}

    public Warehouse(String name, String adress){
        this.name = name;
        this.address = adress;
    }
}
