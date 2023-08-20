package com.example.traveltothefuturebe.common;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Random;

@Component
@Getter
public class SecretKeyProvider {
    private String jwtSecretKey;

    @PostConstruct
    public void   init(){
        byte[] secretBytes = new byte[64];
        new Random().nextBytes(secretBytes);
        jwtSecretKey = Base64.getEncoder().encodeToString(secretBytes);
    }

}
