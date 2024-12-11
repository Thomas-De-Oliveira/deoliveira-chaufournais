package com.projet.mapper;

import com.projet.dto.ProvisionsDto;
import com.projet.entity.Provisions;
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
public class ProvisionMapperImpl implements ProvisionMapper {

    @Override
    public ProvisionsDto toDto(Provisions provisions) {
        if ( provisions == null ) {
            return null;
        }

        ProvisionsDto provisionsDto = new ProvisionsDto();

        provisionsDto.setId( provisions.getId() );
        provisionsDto.setProvision( provisions.getProvision() );

        return provisionsDto;
    }

    @Override
    public Provisions toEntity(ProvisionsDto provisionsDto) {
        if ( provisionsDto == null ) {
            return null;
        }

        Provisions provisions = new Provisions();

        provisions.setId( provisionsDto.getId() );
        provisions.setProvision( provisionsDto.getProvision() );

        return provisions;
    }

    @Override
    public List<ProvisionsDto> toDtos(List<Provisions> provisions) {
        if ( provisions == null ) {
            return null;
        }

        List<ProvisionsDto> list = new ArrayList<ProvisionsDto>( provisions.size() );
        for ( Provisions provisions1 : provisions ) {
            list.add( toDto( provisions1 ) );
        }

        return list;
    }

    @Override
    public List<Provisions> toEntities(List<ProvisionsDto> provisionsDtos) {
        if ( provisionsDtos == null ) {
            return null;
        }

        List<Provisions> list = new ArrayList<Provisions>( provisionsDtos.size() );
        for ( ProvisionsDto provisionsDto : provisionsDtos ) {
            list.add( toEntity( provisionsDto ) );
        }

        return list;
    }
}
