package com.projet.service;

import com.projet.dto.PartyUserStatsDTO;
import com.projet.entity.PartyUserStats;
import com.projet.exception.RessourceNotFoundException;
import com.projet.mapper.PartyUserStatsMapper;
import com.projet.repository.PartyUserStatsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PartyUserStatsService {

    private final PartyUserStatsRepository partyUserStatsRepository;
    private final PartyUserStatsMapper partyUserStatsMapper;

    @Autowired
    public PartyUserStatsService(PartyUserStatsRepository partyUserStatsRepository, PartyUserStatsMapper partyUserStatsMapper) {
        this.partyUserStatsRepository = partyUserStatsRepository;
        this.partyUserStatsMapper = partyUserStatsMapper;
    }

    public List<PartyUserStatsDTO> getAllStats() {
        List<PartyUserStats> statsList = partyUserStatsRepository.findAll();
        return statsList.stream()
                .map(partyUserStatsMapper::toDto)
                .collect(Collectors.toList());
    }

    public PartyUserStatsDTO getStatsByPartyId(Long partyId) {
        PartyUserStats stats = partyUserStatsRepository.findById(partyId)
                .orElseThrow(() -> new RessourceNotFoundException("Statistiques non trouvées pour l'ID de la partie : " + partyId));
        return partyUserStatsMapper.toDto(stats);
    }

    @PersistenceContext
    private EntityManager entityManager;
    public void refreshMaterializedView() {
        entityManager.createNativeQuery("REFRESH MATERIALIZED VIEW party_user_stats").executeUpdate();
    }

}
