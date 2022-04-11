package com.viittor.Semana10.controller;

import com.viittor.Semana10.model.UsuarioEntity;
import com.viittor.Semana10.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @GetMapping
    public List<UsuarioEntity> getUserListById(
            @RequestParam(value = "id", required = false) Long id
    ){
        List<UsuarioEntity> listById = repository.findUsuarioRepositoryById(id);

        return listById;
    }

    @GetMapping
    public List<UsuarioEntity> getUserListById(
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "nome", required = false) String nome
    ){
        List<UsuarioEntity> list = repository.findUsuarioRepositoryByNomeAndOrEmail(nome, email);
        return list;
    }


    @PostMapping
    public void postUser(String login, String senha, String email, String nome, String cpf){
        UsuarioEntity user = new UsuarioEntity();
        user.setLogin(login);
        user.setSenha(senha);
        user.setEmail(email);
        user.setNome(nome);
        user.setCpf(cpf);
        repository.save(user);
    }

    @DeleteMapping
    public void deleteUser(Long id){
        Optional<UsuarioEntity> user = repository.findById(id);
        repository.delete(user.get());
    }


}
