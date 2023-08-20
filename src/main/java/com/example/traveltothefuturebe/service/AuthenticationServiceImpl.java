package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.domain.dto.UserDTO;
import com.example.traveltothefuturebe.domain.mapper.UserMapper;
import com.example.traveltothefuturebe.domain.model.User;
import com.example.traveltothefuturebe.repository.UserRepository;
import com.example.traveltothefuturebe.web.request.RequestCreateUser;
import com.example.traveltothefuturebe.web.request.RequestSignIn;
import com.example.traveltothefuturebe.web.response.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDTO createUser(RequestCreateUser requestCreateUser) {
        User user = User.builder().password(passwordEncoder.encode(requestCreateUser.getPassword()))
                .username(requestCreateUser.getUsername())
                .role(requestCreateUser.getRole()).build();
        User createdUser = userRepository.save(user);
        return userMapper.userToUserDTO(createdUser);
    }


    @Override
    public JwtAuthenticationResponse signIn(RequestSignIn signInRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword()));
        User user = userRepository.findByUsername(signInRequest.getUsername()).orElseThrow(()->
                new IllegalArgumentException("Invalid username or password"));
        String jwt = jwtService.generateToken(user);
        return  JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
