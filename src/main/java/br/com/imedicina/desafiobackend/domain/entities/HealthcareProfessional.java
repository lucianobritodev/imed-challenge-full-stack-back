package br.com.imedicina.desafiobackend.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name = "seq_healthcare_professional", initialValue = 1, allocationSize = 0)
public class HealthcareProfessional extends BaseEntity {

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
