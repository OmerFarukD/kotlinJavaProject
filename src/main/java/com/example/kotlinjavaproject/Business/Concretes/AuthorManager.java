package com.example.kotlinjavaproject.Business.Concretes;

import com.example.kotlinjavaproject.Business.Abstracts.AuthorService;
import com.example.kotlinjavaproject.Business.Constants.Messages.Messages;
import com.example.kotlinjavaproject.Business.Profiles.AuthorMapper;
import com.example.kotlinjavaproject.Core.Exceptions.BusinessException;
import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Core.Results.SuccessDataResult;
import com.example.kotlinjavaproject.Core.Results.SuccessResult;
import com.example.kotlinjavaproject.Dtos.Request.Author.AuthorAddDto;
import com.example.kotlinjavaproject.Dtos.Request.Author.AuthorUpdateDto;
import com.example.kotlinjavaproject.Dtos.Response.Author.AuthorResponseDto;
import com.example.kotlinjavaproject.Entities.Author;
import com.example.kotlinjavaproject.Repository.AuthorRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class AuthorManager implements AuthorService {

    private final AuthorRepository authorRepository;
    @Override
    public DataResult<List<AuthorResponseDto>> getAll() {
        var data= this.authorRepository.findAll();
        List<AuthorResponseDto> dto= AuthorMapper.INSTANCE.mapToResponseList(data);
        return new SuccessDataResult<>(dto);
    }

    @Override
    public DataResult<AuthorResponseDto> getById(int id) throws BusinessException {
        var data= this.authorRepository.findById(id).orElseThrow(()->new BusinessException(Messages.authorNotFound(id)));
        AuthorResponseDto dto= AuthorMapper.INSTANCE.entityToResponse(data);
        return new SuccessDataResult<>(dto);
    }

    @Override
    public Result add(AuthorAddDto authorAddDto) {
        Author author= AuthorMapper.INSTANCE.addDtoToEntity(authorAddDto);
        this.authorRepository.save(author);
        return new SuccessResult(Messages.AUTHOR_ADDED_MESSAGE);
    }

    @Override
    public Result update(AuthorUpdateDto authorUpdateDto) throws BusinessException {
        var data=this.authorRepository.findById(Objects.requireNonNull(authorUpdateDto.getId()))
                .orElseThrow(()-> new BusinessException(Messages.authorNotFound(authorUpdateDto.getId())));
        this.authorRepository.save(data);
        return new SuccessResult(Messages.AUTHOR_UPDATED_MESSAGE);
    }

    @Override
    public Result delete(int id) throws BusinessException {
        var data=this.authorRepository.findById(id)
                .orElseThrow(()-> new BusinessException(Messages.authorNotFound(id)));
        this.authorRepository.delete(data);
        return new SuccessResult(Messages.AUTHOR_DELETED_MESSAGE);
    }


}
