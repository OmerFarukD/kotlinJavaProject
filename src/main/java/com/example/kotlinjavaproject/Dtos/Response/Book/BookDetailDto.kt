package com.example.kotlinjavaproject.Dtos.Response.Book

import com.example.kotlinjavaproject.Dtos.Response.Author.AuthorResponseDto
import com.example.kotlinjavaproject.Dtos.Response.Category.CategoryResponseDto

 class BookDetailDto {
     val id:Int?=null;
     val title:String?=null;
     val price:Double?=null;
     val description:String?=null;
     val stock:Int?=null;
     val authorResponseDto: AuthorResponseDto?=null;
     val categoryResponseDto:CategoryResponseDto?=null;
}