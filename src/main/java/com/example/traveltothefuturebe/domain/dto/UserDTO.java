package com.example.traveltothefuturebe.domain.dto;

import com.example.traveltothefuturebe.common.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserDTO {
    private String username;
    private UserRole role;
    private String id;
}
