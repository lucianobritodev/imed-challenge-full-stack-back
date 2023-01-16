package br.com.imedicina.desafiobackend.domain.services;

import br.com.imedicina.desafiobackend.domain.domainexceptions.BusinessRuleException;
import br.com.imedicina.desafiobackend.domain.domainexceptions.InvalidIdentifierException;
import br.com.imedicina.desafiobackend.domain.domainexceptions.ResourceNotFoundException;
import br.com.imedicina.desafiobackend.domain.dtos.PatientDto;
import br.com.imedicina.desafiobackend.domain.entities.Patient;
import br.com.imedicina.desafiobackend.domain.repositories.PatientRepository;
import br.com.imedicina.desafiobackend.domain.services.models.IConverterService;
import br.com.imedicina.desafiobackend.domain.services.models.ICrudService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("patientService")
@AllArgsConstructor
@Slf4j
public class PatientService implements ICrudService<PatientDto>, IConverterService<PatientDto, Patient> {

    private PatientRepository patientRepository;
    private ModelMapper mapper;

    @Transactional(readOnly = true)
    public List<PatientDto> findAll() {

        return patientRepository.findAll()
                .stream()
                .map(x -> this.copyEntityToDto(x, PatientDto.class))
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public PatientDto findById(Long id) {

        if(id == null)
            throw new InvalidIdentifierException("A resource identifier cannot be null or empty!");

        return patientRepository.findById(id)
                .map(x -> this.copyEntityToDto(x, PatientDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));

    }

    @Transactional
    public PatientDto create(PatientDto dto) {

        try {
            Patient entity = patientRepository.save(this.copyDtoToEntity(dto, Patient.class));
            dto = this.copyEntityToDto(entity, PatientDto.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessRuleException(e.getMessage());
        }
        return dto;

    }

    @Transactional
    public PatientDto update(Long id, PatientDto dto) {

        try {
            this.findById(id);
            Patient entity = this.copyDtoToEntity(dto, Patient.class);
            entity.setId(id);
            entity = patientRepository.saveAndFlush(entity);
            dto = this.copyEntityToDto(entity, PatientDto.class);
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
            patientRepository.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessRuleException(e.getMessage());
        }

    }

    @Override
    public final Patient copyDtoToEntity(PatientDto dto, Class<Patient> entity) {
        return mapper.map(dto, entity);
    }

    @Override
    public final PatientDto copyEntityToDto(Patient entity, Class<PatientDto> dto) {
        return mapper.map(entity, dto);
    }

}
