package com.cpath.esm.cloudpath.command;

import com.cpath.esm.cloudpath.command.config.Constants;
import com.cpath.esm.cloudpath.model.ArpEntity;
import com.cpath.esm.cloudpath.service.ArpEntryService;
import com.cpath.esm.cloudpath.service.InterfaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

import java.util.List;

@Command(command = Constants.SHOW)
@RequiredArgsConstructor
public class ShowCommands {
    public final ArpEntryService arpEntryService;
    public final InterfaceService interfaceService;

    @Command(command = Constants.OPTIONS, description = "available options")
    public void showOptions() {
        System.out.printf("%s Arp table%n", Constants.ARP);
        System.out.printf("%s Interface status and configuration%n", Constants.INTERFACES);
        System.out.printf("%s Mac forwarding table%n", Constants.MAC_ADDRESS_TABLE);
    }

    @Command(command = Constants.ARP, description = "Arp table")
    public void showArp() {
        List<ArpEntity> arpEntries = arpEntryService.getAllArpEntries();

        if (arpEntries.isEmpty()) {
            System.out.println("No ARP entries found.");
            return;
        }

        // Print header
        String headerFormat = "%-10s %-20s %-10s %-20s %-6s %-10s%n";
        System.out.printf(headerFormat, "Protocol", "Address", "Age", "Hardware Addr", "Type", "Interface");

        // Print each entry using Java Streams for better readability
        arpEntries.forEach(entry -> System.out.printf(
                headerFormat,
                entry.getProtocol(),
                entry.getAddress(),
                entry.getAge(),
                entry.getHardwareAddress(),
                entry.getType(),
                entry.getInterfaceName()
        ));
    }

    @Command(command = Constants.INTERFACES, description = "Interface status and configuration")
    public void showInterfaces(
            @Option(longNames = Constants.OPTIONS, required = false) String options,
            @Option(longNames = Constants.FAST_ETHERNET) String fastEthernet,
            @Option(longNames = Constants.GIGABIT_ETHERNET) String gigabitEthernet,
            @Option(longNames = Constants.INT_NUM) String intNum,
            @Option(longNames = Constants.VLAN) String vlan,
            @Option(longNames = Constants.TRUNK) String trunk
    ) {
        if (options != null) {
            System.out.printf("%s FastEthernet IEEE 802.3%n", Constants.FAST_ETHERNET);
            System.out.printf("%s GigabitEthernet IEEE 802.3z%n", Constants.INTERFACES);
            System.out.printf("%s Catalyst Vlans%n", Constants.MAC_ADDRESS_TABLE);
            System.out.printf("%s Show interface trunk information%n", Constants.TRUNK);
        } else if (fastEthernet != null) {
            if (!intNum.isEmpty()) {
                interfaceService.findIntByEthernetTypeAndIntNumber(fastEthernet, intNum);
            } else {
                interfaceService.findInterfaceByEthernetType(fastEthernet);
            }
        } else if (gigabitEthernet != null) {
            if (!intNum.isEmpty()) {
                interfaceService.findIntByEthernetTypeAndIntNumber(gigabitEthernet, intNum);
            } else {
                interfaceService.findInterfaceByEthernetType(gigabitEthernet);
            }
        } else {
            interfaceService.findAll();
        }
    }
}