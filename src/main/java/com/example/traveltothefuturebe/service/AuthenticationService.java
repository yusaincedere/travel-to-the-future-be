package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.web.request.RequestSignIn;
import com.example.traveltothefuturebe.web.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signIn(RequestSignIn signInRequest);
}
