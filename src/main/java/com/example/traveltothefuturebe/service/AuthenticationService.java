package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.domain.dto.UserDTO;
import com.example.traveltothefuturebe.web.request.RequestCreateUser;
import com.example.traveltothefuturebe.web.request.RequestSignIn;
import com.example.traveltothefuturebe.web.response.JwtAuthenticationResponse;

public interface AuthenticationService {

    UserDTO createUser(RequestCreateUser requestCreateUser);
    JwtAuthenticationResponse signIn(RequestSignIn signInRequest);
}
