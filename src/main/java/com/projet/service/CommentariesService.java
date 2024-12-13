package com.projet.service;

import com.projet.dto.CommentariesDto;
import com.projet.entity.Commentaries;
import com.projet.repository.CommentariesRepository;
import com.projet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentariesService {

    @Autowired
    private CommentariesRepository commentariesRepository;

    @Autowired
    private UserRepository userRepository;

    private CommentariesDto convertToDTO(Commentaries commentaries) {
        String formattedDate = commentaries.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        return new CommentariesDto(
                commentaries.getId(),
                commentaries.getCommentary(),
                commentaries.getNote(),
                commentaries.getAuthor().getId(),
                commentaries.getAuthor().getName(),
                commentaries.getTarget().getId(),
                commentaries.getTarget().getName(),
                formattedDate
        );
    }

    public Page<CommentariesDto> getAllCommentaries(Pageable pageable) {
        Page<Commentaries> commentariesPage = commentariesRepository.findAll(pageable);
        return commentariesPage.map(this::convertToDTO);
    }

    public CommentariesDto getCommentaryById(Long id) {
        Optional<Commentaries> commentaries = commentariesRepository.findById(id);
        return commentaries.map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Commentaire non trouvé avec l'ID : " + id));
    }

    public CommentariesDto createCommentary(CommentariesDto commentariesDto) {
        Commentaries commentaries = new Commentaries();
        return saveCommentaryFromDto(commentariesDto, commentaries);
    }

    public CommentariesDto updateCommentary(Long id, CommentariesDto commentariesDto) {
        Optional<Commentaries> existingCommentary = commentariesRepository.findById(id);
        if (existingCommentary.isPresent()) {
            Commentaries commentaries = existingCommentary.get();
            return saveCommentaryFromDto(commentariesDto, commentaries);
        }
        return null;
    }

    private CommentariesDto saveCommentaryFromDto(CommentariesDto commentariesDto, Commentaries commentaries) {
        commentaries.setCommentary(commentariesDto.getCommentary());
        commentaries.setNote(commentariesDto.getNote());

        commentaries.setAuthor(userRepository.findById(commentariesDto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Auteur non trouvé")));

        commentaries.setTarget(userRepository.findById(commentariesDto.getTargetId())
                .orElseThrow(() -> new RuntimeException("Cible non trouvée")));

        commentaries = commentariesRepository.save(commentaries);

        return convertToDTO(commentaries);
    }

    public boolean deleteCommentary(Long id) {
        if (commentariesRepository.existsById(id)) {
            commentariesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
