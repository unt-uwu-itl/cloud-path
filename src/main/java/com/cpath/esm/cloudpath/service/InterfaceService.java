package com.cpath.esm.cloudpath.service;

import com.cpath.esm.cloudpath.model.NetworkInterface;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InterfaceService {

    // A map to store interfaces by name
    private final Map<String, NetworkInterface> interfaces = new HashMap<>();

    // Adds a new interface
    public void addInterface(String interfaceName) {
        if (interfaces.containsKey(interfaceName)) {
            System.out.println("Error: Interface " + interfaceName + " already exists.");
        } else {
            NetworkInterface newInterface = new NetworkInterface(interfaceName);
            interfaces.put(interfaceName, newInterface);
            System.out.println("Interface " + interfaceName + " added successfully.");
        }
    }

    // Lists all available interfaces
    public void listInterfaces() {
        if (interfaces.isEmpty()) {
            System.out.println("No interfaces found.");
        } else {
            System.out.println("Available interfaces:");
            for (String interfaceName : interfaces.keySet()) {
                System.out.println(" - " + interfaceName);
            }
        }
    }

    // Removes an interface by name
    public void removeInterface(String interfaceName) {
        if (interfaces.containsKey(interfaceName)) {
            interfaces.remove(interfaceName);
            System.out.println("Interface " + interfaceName + " removed successfully.");
        } else {
            System.out.println("Error: Interface " + interfaceName + " does not exist.");
        }
    }

    // Shows details for a specific interface
    public void showInterface(String interfaceName) {
        NetworkInterface networkInterface = interfaces.get(interfaceName);
        if (networkInterface != null) {
            System.out.println("Details for interface " + interfaceName + ":");
            System.out.println(" - Name: " + networkInterface.getName());
            System.out.println(" - Status: " + (networkInterface.isActive() ? "Active" : "Inactive"));
        } else {
            System.out.println("Error: Interface " + interfaceName + " does not exist.");
        }
    }

    // Inside InterfaceService.java
    public Map<String, NetworkInterface> getInterfaces() {
        return interfaces;
    }

}
