package com.example.organizeir.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotBlank(message = "O username é obrigatório")
    @Size(min = 3, max = 20, message = "O Nome deve ter entre 3 e 20 caracteres")
    private String nome;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 5, message = "A senha deve ter no mínimo 5 caracteres")
    private String password;

    @NotBlank(message = "O CPF é obrigatório")
    @Size(min = 10, max = 11, message = "Informe um CPF válido")
    private String cpf;
}