package com.projet.controller;

import com.projet.dto.PartyUserStatsDTO;
import com.projet.service.PartyUserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/party-user-stats")
public class PartyUserStatsController {

    private final PartyUserStatsService partyUserStatsService;

    @Autowired
    public PartyUserStatsController(PartyUserStatsService partyUserStatsService) {
        this.partyUserStatsService = partyUserStatsService;
    }

    @GetMapping
    public ResponseEntity<List<PartyUserStatsDTO>> getAllStats() {
        List<PartyUserStatsDTO> stats = partyUserStatsService.getAllStats();
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/{partyId}")
    public ResponseEntity<PartyUserStatsDTO> getStatsByPartyId(@PathVariable Long partyId) {
        PartyUserStatsDTO stats = partyUserStatsService.getStatsByPartyId(partyId);
        return ResponseEntity.ok(stats);
    }

    @PostMapping("/refresh")
    public ResponseEntity<Void> refreshMaterializedView() {
        partyUserStatsService.refreshMaterializedView();
        return ResponseEntity.noContent().build();
    }
}
