package br.edu.les.module.client.repository;

import br.edu.les.module.client.domain.Estado;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Integer> {}
