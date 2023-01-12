package br.com.imedicina.desafiobackend.domain.services;

import br.com.imedicina.desafiobackend.domain.dtos.BaseDto;
import br.com.imedicina.desafiobackend.domain.entities.BaseEntity;

public abstract class BaseService<D extends BaseDto, E extends BaseEntity> {

    abstract E copyDtoToEntity(D dto, E entity);
    abstract D copyEntityToDto(E entity, D dto);

}
