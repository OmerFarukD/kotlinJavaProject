package com.example.kotlinjavaproject.Business.Profiles.Concrete;

import com.example.kotlinjavaproject.Business.Profiles.AuthorMapper;
import com.example.kotlinjavaproject.Dtos.Request.Author.AuthorAddDto;
import com.example.kotlinjavaproject.Dtos.Response.Author.AuthorResponseDto;
import com.example.kotlinjavaproject.Entities.Author;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class AuthorProfile  implements AuthorMapper {
    @Override
    public List<AuthorResponseDto> mapToResponseList(List<Author> authors) {
        if (authors.isEmpty()){
            return null;
        }
        return authors.stream().map(this::entityToResponse).toList();
    }

    @Override
    public Author responseToEntity(AuthorResponseDto authorResponseDto) {

        if (authorResponseDto == null){
            return null;
        }
        Author author= new Author();
        author.setName(Objects.requireNonNull(authorResponseDto.getName()));
        author.setId(Objects.requireNonNull(authorResponseDto.getId()));
        return author;
    }

    @Override
    public AuthorResponseDto entityToResponse(Author author) {

        if (author==null){
            return null;
        }
        AuthorResponseDto authorResponseDto= new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setId(author.getId());
        return authorResponseDto;
    }

    @Override
    public Author addDtoToEntity(AuthorAddDto authorAddDto) {
        if ( authorAddDto == null ) {
            return null;
        }
        Author author= new Author();
        author.setName(authorAddDto.getName());
        return author;
    }
}
