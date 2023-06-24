package com.example.kotlinjavaproject.Security.Converters;

import com.example.kotlinjavaproject.Security.Models.LoginDto;
import com.example.kotlinjavaproject.Security.Models.RegisterDto;
import com.example.kotlinjavaproject.Security.Models.Role;
import com.example.kotlinjavaproject.Security.Models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthProfile implements AuthMapper{

    private final PasswordEncoder passwordEncoder;
    @Override
    public User registerToEntity(RegisterDto registerDto) {

        if (registerDto == null){
            return null;
        }
        User user= new User();
        user.setEmail(registerDto.getEmail());
        user.setFirstname(registerDto.getFirstName());
        user.setLastname(registerDto.getLastName());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRole(Role.USER);

        return user;
    }

}
