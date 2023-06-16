package com.example.kotlinjavaproject.Api;

import com.example.kotlinjavaproject.Business.Abstracts.AuthorService;
import com.example.kotlinjavaproject.Core.Exceptions.BusinessException;
import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Dtos.Request.Author.AuthorAddDto;
import com.example.kotlinjavaproject.Dtos.Request.Author.AuthorUpdateDto;
import com.example.kotlinjavaproject.Dtos.Response.Author.AuthorResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

private final AuthorService authorService;

@GetMapping("/getall")
public ResponseEntity<DataResult<List<AuthorResponseDto>>> getAll(){
    var data= this.authorService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(data);
}

@GetMapping("/getbyid")
public ResponseEntity<DataResult<AuthorResponseDto>> getById(@RequestParam int id) throws BusinessException {
    var data= this.authorService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(data);
}
@PostMapping("/add")
public ResponseEntity<Result> add(@Valid @RequestBody AuthorAddDto authorAddDto){
    var data= this.authorService.add(authorAddDto);
    return ResponseEntity.status(HttpStatus.OK).body(data);
}
@PutMapping("/update")
public ResponseEntity<Result> update(@Valid @RequestBody AuthorUpdateDto authorUpdateDto) throws BusinessException{
    var data= this.authorService.update(authorUpdateDto);
    return ResponseEntity.status(HttpStatus.OK).body(data);
}
@DeleteMapping("/delete")
public ResponseEntity<Result> delete(@Valid @RequestParam Integer id) throws BusinessException{
    var data=this.authorService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body(data);
}

}
