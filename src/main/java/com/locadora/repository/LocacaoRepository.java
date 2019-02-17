package com.locadora.repository;

import com.locadora.model.Locacao;
import org.springframework.data.repository.CrudRepository;

public interface LocacaoRepository extends CrudRepository<Locacao, Long> {
    
}
