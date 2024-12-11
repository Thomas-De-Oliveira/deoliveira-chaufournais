package com.projet.service;

import com.projet.dto.TypePartyDto;
import com.projet.entity.TypeParty;
import com.projet.mapper.TypePartyMapper;
import com.projet.repository.TypePartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TypePartyService {

    @Autowired
    private TypePartyRepository typePartyRepository;

    @Autowired
    private TypePartyMapper typePartyMapper;

    public TypePartyDto convertToDto(TypeParty typeParty) {
        return typePartyMapper.toDto(typeParty);
    }

    public TypePartyDto getTypePartyById(Long id) {
        Optional<TypeParty> typeParty = typePartyRepository.findById(id);
        return typeParty.map(this::convertToDto).orElse(null);  // Retourne null si non trouvé
    }

    public List<TypePartyDto> getAllTypeParties() {
        List<TypeParty> typeParties = typePartyRepository.findAll();
        return typeParties.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public TypePartyDto createTypeParty(TypePartyDto typePartyDto) {
        TypeParty typeParty = typePartyMapper.toEntity(typePartyDto);
        typeParty = typePartyRepository.save(typeParty);
        return convertToDto(typeParty);
    }

    public TypePartyDto updateTypeParty(Long id, TypePartyDto typePartyDto) {
        Optional<TypeParty> existingTypeParty = typePartyRepository.findById(id);
        if (existingTypeParty.isPresent()) {
            TypeParty typeParty = typePartyMapper.toEntity(typePartyDto);
            typeParty.setId(id);
            typeParty = typePartyRepository.save(typeParty);
            return convertToDto(typeParty);
        }
        return null;
    }

    public boolean deleteTypeParty(Long id) {
        if (typePartyRepository.existsById(id)) {
            typePartyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
