package com.projet.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentariesDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String commentary;
    private Integer note;

    private Long authorId;
    private String authorName;

    private Long targetId;
    private String targetName;

    @Schema(type = "string", format = "date-time", description = "La date de création du commentaire")
    private String createdAt;
}
