package br.com.imedicina.desafiobackend.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@SequenceGenerator(name = "seq_health_insurance", initialValue = 1, allocationSize = 0)
public class HealthInsurance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_health_insurance")
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String cnpj;
    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal price;

}
