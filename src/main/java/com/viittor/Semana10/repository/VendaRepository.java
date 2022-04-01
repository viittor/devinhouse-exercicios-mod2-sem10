package com.viittor.Semana10.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository  extends CrudRepository <VendaRepository, Long> {
}
