package com.viittor.Semana10.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;

    @NotNull("Esta informação é requerida!")
    private String nomeProduto;

    private Integer codigoBarras;

    private BigDecimal precoSugerido;

    private BigDecimal precoMinimo;

    private BigDecimal precoMaximo;

    public ProdutoDTO() {

    }
}
