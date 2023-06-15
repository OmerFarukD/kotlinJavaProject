package com.example.kotlinjavaproject.Entities

import jakarta.persistence.*

@Entity
@Table(name = "books")
 class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int=0;

    @Column(name = "title")
    val title:String?=null;
    @Column(name = "price")
    val price:Double=0.0;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    val author: Author? =null;

    @Column(name = "description")
    val description:String?=null;

    @Column(name = "stock")
    val stock:Int?=null;

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category:Category?=null;
}