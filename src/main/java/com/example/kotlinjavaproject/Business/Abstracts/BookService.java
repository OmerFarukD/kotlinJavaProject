package com.example.kotlinjavaproject.Business.Abstracts;

import com.example.kotlinjavaproject.Core.Exceptions.BusinessException;
import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookAddDto;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookUpdateDto;
import com.example.kotlinjavaproject.Dtos.Response.Book.BookResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
 DataResult<Page<BookResponseDto>> getAllBooksByPage(Pageable pageable);
 DataResult<BookResponseDto> getById(int id) throws BusinessException;
 Result add(BookAddDto bookAddDto);
 Result update(BookUpdateDto bookUpdateDto) throws BusinessException;
 DataResult<Page<BookResponseDto>> getAllByCategoryId(Pageable pageable,int categoryId);

 Result delete(int id)throws BusinessException;
 DataResult<Page<BookResponseDto>> getAllByAuthorId(Pageable pageable, int authorId);
}
