package com.projet.mapper;

import com.projet.dto.PartyUserStatsDTO;
import com.projet.entity.PartyUserStats;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-13T16:33:21+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class PartyUserStatsMapperImpl implements PartyUserStatsMapper {

    @Override
    public PartyUserStatsDTO toDto(PartyUserStats partyUserStats) {
        if ( partyUserStats == null ) {
            return null;
        }

        PartyUserStatsDTO partyUserStatsDTO = new PartyUserStatsDTO();

        partyUserStatsDTO.setPartyId( partyUserStats.getPartyId() );
        partyUserStatsDTO.setPartyName( partyUserStats.getPartyName() );
        partyUserStatsDTO.setCurrentUserCount( partyUserStats.getCurrentUserCount() );
        partyUserStatsDTO.setMaxUserCount( partyUserStats.getMaxUserCount() );
        partyUserStatsDTO.setOrganiserName( partyUserStats.getOrganiserName() );

        return partyUserStatsDTO;
    }

    @Override
    public PartyUserStats toEntity(PartyUserStatsDTO partyUserStatsDto) {
        if ( partyUserStatsDto == null ) {
            return null;
        }

        PartyUserStats partyUserStats = new PartyUserStats();

        partyUserStats.setPartyId( partyUserStatsDto.getPartyId() );
        partyUserStats.setPartyName( partyUserStatsDto.getPartyName() );
        partyUserStats.setCurrentUserCount( partyUserStatsDto.getCurrentUserCount() );
        partyUserStats.setMaxUserCount( partyUserStatsDto.getMaxUserCount() );
        partyUserStats.setOrganiserName( partyUserStatsDto.getOrganiserName() );

        return partyUserStats;
    }

    @Override
    public List<PartyUserStatsDTO> toDtos(List<PartyUserStats> partyUserStatsList) {
        if ( partyUserStatsList == null ) {
            return null;
        }

        List<PartyUserStatsDTO> list = new ArrayList<PartyUserStatsDTO>( partyUserStatsList.size() );
        for ( PartyUserStats partyUserStats : partyUserStatsList ) {
            list.add( toDto( partyUserStats ) );
        }

        return list;
    }

    @Override
    public List<PartyUserStats> toEntities(List<PartyUserStatsDTO> partyUserStatsDtoList) {
        if ( partyUserStatsDtoList == null ) {
            return null;
        }

        List<PartyUserStats> list = new ArrayList<PartyUserStats>( partyUserStatsDtoList.size() );
        for ( PartyUserStatsDTO partyUserStatsDTO : partyUserStatsDtoList ) {
            list.add( toEntity( partyUserStatsDTO ) );
        }

        return list;
    }
}
