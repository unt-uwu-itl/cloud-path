package com.cpath.esm.cloudpath.model;

import com.cpath.esm.cloudpath.model.config.Constants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Constants.INTERFACES_TABLE)
public class InterfaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = Constants.ETHERNET_TYPE, nullable = false)
    private String ethernetType;

    @Column(name = Constants.INTERFACE_NUMBER, nullable = false)
    private String interfaceNumber;

    @Column(name = Constants.MAC_ADDRESS, nullable = false, unique = true)
    private String macAddress;

    @Column(name = Constants.NAME)
    private String name;

    @Column(name = Constants.UPLINK_BANDWIDTH)
    private Integer uplinkBandwidth;

    @Column(name = Constants.ARP_TIMEOUT)
    private Duration arpTimeout;

    @Column(name = Constants.QUEUE_STRATEGY)
    private String queueStrategy;

    @Column(name = Constants.OUTPUT_QUEUE_SIZE)
    private Integer outputQueueSize;
}
