package com.example.kotlinjavaproject.Dtos.Request.Book

sealed class BookUpdateDto {
    val id:Int?=null;
    val title:String?=null;
    val price:Double?=null;
    val authorId:Int?=null;
    val description:String?=null;
    val stock:Int?=null;
    val categoryId:Int?=null;
}
