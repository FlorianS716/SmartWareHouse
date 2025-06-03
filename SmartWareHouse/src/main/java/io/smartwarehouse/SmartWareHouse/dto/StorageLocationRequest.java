package io.smartwarehouse.SmartWareHouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StorageLocationRequest {
    private String code;
    private String bezeichnung;
    private Long storageZoneId; // Referenz auf eine vorhandene StorageZone
}
