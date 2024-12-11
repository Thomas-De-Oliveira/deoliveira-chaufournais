package com.projet.mapper;

import com.projet.dto.TypePartyDto;
import com.projet.entity.TypeParty;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-11T14:43:37+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class TypePartyMapperImpl implements TypePartyMapper {

    @Override
    public TypePartyDto toDto(TypeParty typeParty) {
        if ( typeParty == null ) {
            return null;
        }

        TypePartyDto typePartyDto = new TypePartyDto();

        typePartyDto.setId( typeParty.getId() );
        typePartyDto.setName( typeParty.getName() );

        return typePartyDto;
    }

    @Override
    public TypeParty toEntity(TypePartyDto typePartyDto) {
        if ( typePartyDto == null ) {
            return null;
        }

        TypeParty typeParty = new TypeParty();

        typeParty.setId( typePartyDto.getId() );
        typeParty.setName( typePartyDto.getName() );

        return typeParty;
    }

    @Override
    public List<TypePartyDto> toDtos(List<TypeParty> typePartyListList) {
        if ( typePartyListList == null ) {
            return null;
        }

        List<TypePartyDto> list = new ArrayList<TypePartyDto>( typePartyListList.size() );
        for ( TypeParty typeParty : typePartyListList ) {
            list.add( toDto( typeParty ) );
        }

        return list;
    }

    @Override
    public List<TypeParty> toEntities(List<TypePartyDto> typePartyDtoList) {
        if ( typePartyDtoList == null ) {
            return null;
        }

        List<TypeParty> list = new ArrayList<TypeParty>( typePartyDtoList.size() );
        for ( TypePartyDto typePartyDto : typePartyDtoList ) {
            list.add( toEntity( typePartyDto ) );
        }

        return list;
    }
}
