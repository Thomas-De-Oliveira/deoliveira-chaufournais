package com.projet.mapper;

import com.projet.dto.AddressDto;
import com.projet.entity.Address;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-15T14:27:14+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDto toDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( address.getId() );
        addressDto.setCity( address.getCity() );
        addressDto.setCountry( address.getCountry() );

        return addressDto;
    }

    @Override
    public Address toEntity(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDto.getId() );
        address.setCity( addressDto.getCity() );
        address.setCountry( addressDto.getCountry() );

        return address;
    }

    @Override
    public List<AddressDto> toDtos(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressDto> list = new ArrayList<AddressDto>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( toDto( address ) );
        }

        return list;
    }

    @Override
    public List<Address> toEntities(List<AddressDto> addressDtos) {
        if ( addressDtos == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressDtos.size() );
        for ( AddressDto addressDto : addressDtos ) {
            list.add( toEntity( addressDto ) );
        }

        return list;
    }
}
