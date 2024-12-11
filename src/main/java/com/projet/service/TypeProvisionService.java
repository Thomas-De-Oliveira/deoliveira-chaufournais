package com.projet.service;

import com.projet.dto.TypeProvisionDto;
import com.projet.entity.TypeProvision;
import com.projet.mapper.TypeProvisionMapper;
import com.projet.repository.TypeProvisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeProvisionService {

    @Autowired
    private TypeProvisionRepository typeProvisionRepository;

    @Autowired
    private TypeProvisionMapper typeProvisionMapper;

    public TypeProvisionDto getTypeProvisionById(Long id) {
        Optional<TypeProvision> typeProvision = typeProvisionRepository.findById(id);
        return typeProvision.map(typeProvisionMapper::toDto).orElse(null);
    }

    public List<TypeProvisionDto> getAllTypeProvisions() {
        List<TypeProvision> typeProvisions = typeProvisionRepository.findAll();
        return typeProvisionMapper.toDtos(typeProvisions);
    }

    public TypeProvisionDto createTypeProvision(TypeProvisionDto typeProvisionDto) {
        TypeProvision typeProvision = typeProvisionMapper.toEntity(typeProvisionDto);
        typeProvision = typeProvisionRepository.save(typeProvision);
        return typeProvisionMapper.toDto(typeProvision);
    }

    public TypeProvisionDto updateTypeProvision(Long id, TypeProvisionDto typeProvisionDto) {
        Optional<TypeProvision> existingTypeProvision = typeProvisionRepository.findById(id);
        if (existingTypeProvision.isPresent()) {
            TypeProvision typeProvision = typeProvisionMapper.toEntity(typeProvisionDto);
            typeProvision.setId(id);
            typeProvision = typeProvisionRepository.save(typeProvision);
            return typeProvisionMapper.toDto(typeProvision);
        }
        return null;
    }

    public boolean deleteTypeProvision(Long id) {
        if (typeProvisionRepository.existsById(id)) {
            typeProvisionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
