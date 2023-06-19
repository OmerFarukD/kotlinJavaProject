package com.example.kotlinjavaproject.Repository;

import com.example.kotlinjavaproject.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


    List<Book> findAllByCategory_Id(int categoryId);
    List<Book> findAllByAuthor_Id(int authorId);
}
