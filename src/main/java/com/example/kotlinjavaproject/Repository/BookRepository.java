package com.example.kotlinjavaproject.Repository;

import com.example.kotlinjavaproject.Entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


    Page<Book> findAllByCategory_Id(Pageable pageable,int categoryId);
    Page<Book> findAllByAuthor_Id(Pageable pageable,int authorId);
}
