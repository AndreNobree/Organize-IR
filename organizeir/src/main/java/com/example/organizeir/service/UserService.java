package com.example.organizeir.service;

import com.example.organizeir.dto.user.*;
import com.example.organizeir.exception.*;
import com.example.organizeir.model.RefreshToken;
import com.example.organizeir.model.User;
import com.example.organizeir.repository.UserRepository;
import com.example.organizeir.security.JwtService;
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

    @Autowired
    private RefreshTokenService refreshTokenService;

    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    public UserResponseDTO registerDefault(UserRegisterDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            logger.error("TENTATIVA DE REGISTRO COM EMAIL [{}] - (EMAIL JÁ EXISTE)", dto.getEmail());
            throw new BusinessException("Email já está em uso");
        }
        if (userRepository.existsByName(dto.getNome())){
            logger.error("TENTATIVA DE REGISTRO COM NOME [{}] - (NOME JÁ EXISTE)", dto.getNome());
            throw new BusinessException("Nome já está em uso");
        }
        if (userRepository.existsByCpf(dto.getCpf())){
            logger.error("TENTATIVA DE REGISTRO COM CPF [{}] - (CPF JÁ EXISTE)", dto.getCpf());
            throw new BusinessException("Cpf já está em uso");
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

        String accessToken =
                jwtService.generateToken(user.getEmail());

        RefreshToken refreshToken =
                refreshTokenService.create(user);

        return new UserResponseDTO(saved.getEmail(), accessToken, refreshToken.getToken());

    }

    public UserResponseDTO login(UserLoginDTO dto){

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> {

                    logger.error(
                            "TENTATIVA INVÁLIDA DE LOGIN COM EMAIL [{}] - (EMAIL NÃO EXISTE)",
                            dto.getEmail()
                    );

                    return new UnauthorizedException("Email ou senha inválidos");
                });


        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())){
            logger.error("TENTATIVA DE LOGIN COM SENHA INVÁLIDA - (SENHA DIFERENTE)");
            throw new UnauthorizedException("Email ou senha não encontrados");
        }

        String accessToken =
                jwtService.generateToken(user.getEmail());

        RefreshToken refreshToken =
                refreshTokenService.create(user);

        return new UserResponseDTO(
                user.getEmail(),
                accessToken,
                refreshToken.getToken()
        );
    }

}
