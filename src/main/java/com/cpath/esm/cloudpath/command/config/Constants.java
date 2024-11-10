package com.cpath.esm.cloudpath.command.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    // General command names constants
    public static final String OPTIONS = "?";
    public static final String SHOW = "show";
    public static final String CONFIGURE = "configure";

    // SHOW options commands
    public static final String ARP = "arp";
    public static final String INTERFACES = "interfaces";
    public static final String MAC_ADDRESS_TABLE = "mac-address-table";

    // INTERFACE options commands
    public static final String FAST_ETHERNET = "FastEthernet";
    public static final String GIGABIT_ETHERNET = "GigabitEthernet";
    public static final String INT_NUM = "num";
    public static final String VLAN = "vlan";
    public static final String TRUNK = "trunk";
}