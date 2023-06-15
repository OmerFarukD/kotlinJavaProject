package com.example.kotlinjavaproject.Entities

import jakarta.persistence.*

@Entity
@Table(name = "authors")
 class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    val id:Int?=null;

    @Column(name="name")
    val name:String?=null;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val books:List<Book>?=null;
}