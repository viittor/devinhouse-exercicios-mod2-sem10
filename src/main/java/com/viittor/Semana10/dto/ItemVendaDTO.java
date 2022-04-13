package com.viittor.Semana10.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ItemVendaDTO {

    private ProdutoDTO produtoDTO;

    private VendaDTO vendaDTO;

    private BigDecimal precoUnitario;

    private Integer quantidadeVendida;

    public ItemVendaDTO() {

    }
}
