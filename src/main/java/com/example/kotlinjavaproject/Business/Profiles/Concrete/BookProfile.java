package com.example.kotlinjavaproject.Business.Profiles.Concrete;

import com.example.kotlinjavaproject.Business.Profiles.BookMapper;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookAddDto;
import com.example.kotlinjavaproject.Dtos.Response.Book.BookResponseDto;
import com.example.kotlinjavaproject.Entities.Book;

import java.util.List;

public class BookProfile implements BookMapper {
    @Override
    public List<BookResponseDto> mapToResponseList(List<Book> books) {
        return null;
    }

    @Override
    public BookResponseDto entityToResponse(Book book) {
        if (book == null){
            return null;
        }

        BookResponseDto bookResponseDto= new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setDescription(book.getDescription());
        bookResponseDto.setPrice(book.getPrice());
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setStock(bookResponseDto.getId());
        return bookResponseDto;
    }

    @Override
    public Book responseToEntity(BookResponseDto bookResponseDto) {
        return null;
    }

    @Override
    public Book addDtoToEntity(BookAddDto bookAddDto) {
        return null;
    }
}
