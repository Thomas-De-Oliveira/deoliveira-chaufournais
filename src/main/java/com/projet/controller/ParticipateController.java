package com.projet.controller;

import com.projet.dto.ParticipateDto;
import com.projet.service.ParticipateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participates")
public class ParticipateController {

    @Autowired
    private ParticipateService participateService;

    @GetMapping("/{id}")
    public ResponseEntity<ParticipateDto> getParticipateById(@PathVariable Long id) {
        ParticipateDto participateDto = participateService.getParticipateById(id);
        if (participateDto != null) {
            return ResponseEntity.ok(participateDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Récupérer toutes les participations avec pagination
    @GetMapping
    public ResponseEntity<List<ParticipateDto>> getAllParticipates(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(participateService.getAllParticipates(pageable).getContent());
    }

    // Créer une nouvelle participation
    @PostMapping
    public ResponseEntity<ParticipateDto> createParticipate(@RequestBody ParticipateDto participateDto) {
        ParticipateDto createdParticipate = participateService.createParticipate(participateDto);
        return ResponseEntity.status(201).body(createdParticipate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipateDto> updateParticipate(@PathVariable Long id, @RequestBody ParticipateDto participateDto) {
        ParticipateDto updatedParticipate = participateService.updateParticipate(id, participateDto);
        if (updatedParticipate != null) {
            return ResponseEntity.ok(updatedParticipate);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipate(@PathVariable Long id) {
        if (participateService.deleteParticipate(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
