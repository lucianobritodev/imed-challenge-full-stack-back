package br.com.imedicina.desafiobackend.domain.repositories;

import br.com.imedicina.desafiobackend.domain.entities.HealthcareProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthcareProfessionalRepository extends JpaRepository<HealthcareProfessional, Long> {
}
