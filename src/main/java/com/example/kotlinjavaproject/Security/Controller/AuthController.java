package com.example.kotlinjavaproject.Security.Controller;

import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Security.Models.AuthResponse;
import com.example.kotlinjavaproject.Security.Models.LoginDto;
import com.example.kotlinjavaproject.Security.Models.RegisterDto;
import com.example.kotlinjavaproject.Security.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<DataResult<AuthResponse>> register(@RequestBody RegisterDto registerDto){
        var data= this.authenticationService.register(registerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PostMapping("/login")
    public ResponseEntity<DataResult<AuthResponse>> login(@RequestBody LoginDto loginDto){
        var data=this.authenticationService.login(loginDto);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
