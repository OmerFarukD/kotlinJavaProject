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
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookManager implements BookService {

    private final BookRepository bookRepository;

    @Override
    public DataResult<Page<BookResponseDto>> getAllBooksByPage(Pageable pageable) {
        return null;
    }

    @Override
    public DataResult<BookResponseDto> getById(int id) throws BusinessException {
        var data= this.bookRepository.findById(id).orElseThrow(()->new BusinessException(Messages.bookNotFoundMessage(id)));
        BookResponseDto dto= BookMapper.INSTANCE.entityToResponse(data);
        return new SuccessDataResult<>(dto);
    }

    @Override
    public Result add(BookAddDto bookAddDto) {
        Book book=BookMapper.INSTANCE.addDtoToEntity(bookAddDto);
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
    public DataResult<Page<BookResponseDto>> getAllByCategoryId(Pageable pageable,int categoryId) {
        var books=this.bookRepository.findAllByCategory_Id(pageable,categoryId);
        Page<BookResponseDto> dto= BookMapper.INSTANCE.mapToPage(books);
        return new SuccessDataResult<>(dto);
    }

    @Override
    public Result delete(int id) throws BusinessException {
        var data= this.bookRepository.findById(id).orElseThrow(()->new BusinessException(Messages.bookNotFoundMessage(id)));
       this.bookRepository.delete(data);
        return new SuccessResult(Messages.BOOK_DELETED_MESSAGE);
    }

    @Override
    public DataResult<Page<BookResponseDto>> getAllByAuthorId(Pageable pageable, int authorId) {
        var books=this.bookRepository.findAllByAuthor_Id(pageable,authorId);
        Page<BookResponseDto> dto= BookMapper.INSTANCE.mapToPage(books);
        return new SuccessDataResult<>(dto);
    }
}
