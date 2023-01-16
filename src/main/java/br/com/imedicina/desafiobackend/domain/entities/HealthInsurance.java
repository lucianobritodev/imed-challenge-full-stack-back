package br.com.imedicina.desafiobackend.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "health_insurance")
@SequenceGenerator(name = "seq_health_insurance", allocationSize = 0)
public class HealthInsurance extends Metadata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_health_insurance")
    private Long id;

    @Column(nullable = false, length = 70)
    private String name;
    @Column(nullable = false)
    private String cnpj;
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal price;

}
