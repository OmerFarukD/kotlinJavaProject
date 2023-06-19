package com.example.kotlinjavaproject.Business.Profiles;

import com.example.kotlinjavaproject.Dtos.Request.Category.CategoryAddDto;
import com.example.kotlinjavaproject.Dtos.Response.Category.CategoryResponseDto;
import com.example.kotlinjavaproject.Entities.Category;


import java.util.List;


public interface CategoryMapper {

    List<CategoryResponseDto> entityListToResponseList(List<Category> categories);
    CategoryResponseDto entityToResponse(Category category);
    Category addDtoToEntity(CategoryAddDto categoryAddDto);
    Category responseToEntity(CategoryResponseDto categoryResponseDto);
}
