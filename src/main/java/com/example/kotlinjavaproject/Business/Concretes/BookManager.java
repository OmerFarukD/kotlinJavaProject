package com.example.kotlinjavaproject.Business.Concretes;

import com.example.kotlinjavaproject.Business.Abstracts.BookService;
import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookAddDto;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookUpdateDto;
import com.example.kotlinjavaproject.Dtos.Response.Book.BookResponseDto;
import com.example.kotlinjavaproject.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookManager implements BookService {

    private final BookRepository bookRepository;

    @Override
    public DataResult<Page<BookResponseDto>> getAllBooksByPage(Pageable pageable) {
        return null;
    }

    @Override
    public DataResult<BookResponseDto> getById(int id) {
        return null;
    }

    @Override
    public Result add(BookAddDto bookAddDto) {
        return null;
    }

    @Override
    public Result update(BookUpdateDto bookUpdateDto) {
        return null;
    }

    @Override
    public DataResult<Page<BookResponseDto>> getAllByCategoryId(int categoryId) {
        return null;
    }

    @Override
    public DataResult<Page<BookResponseDto>> getAllByAuthorId(int authorId) {
        return null;
    }
}
