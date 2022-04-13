package com.viittor.Semana10.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class VendaDTO {

    private Long id;

    private UsuarioDTO comprador;

    private UsuarioDTO vendedor;

    private List<ItemVendaDTO> itens;

    public VendaDTO() {

    }
}
