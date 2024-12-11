package com.projet.service;

import com.projet.dto.ParticipateDto;
import com.projet.entity.Participate;
import com.projet.mapper.ParticipateMapper;
import com.projet.repository.ParticipateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParticipateService {

    @Autowired
    private ParticipateRepository participateRepository;

    @Autowired
    private ParticipateMapper participateMapper;

    public ParticipateDto convertToDto(Participate participate) {
        return participateMapper.toDto(participate);
    }

    public ParticipateDto getParticipateById(Long id) {
        Optional<Participate> participate = participateRepository.findById(id);
        return participate.map(this::convertToDto).orElse(null);  // Retourne null si non trouvé
    }

    public List<ParticipateDto> getAllParticipates() {
        List<Participate> participates = participateRepository.findAll();
        return participates.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ParticipateDto createParticipate(ParticipateDto participateDto) {
        Participate participate = participateMapper.toEntity(participateDto);
        participate = participateRepository.save(participate);
        return convertToDto(participate);
    }

    public ParticipateDto updateParticipate(Long id, ParticipateDto participateDto) {
        Optional<Participate> existingParticipate = participateRepository.findById(id);
        if (existingParticipate.isPresent()) {
            Participate participate = participateMapper.toEntity(participateDto);
            participate.setId(id);
            participate = participateRepository.save(participate);
            return convertToDto(participate);
        }
        return null;
    }

    public boolean deleteParticipate(Long id) {
        if (participateRepository.existsById(id)) {
            participateRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
