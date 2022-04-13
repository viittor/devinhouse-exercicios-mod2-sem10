package com.viittor.Semana10.repository;

import com.viittor.Semana10.dto.ProdutoDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoDTO, Long> {

    List<ProdutoDTO> findAllByNomeProdutoAndOrPrecoMaximoAndOrPrecoMinimo(String nome, BigDecimal precoMin, BigDecimal precoMax);



}
