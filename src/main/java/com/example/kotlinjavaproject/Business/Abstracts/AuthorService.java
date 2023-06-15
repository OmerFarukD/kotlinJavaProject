package com.example.kotlinjavaproject.Business.Abstracts;

import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Dtos.Request.Author.AuthorAddDto;
import com.example.kotlinjavaproject.Dtos.Request.Author.AuthorUpdateDto;
import com.example.kotlinjavaproject.Dtos.Response.Author.AuthorResponseDto;

import java.util.List;

public interface AuthorService {
    DataResult<List<AuthorResponseDto>> getAll();
    DataResult<AuthorResponseDto> getById(int id);
    Result add(AuthorAddDto authorAddDto);
    Result update(AuthorUpdateDto authorUpdateDto);
    Result delete(int id);
}
