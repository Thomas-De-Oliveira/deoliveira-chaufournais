package com.projet.controller;

import com.projet.dto.ProvisionsDto;
import com.projet.service.ProvisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provisions")
public class ProvisionController {

    @Autowired
    private ProvisionService provisionService;

    @GetMapping("/{id}")
    public ResponseEntity<ProvisionsDto> getProvisionById(@PathVariable Long id) {
        ProvisionsDto provisionsDto = provisionService.getProvisionById(id);
        if (provisionsDto != null) {
            return ResponseEntity.ok(provisionsDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Récupérer toutes les provisions avec pagination
    @GetMapping
    public ResponseEntity<List<ProvisionsDto>> getAllProvisions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(provisionService.getAllProvisions(pageable).getContent());
    }

    @PostMapping
    public ResponseEntity<ProvisionsDto> createProvision(@RequestBody ProvisionsDto provisionsDto) {
        ProvisionsDto createdProvision = provisionService.createProvision(provisionsDto);
        return ResponseEntity.status(201).body(createdProvision);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProvisionsDto> updateProvision(@PathVariable Long id, @RequestBody ProvisionsDto provisionsDto) {
        ProvisionsDto updatedProvision = provisionService.updateProvision(id, provisionsDto);
        if (updatedProvision != null) {
            return ResponseEntity.ok(updatedProvision);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvision(@PathVariable Long id) {
        if (provisionService.deleteProvision(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
