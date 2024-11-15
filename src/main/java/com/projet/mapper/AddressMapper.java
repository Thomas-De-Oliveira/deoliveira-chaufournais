package com.projet.mapper;

import com.projet.dto.AddressDto;
import com.projet.entity.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto toDto(Address address);
    Address toEntity(AddressDto addressDto);
    List<AddressDto> toDtos(List<Address> addresses);
    List<Address> toEntities(List<AddressDto> addressDtos);
}
