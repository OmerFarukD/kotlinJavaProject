package com.example.kotlinjavaproject.Business.Profiles;

import com.example.kotlinjavaproject.Dtos.Request.Book.BookAddDto;
import com.example.kotlinjavaproject.Dtos.Response.Book.BookResponseDto;
import com.example.kotlinjavaproject.Entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE= Mappers.getMapper(BookMapper.class);
    Page<BookResponseDto> mapToPage(Page<Book> books);
    BookResponseDto entityToResponse(Book book);
    Book responseToEntity(BookResponseDto bookResponseDto);
    Book addDtoToEntity(BookAddDto bookAddDto);
}
