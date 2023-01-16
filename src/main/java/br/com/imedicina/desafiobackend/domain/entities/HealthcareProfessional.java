package br.com.imedicina.desafiobackend.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "healthcare_professional")
@SequenceGenerator(name = "seq_healthcare_professional", allocationSize = 0)
public class HealthcareProfessional extends Metadata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_healthcare_professional")
    private Long id;

    @Column
    private String name;
    @Column
    private boolean status;
    @Column
    private Integer rating;
    @Column
    private Integer crm;

}
