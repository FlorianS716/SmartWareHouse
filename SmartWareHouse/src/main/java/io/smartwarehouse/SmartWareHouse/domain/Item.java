package io.smartwarehouse.SmartWareHouse.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private double weight;
    private int anzahl;
    private String locationCode;

    public Item(){}

    public Item(Long id, String name, String code, double weight, int anzahl, String locationCode) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.weight = weight;
        this.anzahl = anzahl;
        this.locationCode = locationCode;
    }

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private StorageLocation location;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getWeight() {
        return weight;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
}