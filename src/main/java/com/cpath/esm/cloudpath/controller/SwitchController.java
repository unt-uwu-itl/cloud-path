package com.cpath.esm.cloudpath.controller;

import com.cpath.esm.cloudpath.service.InterfaceService;
import com.cpath.esm.cloudpath.service.PacketService;
import org.springframework.stereotype.Controller;

@Controller
public class SwitchController {

    private final InterfaceService interfaceService;
    private final PacketService packetService;

    public SwitchController(InterfaceService interfaceService, PacketService packetService) {
        this.interfaceService = interfaceService;
        this.packetService = packetService;
    }

    // Processes commands received from the CLI
    public void processCommand(String command) {
        if (command.startsWith("add ")) {
            String interfaceName = command.substring(4).trim();
            if (!interfaceName.isEmpty()) {
                interfaceService.addInterface(interfaceName);
            } else {
                System.out.println("Error: Interface name cannot be empty.");
            }
        } else if (command.equals("list")) {
            interfaceService.listInterfaces();
        } else if (command.startsWith("remove ")) {
            String interfaceName = command.substring(7).trim();
            if (!interfaceName.isEmpty()) {
                interfaceService.removeInterface(interfaceName);
            } else {
                System.out.println("Error: Interface name cannot be empty.");
            }
        } else if (command.startsWith("show ")) {
            String interfaceName = command.substring(5).trim();
            if (!interfaceName.isEmpty()) {
                interfaceService.showInterface(interfaceName);
            } else {
                System.out.println("Error: Interface name cannot be empty.");
            }
        } else if (command.startsWith("forward ")) {
            String packetData = command.substring(8).trim();
            if (!packetData.isEmpty()) {
                packetService.forwardPacket(packetData);
            } else {
                System.out.println("Error: Packet data cannot be empty.");
            }
        } else {
            System.out.println("Unknown command. Type 'help' for a list of available commands.");
        }
    }
}
