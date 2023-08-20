package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.domain.dto.UserDTO;
import com.example.traveltothefuturebe.web.request.RequestCreateUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDTO createUser(RequestCreateUser requestCreateUser);

    UserDetailsService userDetailsService();
}
