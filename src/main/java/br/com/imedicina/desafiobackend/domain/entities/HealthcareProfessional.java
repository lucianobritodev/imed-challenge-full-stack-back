package br.com.imedicina.desafiobackend.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "healthcare_professional", indexes = {
        @Index(name = "idx_healthcare_professional_name", unique = false, columnList = "name"),
        @Index(name = "idx_healthcare_professional_crm", unique = true, columnList = "crm")
})
@SequenceGenerator(name = "seq_healthcare_professional", allocationSize = 0)
public class HealthcareProfessional extends Metadata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_healthcare_professional")
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column
    private boolean status;
    @Column
    private Integer rating;
    @Column(nullable = false, length = 6)
    private Integer crm;

}
