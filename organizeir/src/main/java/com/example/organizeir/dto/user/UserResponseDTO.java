package com.example.organizeir.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private String email;
    private String token;
    private String refreshToken;

    public UserResponseDTO(String email, String token, String refreshToken) {
        this.email = email;
        this.token = token;
        this.refreshToken = refreshToken;
    }
}