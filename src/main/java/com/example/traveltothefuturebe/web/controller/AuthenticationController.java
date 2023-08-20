package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.domain.dto.UserDTO;
import com.example.traveltothefuturebe.web.request.RequestCreateUser;
import com.example.traveltothefuturebe.web.request.RequestSignIn;
import com.example.traveltothefuturebe.web.response.JwtAuthenticationResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationController {

    ResponseEntity<UserDTO> createUser(RequestCreateUser requestCreateUser);
    ResponseEntity<JwtAuthenticationResponse> signIn(RequestSignIn requestSignIn);

}
