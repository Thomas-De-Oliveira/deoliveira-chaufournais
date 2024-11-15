package com.projet.mapper;

import com.projet.dto.PartyDto;
import com.projet.entity.Party;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PartyMapper {
    PartyDto toDto(Party projet);
    Party toEntity(PartyDto projetDto);
    List<PartyDto> toDtos(List<Party> projets);
    List<Party> toEntities(List<PartyDto> projetDtos);
}
