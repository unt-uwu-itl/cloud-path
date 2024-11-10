package com.cpath.esm.cloudpath.model.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    // MAC-ADDRESS-TABLE
    public static final String MAC_ADDRESS_TABLE = "mac_address_table";
    public static final String VLAN = "vlan";
    public static final String MAC_ADDRESS = "mac_address";
    public static final String TYPE = "type";
    public static final String PORT_NUMBER = "port_number";
    public static final String PORT_TYPE = "port_type";

    public static final String INTERFACES_TABLE = "interfaces";
    public static final String ETHERNET_TYPE = "ethernet_type";
    public static final String INTERFACE_NUMBER = "interface_number";
    public static final String NAME = "name";
    public static final String UPLINK_BANDWIDTH = "uplink_bandwidth";
    public static final String ARP_TIMEOUT = "arp_timeout";
    public static final String QUEUE_STRATEGY = "queue_strategy";
    public static final String OUTPUT_QUEUE_SIZE = "output_queue_size";
}
