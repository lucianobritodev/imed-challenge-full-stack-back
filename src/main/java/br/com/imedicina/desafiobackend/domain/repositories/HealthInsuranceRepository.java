package br.com.imedicina.desafiobackend.domain.repositories;

import br.com.imedicina.desafiobackend.domain.entities.HealthInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthInsuranceRepository extends JpaRepository<HealthInsurance, Long> {
}
