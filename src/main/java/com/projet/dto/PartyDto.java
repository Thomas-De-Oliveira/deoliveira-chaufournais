package com.projet.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartyDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String name;
    private LocalDateTime date;
    private Integer numberMaxParticipate;
    private Float price;
    private Boolean publish;
    private String street;
    private List<TypeProvisionDto> typeProvision;
}
