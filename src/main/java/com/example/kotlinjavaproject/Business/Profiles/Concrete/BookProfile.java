package com.example.kotlinjavaproject.Business.Profiles.Concrete;

import com.example.kotlinjavaproject.Business.Profiles.BookMapper;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookAddDto;
import com.example.kotlinjavaproject.Dtos.Response.Book.BookResponseDto;
import com.example.kotlinjavaproject.Entities.Book;
import com.example.kotlinjavaproject.Repository.AuthorRepository;
import com.example.kotlinjavaproject.Repository.BookRepository;
import com.example.kotlinjavaproject.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookProfile implements BookMapper {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

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
        if(bookAddDto == null){
            return null;
        }

        var book = new Book();
        book.setDescription(bookAddDto.getDescription());
        book.setStock(bookAddDto.getStock());
        book.setTitle(book.getTitle());
        var getByCategoryId = this.categoryRepository.findById(bookAddDto.getCategoryId()).orElse(null);
        if (getByCategoryId != null){
            book.setCategory(getByCategoryId);
        }
        return null;
    }
}
