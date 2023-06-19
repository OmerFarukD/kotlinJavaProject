package com.example.kotlinjavaproject.Entities

import jakarta.persistence.*

@Entity
@Table(name = "authors")
 class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    var id:Int=0;

    @Column(name="name")
    var name:String="";

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var books:List<Book> = arrayListOf<Book>()
}