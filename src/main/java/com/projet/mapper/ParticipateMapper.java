package com.projet.mapper;

import com.projet.dto.ParticipateDto;
import com.projet.entity.Participate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParticipateMapper {
    ParticipateDto toDto(Participate participate);
    Participate toEntity(ParticipateDto participateDto);
    List<ParticipateDto> toDtos(List<Participate> participates);
    List<Participate> toEntities(List<ParticipateDto> participateDtos);
}
