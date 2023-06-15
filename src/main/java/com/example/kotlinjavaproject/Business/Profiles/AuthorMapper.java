package com.example.kotlinjavaproject.Business.Profiles;

import com.example.kotlinjavaproject.Dtos.Request.Author.AuthorAddDto;
import com.example.kotlinjavaproject.Dtos.Response.Author.AuthorResponseDto;
import com.example.kotlinjavaproject.Entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE= Mappers.getMapper(AuthorMapper.class);
    List<AuthorResponseDto> mapToResponseList(List<Author> authors);
    Author responseToEntity(AuthorResponseDto authorResponseDto);
    AuthorResponseDto entityToResponse(Author author);
    Author addDtoToEntity(AuthorAddDto authorAddDto);
}
