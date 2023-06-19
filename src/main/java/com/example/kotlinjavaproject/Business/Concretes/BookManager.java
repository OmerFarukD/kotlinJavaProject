package com.example.kotlinjavaproject.Business.Concretes;

import com.example.kotlinjavaproject.Business.Abstracts.BookService;
import com.example.kotlinjavaproject.Business.Constants.Messages.Messages;
import com.example.kotlinjavaproject.Business.Profiles.BookMapper;
import com.example.kotlinjavaproject.Core.Exceptions.BusinessException;
import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Core.Results.SuccessDataResult;
import com.example.kotlinjavaproject.Core.Results.SuccessResult;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookAddDto;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookUpdateDto;
import com.example.kotlinjavaproject.Dtos.Response.Book.BookResponseDto;
import com.example.kotlinjavaproject.Entities.Book;
import com.example.kotlinjavaproject.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookManager implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookManager(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public DataResult<BookResponseDto> getById(int id) throws BusinessException {
        var data= this.bookRepository.findById(id).orElseThrow(()->new BusinessException(Messages.bookNotFoundMessage(id)));
        BookResponseDto dto= this.bookMapper.entityToResponse(data);
        return new SuccessDataResult<>(dto);
    }

    @Override
    public Result add(BookAddDto bookAddDto) {
        Book book=this.bookMapper.addDtoToEntity(bookAddDto);
        this.bookRepository.save(book);
        return new SuccessResult(Messages.BOOK_ADDED_MESSAGE);
    }

    @Override
    public Result update(BookUpdateDto bookUpdateDto) throws BusinessException {

        var book=this.bookRepository.findById(Objects.requireNonNull(bookUpdateDto.getId()))
                .orElseThrow(()->new BusinessException(Messages.bookNotFoundMessage(bookUpdateDto.getId())));
        this.bookRepository.save(book);
        return new SuccessResult(Messages.BOOK_UPDATED_MESSAGE);
    }

    @Override
    public DataResult<List<BookResponseDto>> getAllBooks() {
        var books= this.bookRepository.findAll();
        List<BookResponseDto> dtoList= this.bookMapper.mapToResponseList(books);
        return new SuccessDataResult<>(dtoList);
    }

    @Override
    public DataResult<List<BookResponseDto>> getAllBooksByAuthorId(int authorId) {
        var books= this.bookRepository.findAllByAuthor_Id(authorId);
        List<BookResponseDto> dtoList= this.bookMapper.mapToResponseList(books);
        return new SuccessDataResult<>(dtoList);
    }

    @Override
    public DataResult<List<BookResponseDto>> getAllBooksByCategoryId(int categoryId) {
        var books= this.bookRepository.findAllByCategory_Id(categoryId);
        List<BookResponseDto> dtoList= this.bookMapper.mapToResponseList(books);
        return new SuccessDataResult<>(dtoList);

    }

    @Override
    public Result delete(int id) throws BusinessException {
        var data= this.bookRepository.findById(id).orElseThrow(()->new BusinessException(Messages.bookNotFoundMessage(id)));
       this.bookRepository.delete(data);
        return new SuccessResult(Messages.BOOK_DELETED_MESSAGE);
    }


}
