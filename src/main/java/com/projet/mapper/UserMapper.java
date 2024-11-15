package com.projet.mapper;


import com.projet.dto.UserDto;
import com.projet.entity.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProvisionMapper.class, TypePartyMapper.class})
public interface UserMapper {
    UserDto toDto(Users user);
    Users toEntity(UserDto userDto);
    List<UserDto> toDtos(List<Users> users);
    List<Users> toEntities(List<UserDto> userDtos);
}
