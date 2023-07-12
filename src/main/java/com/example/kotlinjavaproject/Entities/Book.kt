package com.example.kotlinjavaproject.Entities

import jakarta.persistence.*

@Entity
@Table(name = "books")
 class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int=0;

    @Column(name = "title")
    var title:String?=null;
    @Column(name = "price")
    var price:Double=0.0;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    var author: Author? =null;

    @Column(name = "description")
    var description:String?=null;

    @Column(name = "stock")
    var stock:Int?=null;

    @ManyToOne
    @JoinColumn(name = "category_id")
    var category:Category?=null;

}