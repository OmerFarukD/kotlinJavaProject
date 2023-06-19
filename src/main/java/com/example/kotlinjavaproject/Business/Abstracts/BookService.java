package com.example.kotlinjavaproject.Business.Abstracts;

import com.example.kotlinjavaproject.Core.Exceptions.BusinessException;
import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookAddDto;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookUpdateDto;
import com.example.kotlinjavaproject.Dtos.Response.Book.BookResponseDto;

import java.util.List;

public interface BookService {
 DataResult<BookResponseDto> getById(int id) throws BusinessException;
 Result add(BookAddDto bookAddDto);
 Result update(BookUpdateDto bookUpdateDto) throws BusinessException;
 DataResult<List<BookResponseDto>> getAllBooks();
 DataResult<List<BookResponseDto>> getAllBooksByAuthorId(int authorId);
 DataResult<List<BookResponseDto>> getAllBooksByCategoryId(int categoryId);

 Result delete(int id)throws BusinessException;
}
