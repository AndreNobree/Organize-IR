package com.example.organizeir.controller;


import com.example.organizeir.dto.user.UserRegisterDTO;
import com.example.organizeir.dto.user.UserResponseDTO;
import com.example.organizeir.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody UserRegisterDTO dto) {
        UserResponseDTO createdUser = userService.registerDefault(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
