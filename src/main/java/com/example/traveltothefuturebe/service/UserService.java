package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.domain.dto.UserDTO;
import com.example.traveltothefuturebe.web.request.RequestCreateUser;

public interface UserService {
    UserDTO createUser(RequestCreateUser requestCreateUser);
}
