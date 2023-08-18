package com.example.traveltothefuturebe.domain.model;

import com.example.traveltothefuturebe.common.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Document(collection = "users")
public class User {
    private String username;
    private String password;
    private UserRole role;
}
