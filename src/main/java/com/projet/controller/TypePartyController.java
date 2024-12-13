package com.projet.controller;

import com.projet.dto.TypePartyDto;
import com.projet.service.TypePartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeParties")
public class TypePartyController {

    @Autowired
    private TypePartyService typePartyService;

    @GetMapping("/{id}")
    public ResponseEntity<TypePartyDto> getTypePartyById(@PathVariable Long id) {
        TypePartyDto typePartyDto = typePartyService.getTypePartyById(id);
        if (typePartyDto != null) {
            return ResponseEntity.ok(typePartyDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Récupérer tous les types de fêtes avec pagination
    @GetMapping
    public ResponseEntity<List<TypePartyDto>> getAllTypeParties(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(typePartyService.getAllTypeParties(pageable).getContent());
    }

    @PostMapping
    public ResponseEntity<TypePartyDto> createTypeParty(@RequestBody TypePartyDto typePartyDto) {
        TypePartyDto createdTypeParty = typePartyService.createTypeParty(typePartyDto);
        return ResponseEntity.status(201).body(createdTypeParty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypePartyDto> updateTypeParty(@PathVariable Long id, @RequestBody TypePartyDto typePartyDto) {
        TypePartyDto updatedTypeParty = typePartyService.updateTypeParty(id, typePartyDto);
        if (updatedTypeParty != null) {
            return ResponseEntity.ok(updatedTypeParty);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeParty(@PathVariable Long id) {
        if (typePartyService.deleteTypeParty(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
