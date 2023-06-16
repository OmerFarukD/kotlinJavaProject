package com.example.kotlinjavaproject.Api;
import com.example.kotlinjavaproject.Business.Abstracts.BookService;
import com.example.kotlinjavaproject.Core.Exceptions.BusinessException;
import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookAddDto;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookUpdateDto;
import com.example.kotlinjavaproject.Dtos.Response.Book.BookResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody BookAddDto bookAddDto){
        var data=this.bookService.add(bookAddDto);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@Valid @RequestBody BookUpdateDto bookUpdateDto) throws BusinessException {
        var data= this.bookService.update(bookUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<Page<BookResponseDto>>> getAllByPage(@RequestParam Pageable pageable){
        var data= this.bookService.getAllBooksByPage(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @GetMapping("/getbyid")
    public ResponseEntity<DataResult<BookResponseDto> > getById(@RequestParam int id) throws BusinessException{
        var data=this.bookService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @GetMapping("/getbycategoryid")
    public ResponseEntity<DataResult<Page<BookResponseDto>>> getCategoryId(@RequestParam Pageable pageable,@RequestParam int categoryId){
        var data= this.bookService.getAllByCategoryId(pageable,categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getbyauthorid")
    public ResponseEntity<DataResult<Page<BookResponseDto>>> getAuthorId(@RequestParam Pageable pageable,@RequestParam int authorId){
        var data= this.bookService.getAllByAuthorId(pageable,authorId);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
