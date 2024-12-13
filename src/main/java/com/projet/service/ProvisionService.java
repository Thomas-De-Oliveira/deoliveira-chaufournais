package com.projet.service;

import com.projet.dto.ProvisionsDto;
import com.projet.entity.Provisions;
import com.projet.mapper.ProvisionMapper;
import com.projet.repository.ProvisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProvisionService {

    @Autowired
    private ProvisionRepository provisionRepository;

    @Autowired
    private ProvisionMapper provisionMapper;

    public ProvisionsDto convertToDto(Provisions provision) {
        return provisionMapper.toDto(provision);
    }

    public Page<ProvisionsDto> getAllProvisions(Pageable pageable) {
        Page<Provisions> provisionPage = provisionRepository.findAll(pageable);
        return provisionPage.map(this::convertToDto);
    }

    public ProvisionsDto getProvisionById(Long id) {
        Optional<Provisions> provision = provisionRepository.findById(id);
        return provision.map(this::convertToDto).orElse(null);
    }

    public List<ProvisionsDto> getAllProvisions() {
        List<Provisions> provisions = provisionRepository.findAll();
        return provisions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ProvisionsDto createProvision(ProvisionsDto provisionsDto) {
        Provisions provision = provisionMapper.toEntity(provisionsDto);
        provision = provisionRepository.save(provision);
        return convertToDto(provision);
    }

    public ProvisionsDto updateProvision(Long id, ProvisionsDto provisionsDto) {
        Optional<Provisions> existingProvision = provisionRepository.findById(id);
        if (existingProvision.isPresent()) {
            Provisions provision = provisionMapper.toEntity(provisionsDto);
            provision.setId(id);
            provision = provisionRepository.save(provision);
            return convertToDto(provision);
        }
        return null;
    }

    public boolean deleteProvision(Long id) {
        if (provisionRepository.existsById(id)) {
            provisionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
