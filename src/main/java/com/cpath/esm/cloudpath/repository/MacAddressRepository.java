package com.cpath.esm.cloudpath.repository;

import com.cpath.esm.cloudpath.model.MacAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MacAddressRepository extends JpaRepository<MacAddress, Long> {
}
