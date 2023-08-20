package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.common.URLConstants;
import com.example.traveltothefuturebe.domain.dto.UserDTO;
import com.example.traveltothefuturebe.service.AuthenticationService;
import com.example.traveltothefuturebe.web.request.RequestCreateUser;
import com.example.traveltothefuturebe.web.request.RequestSignIn;
import com.example.traveltothefuturebe.web.response.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = URLConstants.AUTHENTICATION)
@RestController
@RequiredArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController{
    private final AuthenticationService authenticationService;

    @Override
    public ResponseEntity<UserDTO> createUser(RequestCreateUser requestCreateUser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.createUser(requestCreateUser));
    }

    @PostMapping(path = URLConstants.AuthenticationUrlConstants.SIGN_IN)
    @Override
    public ResponseEntity<JwtAuthenticationResponse> signIn(RequestSignIn requestSignIn) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.signIn(requestSignIn));
    }
}
