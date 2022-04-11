package com.viittor.Semana10.repository;

import com.viittor.Semana10.model.UsuarioEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long>, JpaSpecificationExecutor<UsuarioEntity> {

    List<UsuarioEntity> findUsuarioRepositoryById(Long id);
    List<UsuarioEntity> findUsuarioRepositoryByNomeAndOrEmail(String nome, String email);
    Optional<UsuarioEntity> findUsuarioEntityByLogin (String login);

}
