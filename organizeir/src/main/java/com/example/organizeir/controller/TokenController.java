package com.example.organizeir.controller;


import com.example.organizeir.dto.token.AuthResponseDTO;
import com.example.organizeir.dto.token.RefreshTokenRequestDTO;
import com.example.organizeir.service.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
@CrossOrigin(origins = "http://localhost:3000")
public class TokenController {

    @Autowired
    public RefreshTokenService refreshTokenService;

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponseDTO> refresh(@RequestBody RefreshTokenRequestDTO request) {

        return ResponseEntity.ok(
                refreshTokenService.refresh(
                        request.getRefreshToken()
                )
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(
            @RequestBody RefreshTokenRequestDTO request
    ) {

        refreshTokenService.logout(
                request.getRefreshToken()
        );

        return ResponseEntity.noContent().build();
    }
}
