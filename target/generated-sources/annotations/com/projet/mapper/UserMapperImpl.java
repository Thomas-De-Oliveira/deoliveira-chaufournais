package com.projet.mapper;

import com.projet.dto.TypePartyDto;
import com.projet.dto.UserCreationDto;
import com.projet.dto.UserDto;
import com.projet.entity.TypeParty;
import com.projet.entity.Users;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-13T13:46:40+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private TypePartyMapper typePartyMapper;

    @Override
    public UserDto toDto(Users user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setFamilyName( user.getFamilyName() );
        userDto.setName( user.getName() );
        userDto.setUsername( user.getUsername() );
        userDto.setEmail( user.getEmail() );
        userDto.setPasswordHash( user.getPasswordHash() );
        userDto.setPasswordSalt( user.getPasswordSalt() );
        userDto.setAddress( user.getAddress() );
        userDto.setTypeParties( typePartySetToTypePartyDtoList( user.getTypeParties() ) );

        return userDto;
    }

    @Override
    public Users toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( userDto.getId() );
        users.setFamilyName( userDto.getFamilyName() );
        users.setName( userDto.getName() );
        users.setEmail( userDto.getEmail() );
        users.setUsername( userDto.getUsername() );
        users.setPasswordHash( userDto.getPasswordHash() );
        users.setPasswordSalt( userDto.getPasswordSalt() );
        users.setTypeParties( typePartyDtoListToTypePartySet( userDto.getTypeParties() ) );
        users.setAddress( userDto.getAddress() );

        return users;
    }

    @Override
    public List<UserDto> toDtos(List<Users> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( Users users1 : users ) {
            list.add( toDto( users1 ) );
        }

        return list;
    }

    @Override
    public List<Users> toEntities(List<UserDto> userDtos) {
        if ( userDtos == null ) {
            return null;
        }

        List<Users> list = new ArrayList<Users>( userDtos.size() );
        for ( UserDto userDto : userDtos ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }

    @Override
    public Users toEntity(UserCreationDto user1Dto) {
        if ( user1Dto == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( user1Dto.getId() );
        users.setFamilyName( user1Dto.getFamilyName() );
        users.setName( user1Dto.getName() );
        users.setEmail( user1Dto.getEmail() );
        users.setUsername( user1Dto.getUsername() );
        users.setTypeParties( typePartyDtoListToTypePartySet( user1Dto.getTypeParties() ) );

        return users;
    }

    protected List<TypePartyDto> typePartySetToTypePartyDtoList(Set<TypeParty> set) {
        if ( set == null ) {
            return null;
        }

        List<TypePartyDto> list = new ArrayList<TypePartyDto>( set.size() );
        for ( TypeParty typeParty : set ) {
            list.add( typePartyMapper.toDto( typeParty ) );
        }

        return list;
    }

    protected Set<TypeParty> typePartyDtoListToTypePartySet(List<TypePartyDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<TypeParty> set = new LinkedHashSet<TypeParty>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( TypePartyDto typePartyDto : list ) {
            set.add( typePartyMapper.toEntity( typePartyDto ) );
        }

        return set;
    }
}
