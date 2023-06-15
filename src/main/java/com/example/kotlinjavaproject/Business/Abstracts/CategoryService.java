package com.example.kotlinjavaproject.Business.Abstracts;

import com.example.kotlinjavaproject.Core.Exceptions.BusinessException;
import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Dtos.Request.Category.CategoryAddDto;
import com.example.kotlinjavaproject.Dtos.Request.Category.CategoryUpdateDto;
import com.example.kotlinjavaproject.Dtos.Response.Category.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    DataResult<List<CategoryResponseDto>> getAllCategories();
    DataResult<CategoryResponseDto> getCategoryById(int id) throws BusinessException;
    Result add(CategoryAddDto categoryAddDto);
    Result update(CategoryUpdateDto categoryUpdateDto) throws BusinessException;
    Result delete(int id) throws BusinessException;
}
