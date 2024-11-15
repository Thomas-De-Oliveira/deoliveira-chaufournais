package com.projet.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String city;
    private String country;
}
