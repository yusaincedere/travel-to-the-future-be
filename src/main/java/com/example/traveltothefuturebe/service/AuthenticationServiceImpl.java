package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.repository.UserRepository;
import com.example.traveltothefuturebe.web.request.RequestSignIn;
import com.example.traveltothefuturebe.web.response.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signIn(RequestSignIn signInRequest) {
        return null;
    }
}
