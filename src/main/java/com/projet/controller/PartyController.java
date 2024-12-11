package com.projet.controller;

import com.projet.dto.PartyDto;
import com.projet.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public ResponseEntity<List<PartyDto>> getAllParties() {
        List<PartyDto> partyDtoList = partyService.getAllParties();
        return ResponseEntity.ok(partyDtoList);
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
