package com.viittor.Semana10.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    @NotNull("Esta informação é requerida!")
    private String login;

    @NotNull("Esta informação é requerida!")
    private String senha;

    private String email;

    private String nome;

    private String cpf;
}
