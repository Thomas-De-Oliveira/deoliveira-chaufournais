package com.projet.mapper;

import com.projet.dto.PartyUserStatsDTO;
import com.projet.entity.PartyUserStats;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PartyUserStatsMapper {
    PartyUserStatsDTO toDto(PartyUserStats partyUserStats);
    PartyUserStats toEntity(PartyUserStatsDTO partyUserStatsDto);
    List<PartyUserStatsDTO> toDtos(List<PartyUserStats> partyUserStatsList);
    List<PartyUserStats> toEntities(List<PartyUserStatsDTO> partyUserStatsDtoList);
}
