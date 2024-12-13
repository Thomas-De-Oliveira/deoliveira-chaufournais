package com.projet.service;

import com.projet.dto.PartyDto;
import com.projet.entity.Party;
import com.projet.mapper.PartyMapper;
import com.projet.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private PartyUserStatsService partyUserStatsService; // Injection du service pour rafraîchir la vue

    public PartyDto convertToDto(Party party) {
        return partyMapper.toDto(party);
    }

    public Page<PartyDto> getAllParties(Pageable pageable) {
        Page<Party> partyPage = partyRepository.findAll(pageable);
        return partyPage.map(this::convertToDto);
    }

    public PartyDto getPartyById(Long id) {
        Optional<Party> party = partyRepository.findById(id);
        return party.map(this::convertToDto).orElse(null); // Retourne null si non trouvé
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
        partyUserStatsService.refreshMaterializedView();
        return convertToDto(party);
    }

    public PartyDto updateParty(Long id, PartyDto partyDto) {
        Optional<Party> existingParty = partyRepository.findById(id);
        if (existingParty.isPresent()) {
            Party party = partyMapper.toEntity(partyDto);
            party.setId(id);
            party = partyRepository.save(party);
            partyUserStatsService.refreshMaterializedView();
            return convertToDto(party);
        }
        return null;
    }

    public boolean deleteParty(Long id) {
        if (partyRepository.existsById(id)) {
            partyRepository.deleteById(id);
            partyUserStatsService.refreshMaterializedView();
            return true;
        }
        return false;
    }
}
