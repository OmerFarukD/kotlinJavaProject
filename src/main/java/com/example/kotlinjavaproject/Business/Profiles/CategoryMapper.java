package com.example.kotlinjavaproject.Business.Profiles;

import com.example.kotlinjavaproject.Dtos.Request.Category.CategoryAddDto;
import com.example.kotlinjavaproject.Dtos.Response.Category.CategoryResponseDto;
import com.example.kotlinjavaproject.Entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE= Mappers.getMapper(CategoryMapper.class);
    List<CategoryResponseDto> entityListToResponseList(List<Category> categories);
    CategoryResponseDto entityToResponse(Category category);
    Category addDtoToEntity(CategoryAddDto categoryAddDto);
    Category responseToEntity(CategoryResponseDto categoryResponseDto);
}
