package br.com.imedicina.desafiobackend.resources;

import br.com.imedicina.desafiobackend.domain.dtos.HealthcareProfessionalDto;
import br.com.imedicina.desafiobackend.domain.services.models.ICrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/healthcare-professionals")
@AllArgsConstructor
public class HealthcareProfessionalController {

    private ICrudService<HealthcareProfessionalDto> healthcareProfessionalService;

    @GetMapping
    public ResponseEntity<List<HealthcareProfessionalDto>> findAll() {
        return ResponseEntity.ok(healthcareProfessionalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthcareProfessionalDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(healthcareProfessionalService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HealthcareProfessionalDto create(@RequestBody HealthcareProfessionalDto dto) {
        return healthcareProfessionalService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthcareProfessionalDto> update(
            @PathVariable("id") Long id, @RequestBody HealthcareProfessionalDto dto) {
        return ResponseEntity.ok(healthcareProfessionalService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        healthcareProfessionalService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
