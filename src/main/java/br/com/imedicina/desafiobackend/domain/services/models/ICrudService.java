package br.com.imedicina.desafiobackend.domain.services.models;

import br.com.imedicina.desafiobackend.domain.dtos.MetadataDto;

import java.util.List;

public interface ICrudService<D>{

    List<D> findAll();
    D findById(Long id);
    D create(D dto);
    D update(Long id, D dto);
    void delete(Long id);

}
