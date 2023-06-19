package com.example.kotlinjavaproject.Business.Profiles.Concrete;

import com.example.kotlinjavaproject.Business.Profiles.CategoryMapper;
import com.example.kotlinjavaproject.Dtos.Request.Category.CategoryAddDto;
import com.example.kotlinjavaproject.Dtos.Response.Category.CategoryResponseDto;
import com.example.kotlinjavaproject.Entities.Category;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("first_preference")
public class CategoryProfile implements CategoryMapper {
    @Override
    public List<CategoryResponseDto> entityListToResponseList(List<Category> categories) {
        if (categories.isEmpty()){
            return new ArrayList<>();
        }
        return categories.stream().map(this::entityToResponse).toList();
    }

    @Override
    public CategoryResponseDto entityToResponse(Category category) {
        if (category == null){
            return null;
        }
        CategoryResponseDto categoryResponseDto= new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setCategoryName(category.getCategoryName());
        return categoryResponseDto;
    }

    @Override
    public Category addDtoToEntity(CategoryAddDto categoryAddDto) {
        if (categoryAddDto ==null){
            return null;
        }

        Category category= new Category();
        category.setCategoryName(categoryAddDto.getCategoryName());
        return category;
    }

    @Override
    public Category responseToEntity(CategoryResponseDto categoryResponseDto) {
        if (categoryResponseDto == null){
            return null;
        }
        Category category= new Category();
        category.setId(categoryResponseDto.getId());
        category.setCategoryName(category.getCategoryName());
        return category;
    }
}
