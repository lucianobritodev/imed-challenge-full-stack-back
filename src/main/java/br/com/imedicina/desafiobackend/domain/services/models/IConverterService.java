package br.com.imedicina.desafiobackend.domain.services.models;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface IConverterService<D, E> {

    abstract E copyDtoToEntity(D dto, Class<E> entity);
    abstract D copyEntityToDto(E entity, Class<D> dto);

}
