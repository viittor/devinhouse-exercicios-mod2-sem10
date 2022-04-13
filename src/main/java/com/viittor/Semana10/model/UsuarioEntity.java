package com.viittor.Semana10.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userger")
    @SequenceGenerator(name = "userger", sequenceName = "usuario_id_seq")
    private Long id;

    private String login;

    private String senha;

    private String email;

    private String nome;

    private String cpf;


}
