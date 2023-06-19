package com.example.kotlinjavaproject.Api;

import com.example.kotlinjavaproject.Business.Abstracts.CategoryService;
import com.example.kotlinjavaproject.Core.Exceptions.BusinessException;
import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Dtos.Request.Category.CategoryAddDto;
import com.example.kotlinjavaproject.Dtos.Response.Category.CategoryResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<CategoryResponseDto>>> getAll(){
        var data= this.categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @GetMapping("/getbyid")
    public ResponseEntity<DataResult<CategoryResponseDto>> getById(@RequestParam int id) throws BusinessException {
        var data= this.categoryService.getCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody CategoryAddDto categoryAddDto){
        var data= this.categoryService.add(categoryAddDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @PostMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam Integer id)throws  BusinessException{
        var data=this.categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

}
