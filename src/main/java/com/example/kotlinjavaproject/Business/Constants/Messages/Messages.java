package com.example.kotlinjavaproject.Business.Constants.Messages;

public class Messages {
    private Messages() {

    }

    public static  String bookNotFoundMessage(int id){
        return "Kitap Id : "+id+" bulunamadı.";
    }
    public static String categoryNotFound(int id){
        return "Kategori : "+id+" bulunamadı.";
    }
    public static final String BOOK_ADDED_MESSAGE="Kitap Eklendi";
    public static final String BOOK_UPDATED_MESSAGE="Kitap Güncellendi.";
    public static final String BOOK_DELETED_MESSAGE="Kitap Silindi.";
    public static String authorNotFound(int id){
        return "Yazar id: "+id+" bulunamadı";
    }
    public static final String AUTHOR_ADDED_MESSAGE="Yazar Eklendi.";
    public static final String AUTHOR_UPDATED_MESSAGE="Yazar Güncellendi.";
    public static final String AUTHOR_DELETED_MESSAGE="Yazar Silindi.";

    public static final String CATEGORY_ADDED_MESSAGE="Kategori Eklendi.";
    public static final String CATEGORY_UPDATED_MESSAGE="Kategori Eklendi.";
    public static final String CATEGORY_DELETED_MESSAGE="Kategori Eklendi.";


}
