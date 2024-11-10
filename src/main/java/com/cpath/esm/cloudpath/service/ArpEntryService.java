package com.cpath.esm.cloudpath.service;

import com.cpath.esm.cloudpath.model.ArpEntity;
import com.cpath.esm.cloudpath.repository.ArpEntryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArpEntryService {

    public final ArpEntryRepository arpEntryRepository;

    public List<ArpEntity> getAllArpEntries() {
        return arpEntryRepository.findAll();
    }

    public Optional<ArpEntity> getArpEntryById(Long id) {
        return arpEntryRepository.findById(id);
    }

    public ArpEntity saveOrUpdateArpEntry(ArpEntity arpEntry) {
        return arpEntryRepository.save(arpEntry);
    }

    public void deleteArpEntry(Long id) {
        arpEntryRepository.deleteById(id);
    }
}
