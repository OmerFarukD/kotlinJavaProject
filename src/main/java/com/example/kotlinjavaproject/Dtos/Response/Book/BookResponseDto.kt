package com.example.kotlinjavaproject.Dtos.Response.Book

import com.example.kotlinjavaproject.Dtos.Response.Author.AuthorResponseDto

sealed class BookResponseDto {
    val id:Int?=null;
    val title:String?=null;
    val price:Double?=null;
    val description:String?=null;
    val stock:Int?=null;



}