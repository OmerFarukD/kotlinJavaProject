package com.example.kotlinjavaproject.Api;

import com.example.kotlinjavaproject.Entities.Book;
import com.example.kotlinjavaproject.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
private final BookRepository bookRepository;


@PostMapping("/add")
public void add(@RequestBody Book book){
    this.bookRepository.save(book);
}


}
