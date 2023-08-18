package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.domain.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserController {
    ResponseEntity<UserDTO> createUser();
}
