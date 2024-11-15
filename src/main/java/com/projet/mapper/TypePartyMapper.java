package com.projet.mapper;

import com.projet.dto.TypePartyDto;
import com.projet.entity.TypeParty;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypePartyMapper {
    TypePartyDto toDto(TypeParty typeParty);
    TypeParty toEntity(TypePartyDto typePartyDto);
    List<TypePartyDto> toDtos(List<TypeParty> typePartyListList);
    List<TypeParty> toEntities(List<TypePartyDto> typePartyDtoList);
}
