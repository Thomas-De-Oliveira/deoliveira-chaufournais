package com.projet.mapper;

import com.projet.dto.TypeProvisionDto;
import com.projet.entity.TypeProvision;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeProvisionMapper {
    TypeProvisionDto toDto(TypeProvision typeProvision);
    TypeProvision toEntity(TypeProvisionDto typeProvisionDto);
    List<TypeProvisionDto> toDtos(List<TypeProvision> typeProvision);
    List<TypeProvision> toEntities(List<TypeProvisionDto> typeProvisionDtos);
}
