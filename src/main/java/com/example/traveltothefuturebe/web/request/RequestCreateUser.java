package com.example.traveltothefuturebe.web.request;

import com.example.traveltothefuturebe.common.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
public class RequestCreateUser {
    private String username;
    private String password;
    private UserRole role;
}
