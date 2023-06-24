package com.example.kotlinjavaproject.Security.Service;

import com.example.kotlinjavaproject.Core.Exceptions.UserNotFoundException;
import com.example.kotlinjavaproject.Core.Results.DataResult;
import com.example.kotlinjavaproject.Core.Results.SuccessDataResult;
import com.example.kotlinjavaproject.Security.Converters.AuthMapper;
import com.example.kotlinjavaproject.Security.Models.AuthResponse;
import com.example.kotlinjavaproject.Security.Models.LoginDto;
import com.example.kotlinjavaproject.Security.Models.RegisterDto;
import com.example.kotlinjavaproject.Security.Models.User;
import com.example.kotlinjavaproject.Security.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationManage implements AuthenticationService{

    private final UserRepository userRepository;
    private final AuthMapper authMapper;
    private final IJwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @NotNull
    @Override
    public DataResult<AuthResponse> register(@NotNull RegisterDto registerDto) {

        User user= this.authMapper.registerToEntity(registerDto);
        this.userRepository.save(user);

        AuthResponse authResponse = getAuthResponse(user);
        return new SuccessDataResult<>(authResponse);
    }



    @NotNull
    @Override
    public DataResult<AuthResponse> login(@NotNull LoginDto loginDto) {

        authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
                  loginDto.getEmail(),
                  loginDto.getPassword()
          )
        );
        var user= this.userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(()-> new UserNotFoundException("Kullanıcıya ait email bulunamadı."));

        AuthResponse authResponse=getAuthResponse(user);
        return new SuccessDataResult<>(authResponse);
    }


    @NotNull
    private AuthResponse getAuthResponse(User user) {
        var jwt=jwtService.generateToken(user);

        AuthResponse authResponse= new AuthResponse();
        authResponse.setToken(jwt);
        return authResponse;
    }
}
