package com.example.kotlinjavaproject.Security.Converters;

import com.example.kotlinjavaproject.Security.Models.LoginDto;
import com.example.kotlinjavaproject.Security.Models.RegisterDto;
import com.example.kotlinjavaproject.Security.Models.User;

public interface AuthMapper {

    User registerToEntity(RegisterDto registerDto);

}
