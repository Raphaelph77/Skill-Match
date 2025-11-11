package com.skillmatch.dto;

import lombok.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    @NotBlank
    private String nomeCompleto;

    @Email
    @NotBlank
    private String email;

    private String profissao;

    @NotBlank
    private String senha;
}
