package com.example.kotlinjavaproject.Business.Concretes;

import com.example.kotlinjavaproject.Business.Abstracts.CategoryService;
import com.example.kotlinjavaproject.Business.Constants.Messages.Messages;
import com.example.kotlinjavaproject.Business.Profiles.CategoryMapper;
import com.example.kotlinjavaproject.Core.Exceptions.BusinessException;
import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Core.Results.SuccessDataResult;
import com.example.kotlinjavaproject.Core.Results.SuccessResult;
import com.example.kotlinjavaproject.Dtos.Request.Category.CategoryAddDto;
import com.example.kotlinjavaproject.Dtos.Request.Category.CategoryUpdateDto;
import com.example.kotlinjavaproject.Dtos.Response.Category.CategoryResponseDto;
import com.example.kotlinjavaproject.Entities.Category;
import com.example.kotlinjavaproject.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
@Service
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryManager(CategoryRepository categoryRepository,@Qualifier("first_preference") CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public DataResult<List<CategoryResponseDto>> getAllCategories() {
        var data=this.categoryRepository.findAll();
        List<CategoryResponseDto> dto= this.categoryMapper.entityListToResponseList(data);
        return new SuccessDataResult<>(dto);
    }

    @Override
    public DataResult<CategoryResponseDto> getCategoryById(int id) throws BusinessException {

        var data=this.categoryRepository.findById(id).orElseThrow(()-> new BusinessException(Messages.categoryNotFound(id)));
        CategoryResponseDto categoryResponseDto=this.categoryMapper.entityToResponse(data);
        return new SuccessDataResult<>(categoryResponseDto);
    }

    @Override
    public Result add(CategoryAddDto categoryAddDto) {
        Category category=this.categoryMapper.addDtoToEntity(categoryAddDto);
        this.categoryRepository.save(category);
        return new SuccessResult(Messages.CATEGORY_ADDED_MESSAGE);
    }

    @Override
    public Result update(CategoryUpdateDto categoryUpdateDto) throws BusinessException {
        var data=this.categoryRepository.findById(Objects.requireNonNull(categoryUpdateDto.getId()))
                .orElseThrow(()->new BusinessException(Messages.categoryNotFound(categoryUpdateDto.getId())));
        this.categoryRepository.save(data);
        return new SuccessResult(Messages.CATEGORY_UPDATED_MESSAGE);
    }

    @Override
    public Result delete(int id) throws BusinessException {
        var data=this.categoryRepository.findById(id).orElseThrow(()->new BusinessException(Messages.categoryNotFound(id)));
       this.categoryRepository.delete(data);
        return new SuccessResult(Messages.CATEGORY_DELETED_MESSAGE);
    }

}
