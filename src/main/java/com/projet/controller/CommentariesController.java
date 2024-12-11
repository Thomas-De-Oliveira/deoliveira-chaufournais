package com.projet.controller;

import com.projet.dto.CommentariesDto;
import com.projet.service.CommentariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentaries")
public class CommentariesController {

    @Autowired
    private CommentariesService commentariesService;

    @GetMapping("/{id}")
    public ResponseEntity<CommentariesDto> getCommentaryById(@PathVariable Long id) {
        CommentariesDto commentariesDto = commentariesService.getCommentaryById(id);
        if (commentariesDto != null) {
            return ResponseEntity.ok(commentariesDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CommentariesDto>> getAllCommentaries() {
        List<CommentariesDto> commentariesDtoList = commentariesService.getAllCommentaries();
        return ResponseEntity.ok(commentariesDtoList);
    }

    @PostMapping
    public ResponseEntity<CommentariesDto> createCommentary(@RequestBody CommentariesDto commentariesDto) {
        CommentariesDto createdCommentary = commentariesService.createCommentary(commentariesDto);
        return ResponseEntity.status(201).body(createdCommentary);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentariesDto> updateCommentary(@PathVariable Long id, @RequestBody CommentariesDto commentariesDto) {
        CommentariesDto updatedCommentary = commentariesService.updateCommentary(id, commentariesDto);
        if (updatedCommentary != null) {
            return ResponseEntity.ok(updatedCommentary);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentary(@PathVariable Long id) {
        if (commentariesService.deleteCommentary(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
