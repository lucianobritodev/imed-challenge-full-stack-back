package br.com.imedicina.desafiobackend.domain.services;

import br.com.imedicina.desafiobackend.domain.domainexceptions.BusinessRuleException;
import br.com.imedicina.desafiobackend.domain.domainexceptions.InvalidIdentifierException;
import br.com.imedicina.desafiobackend.domain.domainexceptions.ResourceNotFoundException;
import br.com.imedicina.desafiobackend.domain.dtos.HealthcareProfessionalDto;
import br.com.imedicina.desafiobackend.domain.entities.HealthcareProfessional;
import br.com.imedicina.desafiobackend.domain.repositories.HealthcareProfessionalRepository;
import br.com.imedicina.desafiobackend.domain.services.models.IConverterService;
import br.com.imedicina.desafiobackend.domain.services.models.ICrudService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("healthcareProService")
@AllArgsConstructor
@Slf4j
public class HealthcareProfessionalService implements ICrudService<HealthcareProfessionalDto>, IConverterService<HealthcareProfessionalDto, HealthcareProfessional> {

    private HealthcareProfessionalRepository healthcareProfessionalRepository;
    private ModelMapper mapper;

    @Transactional(readOnly = true)
    public List<HealthcareProfessionalDto> findAll() {

        return healthcareProfessionalRepository.findAll()
                .stream()
                .map(x -> this.copyEntityToDto(x, HealthcareProfessionalDto.class))
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public HealthcareProfessionalDto findById(Long id) {

        if(id == null)
            throw new InvalidIdentifierException("A resource identifier cannot be null or empty!");

        return healthcareProfessionalRepository.findById(id)
                .map(x -> this.copyEntityToDto(x, HealthcareProfessionalDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));

    }

    @Transactional
    public HealthcareProfessionalDto create(HealthcareProfessionalDto dto) {

        try {
            HealthcareProfessional entity = healthcareProfessionalRepository
                    .save(this.copyDtoToEntity(dto, HealthcareProfessional.class));
            dto = this.copyEntityToDto(entity, HealthcareProfessionalDto.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessRuleException(e.getMessage());
        }
        return dto;

    }

    @Transactional
    public HealthcareProfessionalDto update(Long id, HealthcareProfessionalDto dto) {

        try {
            this.findById(id);
            HealthcareProfessional entity = this.copyDtoToEntity(dto, HealthcareProfessional.class);
            entity.setId(id);
            entity = healthcareProfessionalRepository.saveAndFlush(entity);
            dto = this.copyEntityToDto(entity, HealthcareProfessionalDto.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessRuleException(e.getMessage());
        }
        return dto;

    }

    @Transactional
    public void delete(Long id) {

        try {
            this.findById(id);
            healthcareProfessionalRepository.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessRuleException(e.getMessage());
        }

    }

    @Override
    public HealthcareProfessional copyDtoToEntity(
            HealthcareProfessionalDto dto, Class<HealthcareProfessional> entity) {
        return mapper.map(dto, entity);
    }

    @Override
    public HealthcareProfessionalDto copyEntityToDto(
            HealthcareProfessional entity, Class<HealthcareProfessionalDto> dto) {
        return mapper.map(entity, dto);
    }
}
