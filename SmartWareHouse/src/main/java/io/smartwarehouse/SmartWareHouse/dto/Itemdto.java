package io.smartwarehouse.SmartWareHouse.dto;


import io.smartwarehouse.SmartWareHouse.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Itemdto {
    public String name;
    public String code;
    public double weight;
    public int anzahl;
    public String locationCode;

    public Itemdto(String name, String code, double weight, int anzahl, String locationCode) {
        this.name = name;
        this.code = code;
        this.weight = weight;
        this.anzahl = anzahl;
        this.locationCode = locationCode;
    }

    Item item = new Item();

}
