package com.example.kotlinjavaproject.Business.Abstracts;

import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookAddDto;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookUpdateDto;
import com.example.kotlinjavaproject.Dtos.Response.Book.BookResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
 DataResult<Page<BookResponseDto>> getAllBooksByPage(Pageable pageable);
 DataResult<BookResponseDto> getById(int id);
 Result add(BookAddDto bookAddDto);
 Result update(BookUpdateDto bookUpdateDto);
 DataResult<Page<BookResponseDto>> getAllByCategoryId(int categoryId);
 DataResult<Page<BookResponseDto>> getAllByAuthorId(int authorId);
}
