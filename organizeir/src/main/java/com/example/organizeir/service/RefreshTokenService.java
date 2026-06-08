package com.example.organizeir.service;

import com.example.organizeir.dto.token.AuthResponseDTO;
import com.example.organizeir.exception.UnauthorizedException;
import com.example.organizeir.model.RefreshToken;
import com.example.organizeir.model.User;
import com.example.organizeir.repository.RefreshTokenRepository;
import com.example.organizeir.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private static final Logger logger =
            LoggerFactory.getLogger(RefreshTokenService.class);

    private static final long REFRESH_TOKEN_DAYS = 7;

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtService jwtService;

    public RefreshToken create(User user) {

        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUser(user);
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken.setExpiresAt(
                LocalDateTime.now()
                        .plusDays(REFRESH_TOKEN_DAYS)
        );

        RefreshToken saved =
                refreshTokenRepository.save(refreshToken);

        logger.info(
                "Refresh token criado para usuário {}",
                user.getEmail()
        );

        return saved;
    }

    public AuthResponseDTO refresh(String tokenValue) {

        RefreshToken refreshToken =
                refreshTokenRepository.findByToken(tokenValue)
                        .orElseThrow(() -> {
                            logger.warn(
                                    "Tentativa de uso de refresh token inexistente"
                            );

                            return new UnauthorizedException(
                                    "Refresh token inválido"
                            );
                        });

        if (Boolean.TRUE.equals(refreshToken.getRevoked())) {

            logger.warn(
                    "Tentativa de uso de refresh token revogado"
            );

            throw new UnauthorizedException(
                    "Refresh token revogado"
            );
        }

        if (refreshToken.getExpiresAt()
                .isBefore(LocalDateTime.now())) {

            logger.warn(
                    "Tentativa de uso de refresh token expirado"
            );

            throw new UnauthorizedException(
                    "Refresh token expirado"
            );
        }

        User user = refreshToken.getUser();

        String accessToken =
                jwtService.generateToken(user.getEmail());

        logger.info(
                "Novo JWT gerado para usuário {}",
                user.getEmail()
        );

        return new AuthResponseDTO(
                accessToken,
                refreshToken.getToken()
        );
    }

    public void logout(String tokenValue) {

        RefreshToken refreshToken =
                refreshTokenRepository.findByToken(tokenValue)
                        .orElseThrow(() ->
                                new UnauthorizedException(
                                        "Token não encontrado"
                                )
                        );

        refreshToken.setRevoked(true);

        refreshTokenRepository.save(refreshToken);

        logger.info(
                "Logout realizado para usuário {}",
                refreshToken.getUser().getEmail()
        );
    }
}