package com.cpath.esm.cloudpath.service;

import com.cpath.esm.cloudpath.model.InterfaceEntity;
import com.cpath.esm.cloudpath.repository.InterfaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.cpath.esm.cloudpath.model.EthernetType.FastEthernet;
import static com.cpath.esm.cloudpath.model.EthernetType.GigabitEthernet;

@Service
@RequiredArgsConstructor
public class InterfaceService {
    private final InterfaceRepository interfaceRepository;

    public List<InterfaceEntity> findInterfaceByEthernetType(String ethernetType) {
        List<InterfaceEntity> interfaceEntities = new ArrayList<>();
        if (ethernetType.equals(FastEthernet.toString())) {
            interfaceEntities = interfaceRepository.findByEthernetType(FastEthernet.toString());
        } else if (ethernetType.equals(GigabitEthernet.toString())) {
            interfaceEntities = interfaceRepository.findByEthernetType(GigabitEthernet.toString());
        }
        return interfaceEntities;
    }

    public InterfaceEntity findIntByEthernetTypeAndIntNumber(String ethernetType, String interfaceNumber) {
        var interfaceEntity = new InterfaceEntity();
        if (ethernetType.equals(FastEthernet.toString())) {
            interfaceEntity = interfaceRepository.findByEthernetTypeAndInterfaceNumber(FastEthernet.toString(), interfaceNumber);
        } else if (ethernetType.equals(GigabitEthernet.toString())) {
            interfaceEntity = interfaceRepository.findByEthernetTypeAndInterfaceNumber(GigabitEthernet.toString(), interfaceNumber);
        }
        return interfaceEntity;
    }

    public List<InterfaceEntity> findAll() {
        return interfaceRepository.findAll();
    }
}
