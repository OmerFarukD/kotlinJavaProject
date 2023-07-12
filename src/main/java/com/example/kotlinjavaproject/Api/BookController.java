package com.example.kotlinjavaproject.Api;
import com.example.kotlinjavaproject.Business.Abstracts.BookService;
import com.example.kotlinjavaproject.Core.Exceptions.BusinessException;
import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookAddDto;
import com.example.kotlinjavaproject.Dtos.Request.Book.BookUpdateDto;
import com.example.kotlinjavaproject.Dtos.Response.Book.BookResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody BookAddDto bookAddDto){
        var data=this.bookService.add(bookAddDto);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @PostMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam Integer id)throws BusinessException{
        var data= this.bookService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @PostMapping("/update")
    public ResponseEntity<Result> update(@Valid @RequestBody BookUpdateDto bookUpdateDto) throws BusinessException {
        var data= this.bookService.update(bookUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    // BS-107
    // Api ye git bir tane Title göre kitap getiren api yi yaz.

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<BookResponseDto>>> getAll(){
        var data= this.bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @GetMapping("/getbyid")
    public ResponseEntity<DataResult<BookResponseDto> > getById(@RequestParam int id) throws BusinessException{
        var data=this.bookService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @GetMapping("/getbycategoryid")
    public ResponseEntity<DataResult<List<BookResponseDto>>> getCategoryId(@RequestParam int categoryId){
        var data= this.bookService.getAllBooksByCategoryId(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getbyauthorid")
    public ResponseEntity<DataResult<List<BookResponseDto>>> getAuthorId(@RequestParam int authorId){
        var data= this.bookService.getAllBooksByAuthorId(authorId);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

}
