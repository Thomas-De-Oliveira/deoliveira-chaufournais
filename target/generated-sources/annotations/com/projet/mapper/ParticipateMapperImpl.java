package com.projet.mapper;

import com.projet.dto.ParticipateDto;
import com.projet.entity.Participate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-13T13:46:40+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ParticipateMapperImpl implements ParticipateMapper {

    @Override
    public ParticipateDto toDto(Participate participate) {
        if ( participate == null ) {
            return null;
        }

        ParticipateDto participateDto = new ParticipateDto();

        participateDto.setId( participate.getId() );
        participateDto.setValidation( participate.getValidation() );
        participateDto.setOrganiser( participate.getOrganiser() );

        return participateDto;
    }

    @Override
    public Participate toEntity(ParticipateDto participateDto) {
        if ( participateDto == null ) {
            return null;
        }

        Participate participate = new Participate();

        participate.setId( participateDto.getId() );
        participate.setValidation( participateDto.getValidation() );
        participate.setOrganiser( participateDto.getOrganiser() );

        return participate;
    }

    @Override
    public List<ParticipateDto> toDtos(List<Participate> participates) {
        if ( participates == null ) {
            return null;
        }

        List<ParticipateDto> list = new ArrayList<ParticipateDto>( participates.size() );
        for ( Participate participate : participates ) {
            list.add( toDto( participate ) );
        }

        return list;
    }

    @Override
    public List<Participate> toEntities(List<ParticipateDto> participateDtos) {
        if ( participateDtos == null ) {
            return null;
        }

        List<Participate> list = new ArrayList<Participate>( participateDtos.size() );
        for ( ParticipateDto participateDto : participateDtos ) {
            list.add( toEntity( participateDto ) );
        }

        return list;
    }
}
