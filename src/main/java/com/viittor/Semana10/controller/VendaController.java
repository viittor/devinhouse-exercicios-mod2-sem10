package com.viittor.Semana10.controller;

import com.viittor.Semana10.dto.ItemVendaDTO;
import com.viittor.Semana10.dto.ProdutoDTO;
import com.viittor.Semana10.dto.VendaDTO;
import com.viittor.Semana10.repository.ProdutoRepository;
import com.viittor.Semana10.repository.UsuarioRepository;
import com.viittor.Semana10.repository.VendaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.websocket.server.PathParam;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/sale")
public class VendaController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    VendaRepository vendaRepository;

    @PostMapping
    @RequestMapping("/comprar")
    public ResponseEntity<Void> post(
            @RequestParam(value = "id_vendedor", required = false) Long idVendedor,
            @RequestParam(value = "items_venda", required = true)List<ItemVendaDTO> itensVenda
            ){
        VendaDTO vendaDTO = new VendaDTO();
        List<ItemVendaDTO> itens;
        if (!usuarioRepository.findById(vendaDTO.getComprador().getId()).isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        } if (!usuarioRepository.findById(vendaDTO.getVendedor().getId()).isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (itensVenda.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        for (ItemVendaDTO item : itensVenda
             ) {

            Optional<ProdutoDTO> produtoDTO = produtoRepository.findById(item.getProdutoDTO().getId());
            if (produtoDTO.isEmpty()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else if (item.getQuantidadeVendida() <= 0){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else if (item.getProdutoDTO().getPrecoMinimo() == BigDecimal.ZERO){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new  ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("/vender")
    public ResponseEntity<Void> postBuy(
            @RequestParam(value = "id_comprador", required = false) Long idComprador,
            @RequestParam(value = "items_venda", required = true)List<ItemVendaDTO> itensVenda
    ){
        VendaDTO vendaDTO = new VendaDTO();
        List<ItemVendaDTO> itens;
        if (!usuarioRepository.findById(vendaDTO.getComprador().getId()).isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        } if (!usuarioRepository.findById(vendaDTO.getVendedor().getId()).isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (itensVenda.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        for (ItemVendaDTO item : itensVenda
        ) {

            Optional<ProdutoDTO> produtoDTO = produtoRepository.findById(item.getProdutoDTO().getId());
            if (produtoDTO.isEmpty()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else if (item.getQuantidadeVendida() <= 0){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else if (item.getProdutoDTO().getPrecoMinimo() == BigDecimal.ZERO){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new  ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping
    @RequestMapping("/venda/{id_venda}")
    public VendaDTO getVenda(
            @PathVariable(name = "id_venda") Long idVenda
    ){
        Optional<VendaDTO> venda = Optional.ofNullable(vendaRepository.findById(idVenda).orElseThrow(() ->
                new EntityNotFoundException("Nenhuma venda encontrada")));

        return venda.get();
    }
}
