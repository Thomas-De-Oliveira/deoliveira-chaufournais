package com.projet.mapper;

import com.projet.dto.CommentariesDto;
import com.projet.entity.Commentaries;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentariesMapper {

    @Named("toFormattedString")
    default String toFormattedString(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    @Named("toLocalDateTime")
    default LocalDateTime toLocalDateTime(String dateString) {
        if (dateString == null) {
            return null;
        }
        return LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);
    }

    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "toFormattedString")
    CommentariesDto toDto(Commentaries commentaries);

    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "toLocalDateTime")
    Commentaries toEntity(CommentariesDto commentariesDto);

    List<CommentariesDto> toDtos(List<Commentaries> commentaries);

    List<Commentaries> toEntities(List<CommentariesDto> commentariesDtos);
}
