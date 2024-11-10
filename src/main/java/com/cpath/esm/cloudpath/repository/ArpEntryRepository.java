package com.cpath.esm.cloudpath.repository;

import com.cpath.esm.cloudpath.model.ArpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArpEntryRepository extends JpaRepository<ArpEntity, Long> {
}