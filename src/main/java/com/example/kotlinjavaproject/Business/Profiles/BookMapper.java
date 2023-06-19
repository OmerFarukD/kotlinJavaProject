package com.example.kotlinjavaproject.Business.Profiles;

import com.example.kotlinjavaproject.Dtos.Request.Book.BookAddDto;
import com.example.kotlinjavaproject.Dtos.Response.Book.BookResponseDto;
import com.example.kotlinjavaproject.Entities.Book;

import java.util.List;


public interface BookMapper {

    List<BookResponseDto> mapToResponseList(List<Book> books);
    BookResponseDto entityToResponse(Book book);
    Book responseToEntity(BookResponseDto bookResponseDto);
    Book addDtoToEntity(BookAddDto bookAddDto);
}
