package com.example.kotlinjavaproject.Security.Service

import com.example.kotlinjavaproject.Core.Results.DataResult
import com.example.kotlinjavaproject.Security.Models.AuthResponse
import com.example.kotlinjavaproject.Security.Models.LoginDto
import com.example.kotlinjavaproject.Security.Models.RegisterDto

interface AuthenticationService {
    fun register(registerDto: RegisterDto): DataResult<AuthResponse>
    fun login(loginDto: LoginDto): DataResult<AuthResponse>
}