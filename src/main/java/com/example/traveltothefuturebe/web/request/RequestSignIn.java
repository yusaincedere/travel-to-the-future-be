package com.example.traveltothefuturebe.web.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestSignIn {
    private String username;
    private String password;
}
