package com.projet.controller;

import com.projet.dto.TypeProvisionDto;
import com.projet.service.TypeProvisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeProvisions")
public class TypeProvisionController {

    @Autowired
    private TypeProvisionService typeProvisionService;

    @GetMapping("/{id}")
    public ResponseEntity<TypeProvisionDto> getTypeProvisionById(@PathVariable Long id) {
        TypeProvisionDto typeProvisionDto = typeProvisionService.getTypeProvisionById(id);
        if (typeProvisionDto != null) {
            return ResponseEntity.ok(typeProvisionDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<TypeProvisionDto>> getAllTypeProvisions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(typeProvisionService.getAllTypeProvisions(pageable).getContent());
    }

    @PostMapping
    public ResponseEntity<TypeProvisionDto> createTypeProvision(@RequestBody TypeProvisionDto typeProvisionDto) {
        TypeProvisionDto createdTypeProvision = typeProvisionService.createTypeProvision(typeProvisionDto);
        return ResponseEntity.status(201).body(createdTypeProvision);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeProvisionDto> updateTypeProvision(@PathVariable Long id, @RequestBody TypeProvisionDto typeProvisionDto) {
        TypeProvisionDto updatedTypeProvision = typeProvisionService.updateTypeProvision(id, typeProvisionDto);
        if (updatedTypeProvision != null) {
            return ResponseEntity.ok(updatedTypeProvision);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeProvision(@PathVariable Long id) {
        if (typeProvisionService.deleteTypeProvision(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
