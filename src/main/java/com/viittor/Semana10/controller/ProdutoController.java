package com.viittor.Semana10.controller;

import com.viittor.Semana10.dto.ProdutoDTO;
import com.viittor.Semana10.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/product")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping
    public ProdutoDTO getById(
            @RequestParam(value = "id", required = true) Long id
            ){
        Optional<ProdutoDTO> produto = repository.findById(id);

        return produto.get();
    }

    @GetMapping
    public List<ProdutoDTO> getList(
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "preco_minimo", required = false)BigDecimal precoMin,
            @RequestParam(value = "preco_maximo", required = false) BigDecimal precoMax
            ){
        List<ProdutoDTO> lista = repository.findAllByNomeProdutoAndOrPrecoMaximoAndOrPrecoMinimo(nome, precoMin, precoMax);

        return lista;
    }

    @PatchMapping
    public void patch ( @RequestParam(value = "id", required = true) Long id, String nome, Integer codigo, BigDecimal preco, BigDecimal minimo, BigDecimal maximo){
        Optional<ProdutoDTO> produto = repository.findById(id);
        produto.get().setNomeProduto(nome);
        produto.get().setCodigoBarras(codigo);
        produto.get().setPrecoSugerido(preco);
        produto.get().setPrecoMinimo(minimo);
        produto.get().setPrecoMaximo(maximo);
    }

    @PostMapping
    public void post (String nome, Integer codigo, BigDecimal preco, BigDecimal minimo, BigDecimal maximo){
        ProdutoDTO produto = new ProdutoDTO();

        produto.setNomeProduto(nome);
        produto.setCodigoBarras(codigo);
        produto.setPrecoSugerido(preco);
        produto.setPrecoMinimo(minimo);
        produto.setPrecoMaximo(maximo);
        repository.save(produto);
    }

    @DeleteMapping
    public void delete(
            @RequestParam(value = "id", required = true) Long id){
        repository.deleteById(id);
    }



}
