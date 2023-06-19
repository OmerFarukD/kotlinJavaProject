package com.example.kotlinjavaproject.Business.Profiles;

import com.example.kotlinjavaproject.Dtos.Request.Author.AuthorAddDto;
import com.example.kotlinjavaproject.Dtos.Response.Author.AuthorResponseDto;
import com.example.kotlinjavaproject.Entities.Author;

import java.util.List;


public interface AuthorMapper {
    List<AuthorResponseDto> mapToResponseList(List<Author> authors);
    Author responseToEntity(AuthorResponseDto authorResponseDto);
    AuthorResponseDto entityToResponse(Author author);
    Author addDtoToEntity(AuthorAddDto authorAddDto);
}
