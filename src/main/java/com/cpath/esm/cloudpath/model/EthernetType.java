package com.cpath.esm.cloudpath.model;

import lombok.Getter;

@Getter
public enum EthernetType {
    FastEthernet("Fast Ethernet"),
    GigabitEthernet("Gigabit Ethernet");

    private final String description;

    EthernetType(String description) {
        this.description = description;
    }
}
