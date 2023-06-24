package com.example.kotlinjavaproject.Dtos.Request.Author

import com.example.kotlinjavaproject.AOP.Aspects.Validation.AuthorAddValidationRules


@AuthorAddValidationRules
 data class AuthorAddDto(val name:String) {
}