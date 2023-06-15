package com.example.kotlinjavaproject.Entities

import jakarta.persistence.*

@Entity
@Table(name = "categories")
 class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int?=null;
    @Column(name = "categoryName")
    val categoryName:String?=null;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val books:List<Book>?=null;
}