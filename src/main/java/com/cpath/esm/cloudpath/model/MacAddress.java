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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Constants.MAC_ADDRESS_TABLE)
public class MacAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = Constants.VLAN, nullable = false)
    private Integer vlan;

    @Column(name = Constants.MAC_ADDRESS, nullable = false, unique = true)
    private String macAddress;

    @Column(name = Constants.TYPE, nullable = false)
    private String type;

    @Column(name = Constants.PORT_NUMBER)
    private String portNumber;

    @Column(name = Constants.PORT_TYPE)
    private String portType;
}
