package com.projet.mapper;

import com.projet.dto.PartyDto;
import com.projet.dto.TypeProvisionDto;
import com.projet.entity.Party;
import com.projet.entity.TypeProvision;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-11T15:22:24+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class TypeProvisionMapperImpl implements TypeProvisionMapper {

    @Override
    public TypeProvisionDto toDto(TypeProvision typeProvision) {
        if ( typeProvision == null ) {
            return null;
        }

        TypeProvisionDto typeProvisionDto = new TypeProvisionDto();

        typeProvisionDto.setId( typeProvision.getId() );
        typeProvisionDto.setName( typeProvision.getName() );
        typeProvisionDto.setParties( partySetToPartyDtoList( typeProvision.getParties() ) );

        return typeProvisionDto;
    }

    @Override
    public TypeProvision toEntity(TypeProvisionDto typeProvisionDto) {
        if ( typeProvisionDto == null ) {
            return null;
        }

        TypeProvision typeProvision = new TypeProvision();

        typeProvision.setId( typeProvisionDto.getId() );
        typeProvision.setName( typeProvisionDto.getName() );
        typeProvision.setParties( partyDtoListToPartySet( typeProvisionDto.getParties() ) );

        return typeProvision;
    }

    @Override
    public List<TypeProvisionDto> toDtos(List<TypeProvision> typeProvision) {
        if ( typeProvision == null ) {
            return null;
        }

        List<TypeProvisionDto> list = new ArrayList<TypeProvisionDto>( typeProvision.size() );
        for ( TypeProvision typeProvision1 : typeProvision ) {
            list.add( toDto( typeProvision1 ) );
        }

        return list;
    }

    @Override
    public List<TypeProvision> toEntities(List<TypeProvisionDto> typeProvisionDtos) {
        if ( typeProvisionDtos == null ) {
            return null;
        }

        List<TypeProvision> list = new ArrayList<TypeProvision>( typeProvisionDtos.size() );
        for ( TypeProvisionDto typeProvisionDto : typeProvisionDtos ) {
            list.add( toEntity( typeProvisionDto ) );
        }

        return list;
    }

    protected PartyDto partyToPartyDto(Party party) {
        if ( party == null ) {
            return null;
        }

        PartyDto partyDto = new PartyDto();

        partyDto.setId( party.getId() );
        partyDto.setName( party.getName() );
        partyDto.setDate( party.getDate() );
        partyDto.setNumberMaxParticipate( party.getNumberMaxParticipate() );
        partyDto.setPrice( party.getPrice() );
        partyDto.setPublish( party.getPublish() );
        partyDto.setStreet( party.getStreet() );

        return partyDto;
    }

    protected List<PartyDto> partySetToPartyDtoList(Set<Party> set) {
        if ( set == null ) {
            return null;
        }

        List<PartyDto> list = new ArrayList<PartyDto>( set.size() );
        for ( Party party : set ) {
            list.add( partyToPartyDto( party ) );
        }

        return list;
    }

    protected Party partyDtoToParty(PartyDto partyDto) {
        if ( partyDto == null ) {
            return null;
        }

        Party party = new Party();

        party.setId( partyDto.getId() );
        party.setName( partyDto.getName() );
        party.setStreet( partyDto.getStreet() );
        party.setPublish( partyDto.getPublish() );
        party.setPrice( partyDto.getPrice() );
        party.setNumberMaxParticipate( partyDto.getNumberMaxParticipate() );
        party.setDate( partyDto.getDate() );

        return party;
    }

    protected Set<Party> partyDtoListToPartySet(List<PartyDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<Party> set = new LinkedHashSet<Party>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( PartyDto partyDto : list ) {
            set.add( partyDtoToParty( partyDto ) );
        }

        return set;
    }
}
