package com.projet.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String familyName;
    private String name;
    private String username;
    private Integer age;
    private String email;
    private String passwordHash;
    private String passwordSalt;
    private List<TypePartyDto> typeParties;
}
