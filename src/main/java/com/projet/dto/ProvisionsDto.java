package com.projet.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvisionsDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String provision;
}
