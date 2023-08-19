package com.example.traveltothefuturebe.web.controller;
import com.example.traveltothefuturebe.common.URLConstants;
import com.example.traveltothefuturebe.domain.dto.UserDTO;
import com.example.traveltothefuturebe.web.request.RequestCreateUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = URLConstants.USER)
@RestController
public class UserControllerImpl implements UserController{
    @PostMapping(path = URLConstants.UserUrlConstants.CREATE_USER)
    @Override
    public ResponseEntity<UserDTO> createUser(@RequestBody RequestCreateUser requestCreateUser) {
        return null;
    }


}
