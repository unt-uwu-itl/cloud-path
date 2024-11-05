package com.cpath.esm.cloudpath.model;

public class NetworkInterface {

    private final String name;
    private boolean active;

    public NetworkInterface(String name) {
        this.name = name;
        this.active = true; // Default status is active upon creation
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

}
