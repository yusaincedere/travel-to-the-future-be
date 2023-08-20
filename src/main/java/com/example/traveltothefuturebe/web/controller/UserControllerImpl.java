package com.example.traveltothefuturebe.web.controller;
import com.example.traveltothefuturebe.common.URLConstants;
import com.example.traveltothefuturebe.domain.dto.UserDTO;
import com.example.traveltothefuturebe.repository.UserRepository;
import com.example.traveltothefuturebe.service.UserService;
import com.example.traveltothefuturebe.web.request.RequestCreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = URLConstants.USER)
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController{
    private final UserService userService;



}
