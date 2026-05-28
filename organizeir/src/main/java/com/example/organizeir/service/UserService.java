package com.example.organizeir.service;

import com.example.organizeir.dto.user.*;
import com.example.organizeir.exception.BusinessException;
import com.example.organizeir.model.User;
import com.example.organizeir.repository.UserRepository;
import com.example.organizeir.security.JwtService;
import com.example.organizeir.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    public UserResponseDTO registerDefault(UserRegisterDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            logger.error("Email {} já está em uso", dto.getEmail());
            throw new BusinessException("Email já está em uso");
        }

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getNome());

        String hash = passwordEncoder.encode(dto.getPassword());
        user.setPassword(hash);

        user.setCpf(dto.getCpf());

        User saved = userRepository.save(user);

        logger.info("Usuário {} criado com sucesso", saved.getName());

        String token = jwtService.generateToken(saved.getEmail());

        logger.info("Token JWT gerado para usuário {}", saved.getEmail());

        return new UserResponseDTO(saved.getEmail(), token);

    }
}
