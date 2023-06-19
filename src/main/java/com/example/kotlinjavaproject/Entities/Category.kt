package com.example.kotlinjavaproject.Entities

import jakarta.persistence.*

@Entity
@Table(name = "categories")
 class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int?=null;
    @Column(name = "categoryName")
    var categoryName:String?=null;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var books:List<Book>?=null;
}