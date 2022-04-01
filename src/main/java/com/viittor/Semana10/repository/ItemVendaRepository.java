package com.viittor.Semana10.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends CrudRepository<ItemVendaRepository, Long> {
}
