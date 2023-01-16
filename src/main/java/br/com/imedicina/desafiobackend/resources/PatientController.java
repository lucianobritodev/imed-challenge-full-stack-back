package br.com.imedicina.desafiobackend.resources;

import br.com.imedicina.desafiobackend.domain.dtos.PatientDto;
import br.com.imedicina.desafiobackend.domain.entities.Patient;
import br.com.imedicina.desafiobackend.domain.services.models.IConverterService;
import br.com.imedicina.desafiobackend.domain.services.models.ICrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private ICrudService<PatientDto> patientService;

    @GetMapping
    public ResponseEntity<List<PatientDto>> findAll() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PatientDto create(@RequestBody PatientDto dto) {
        return patientService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> update(
            @PathVariable("id") Long id, @RequestBody PatientDto dto) {
        return ResponseEntity.ok(patientService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
