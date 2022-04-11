package com.viittor.Semana10.repository;

import com.viittor.Semana10.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long>, JpaSpecificationExecutor<UsuarioEntity> {

    List<UsuarioEntity> findUsuarioRepositoryById(Long id);
    List<UsuarioEntity> findUsuarioRepositoryByNomeAndOrEmail(String nome, String email);

}
