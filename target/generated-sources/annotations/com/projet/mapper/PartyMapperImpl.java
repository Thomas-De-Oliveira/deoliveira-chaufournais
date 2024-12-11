package com.projet.mapper;

import com.projet.dto.PartyDto;
import com.projet.entity.Party;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-11T15:22:24+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class PartyMapperImpl implements PartyMapper {

    @Override
    public PartyDto toDto(Party projet) {
        if ( projet == null ) {
            return null;
        }

        PartyDto partyDto = new PartyDto();

        partyDto.setId( projet.getId() );
        partyDto.setName( projet.getName() );
        partyDto.setDate( projet.getDate() );
        partyDto.setNumberMaxParticipate( projet.getNumberMaxParticipate() );
        partyDto.setPrice( projet.getPrice() );
        partyDto.setPublish( projet.getPublish() );
        partyDto.setStreet( projet.getStreet() );

        return partyDto;
    }

    @Override
    public Party toEntity(PartyDto projetDto) {
        if ( projetDto == null ) {
            return null;
        }

        Party party = new Party();

        party.setId( projetDto.getId() );
        party.setName( projetDto.getName() );
        party.setStreet( projetDto.getStreet() );
        party.setPublish( projetDto.getPublish() );
        party.setPrice( projetDto.getPrice() );
        party.setNumberMaxParticipate( projetDto.getNumberMaxParticipate() );
        party.setDate( projetDto.getDate() );

        return party;
    }

    @Override
    public List<PartyDto> toDtos(List<Party> projets) {
        if ( projets == null ) {
            return null;
        }

        List<PartyDto> list = new ArrayList<PartyDto>( projets.size() );
        for ( Party party : projets ) {
            list.add( toDto( party ) );
        }

        return list;
    }

    @Override
    public List<Party> toEntities(List<PartyDto> projetDtos) {
        if ( projetDtos == null ) {
            return null;
        }

        List<Party> list = new ArrayList<Party>( projetDtos.size() );
        for ( PartyDto partyDto : projetDtos ) {
            list.add( toEntity( partyDto ) );
        }

        return list;
    }
}
