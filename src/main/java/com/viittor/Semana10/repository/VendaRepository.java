package com.viittor.Semana10.repository;

import com.viittor.Semana10.dto.VendaDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository  extends CrudRepository <VendaDTO, Long> {
}
