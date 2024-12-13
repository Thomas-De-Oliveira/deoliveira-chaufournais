package com.projet.controller;

import com.projet.dto.PartyDto;
import com.projet.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parties")
public class PartyController {

    @Autowired
    private PartyService partyService;

    @GetMapping("/{id}")
    public ResponseEntity<PartyDto> getPartyById(@PathVariable Long id) {
        PartyDto partyDto = partyService.getPartyById(id);
        if (partyDto != null) {
            return ResponseEntity.ok(partyDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Récupérer toutes les fêtes avec pagination
    @GetMapping
    public ResponseEntity<List<PartyDto>> getAllParties(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(partyService.getAllParties(pageable).getContent());
    }

    @PostMapping
    public ResponseEntity<PartyDto> createParty(@RequestBody PartyDto partyDto) {
        PartyDto createdParty = partyService.createParty(partyDto);
        return ResponseEntity.status(201).body(createdParty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartyDto> updateParty(@PathVariable Long id, @RequestBody PartyDto partyDto) {
        PartyDto updatedParty = partyService.updateParty(id, partyDto);
        if (updatedParty != null) {
            return ResponseEntity.ok(updatedParty);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParty(@PathVariable Long id) {
        if (partyService.deleteParty(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
