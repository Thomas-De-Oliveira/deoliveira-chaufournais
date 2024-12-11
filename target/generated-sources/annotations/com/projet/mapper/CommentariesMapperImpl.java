package com.projet.mapper;

import com.projet.dto.CommentariesDto;
import com.projet.entity.Commentaries;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-15T15:44:02+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CommentariesMapperImpl implements CommentariesMapper {

    @Override
    public CommentariesDto toDto(Commentaries commentaries) {
        if ( commentaries == null ) {
            return null;
        }

        CommentariesDto commentariesDto = new CommentariesDto();

        commentariesDto.setCreatedAt( toFormattedString( commentaries.getCreatedAt() ) );
        commentariesDto.setId( commentaries.getId() );
        commentariesDto.setCommentary( commentaries.getCommentary() );
        commentariesDto.setNote( commentaries.getNote() );

        return commentariesDto;
    }

    @Override
    public Commentaries toEntity(CommentariesDto commentariesDto) {
        if ( commentariesDto == null ) {
            return null;
        }

        Commentaries commentaries = new Commentaries();

        commentaries.setCreatedAt( toLocalDateTime( commentariesDto.getCreatedAt() ) );
        commentaries.setId( commentariesDto.getId() );
        commentaries.setNote( commentariesDto.getNote() );
        commentaries.setCommentary( commentariesDto.getCommentary() );

        return commentaries;
    }

    @Override
    public List<CommentariesDto> toDtos(List<Commentaries> commentaries) {
        if ( commentaries == null ) {
            return null;
        }

        List<CommentariesDto> list = new ArrayList<CommentariesDto>( commentaries.size() );
        for ( Commentaries commentaries1 : commentaries ) {
            list.add( toDto( commentaries1 ) );
        }

        return list;
    }

    @Override
    public List<Commentaries> toEntities(List<CommentariesDto> commentariesDtos) {
        if ( commentariesDtos == null ) {
            return null;
        }

        List<Commentaries> list = new ArrayList<Commentaries>( commentariesDtos.size() );
        for ( CommentariesDto commentariesDto : commentariesDtos ) {
            list.add( toEntity( commentariesDto ) );
        }

        return list;
    }
}
