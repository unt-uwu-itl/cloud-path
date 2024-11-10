package com.cpath.esm.cloudpath.repository;

import com.cpath.esm.cloudpath.model.InterfaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceRepository extends JpaRepository<InterfaceEntity, Long> {
    List<InterfaceEntity> findByEthernetType(String ethernetType);

    InterfaceEntity findByEthernetTypeAndInterfaceNumber(String ethernetType, String interfaceNumber);
}
