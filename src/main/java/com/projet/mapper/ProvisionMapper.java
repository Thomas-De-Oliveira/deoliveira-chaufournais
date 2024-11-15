package com.projet.mapper;

import com.projet.dto.ProvisionsDto;
import com.projet.entity.Provisions;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TypeProvisionMapper.class})
public interface ProvisionMapper {
    ProvisionsDto toDto(Provisions provisions);
    Provisions toEntity(ProvisionsDto provisionsDto);
    List<ProvisionsDto> toDtos(List<Provisions> provisions);
    List<Provisions> toEntities(List<ProvisionsDto> provisionsDtos);
}
