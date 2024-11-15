package com.projet.mapper;

import com.projet.dto.CommentariesDto;
import com.projet.entity.Commentaries;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentariesMapper {
    CommentariesDto toDto(Commentaries commentaries);
    Commentaries toEntity(CommentariesDto commentariesDto);
    List<CommentariesDto> toDtos(List<Commentaries> commentaries);
    List<Commentaries> toEntities(List<CommentariesDto> commentariesDtos);
}
