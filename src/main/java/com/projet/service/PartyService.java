package com.projet.service;

import com.projet.dto.PartyDto;
import com.projet.entity.Party;
import com.projet.mapper.PartyMapper;
import com.projet.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartyService {

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private PartyMapper partyMapper;

    public PartyDto convertToDto(Party party) {
        return partyMapper.toDto(party);
    }

    public PartyDto getPartyById(Long id) {
        Optional<Party> party = partyRepository.findById(id);
        return party.map(this::convertToDto).orElse(null);  // Retourne null si non trouvé
    }

    public List<PartyDto> getAllParties() {
        List<Party> parties = partyRepository.findAll();
        return parties.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PartyDto createParty(PartyDto partyDto) {
        Party party = partyMapper.toEntity(partyDto);
        party = partyRepository.save(party);
        return convertToDto(party);
    }

    public PartyDto updateParty(Long id, PartyDto partyDto) {
        Optional<Party> existingParty = partyRepository.findById(id);
        if (existingParty.isPresent()) {
            Party party = partyMapper.toEntity(partyDto);
            party.setId(id);  // Assure que l'ID ne sera pas réinitialisé
            party = partyRepository.save(party);
            return convertToDto(party);
        }
        return null;  // Si l'événement de fête n'existe pas
    }

    public boolean deleteParty(Long id) {
        if (partyRepository.existsById(id)) {
            partyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
