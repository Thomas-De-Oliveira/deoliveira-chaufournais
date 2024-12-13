package com.projet.repository;

import com.projet.entity.PartyUserStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartyUserStatsRepository extends JpaRepository<PartyUserStats, Long> {
    List<PartyUserStats> findByPartyId(Long partyId);
}
