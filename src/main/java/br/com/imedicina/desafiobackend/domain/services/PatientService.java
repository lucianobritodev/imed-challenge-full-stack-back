package br.com.imedicina.desafiobackend.domain.services;

import br.com.imedicina.desafiobackend.domain.domainexceptions.BusinessRuleException;
import br.com.imedicina.desafiobackend.domain.domainexceptions.InvalidIdentifierException;
import br.com.imedicina.desafiobackend.domain.domainexceptions.ResourceNotFoundException;
import br.com.imedicina.desafiobackend.domain.dtos.PatientDto;
import br.com.imedicina.desafiobackend.domain.entities.Patient;
import br.com.imedicina.desafiobackend.domain.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PatientService extends BaseService<PatientDto, Patient> {

    private PatientRepository patientRepository;
    private ModelMapper mapper;

    @Transactional(readOnly = true)
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Patient findById(Long id) {
        if(id == null)
            throw new InvalidIdentifierException("A resource identifier cannot be null or empty!");

        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
    }

    @Transactional
    public Patient create(Patient patient) {

        try {
            patient = patientRepository.save(patient);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessRuleException(e.getMessage());
        }

        return patient;
    }

    @Transactional
    public PatientDto update(Long id, PatientDto patientDto) {
        try {
            Patient patientDb = findById(id);
            patientDb = this.copyDtoToEntity(patientDto, patientDb);
            patientDto = this.copyEntityToDto(patientRepository.save(patientDb), patientDto);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessRuleException(e.getMessage());
        }
        return patientDto;
    }

    @Transactional
    public void delete(Long id) {
        this.findById(id);
        try {
            patientRepository.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessRuleException(e.getMessage());
        }
    }

    @Override
    protected final Patient copyDtoToEntity(PatientDto dto, Patient entity) {
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setOnlineStatus(dto.isOnlineStatus());
        entity.setTotalAppointment(dto.getTotalAppointment());
        return entity;
    }

    @Override
    protected final PatientDto copyEntityToDto(Patient entity, PatientDto dto) {
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setOnlineStatus(entity.isOnlineStatus());
        dto.setTotalAppointment(entity.getTotalAppointment());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setLastModifiedAt(entity.getLastModifiedAt());
        return dto;
    }
}
