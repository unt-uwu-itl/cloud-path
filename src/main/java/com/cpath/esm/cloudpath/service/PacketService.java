package com.cpath.esm.cloudpath.service;

import com.cpath.esm.cloudpath.model.NetworkInterface;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PacketService {

    private final InterfaceService interfaceService;

    public PacketService(InterfaceService interfaceService) {
        this.interfaceService = interfaceService;
    }

    // Forwards a packet through the switch
    public void forwardPacket(String packetData) {
        Map<String, NetworkInterface> interfaces = interfaceService.getInterfaces();

        if (interfaces.isEmpty()) {
            System.out.println("Error: No interfaces are available to forward the packet.");
            return;
        }

        System.out.println("Forwarding packet: " + packetData);

        // Iterate over active interfaces and "send" the packet
        for (NetworkInterface networkInterface : interfaces.values()) {
            if (networkInterface.isActive()) {
                System.out.println("Packet forwarded to interface: " + networkInterface.getName());
                // Simulate forwarding the packet (could be more complex in a real application)
            } else {
                System.out.println("Skipping inactive interface: " + networkInterface.getName());
            }
        }
    }
}
