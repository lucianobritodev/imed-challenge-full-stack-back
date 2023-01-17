package br.com.imedicina.desafiobackend.resources;

import br.com.imedicina.desafiobackend.domain.dtos.PatientDto;
import br.com.imedicina.desafiobackend.domain.services.models.ICrudService;
import jdk.jfr.ContentType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private ICrudService<PatientDto> patientService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PatientDto>> findAll() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PatientDto create(@RequestBody @Valid PatientDto dto) {
        return patientService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> update(
            @PathVariable("id") Long id, @RequestBody @Valid PatientDto dto) {
        return ResponseEntity.ok(patientService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
