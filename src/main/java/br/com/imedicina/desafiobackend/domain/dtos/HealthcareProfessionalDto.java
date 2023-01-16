package br.com.imedicina.desafiobackend.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embedded;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class HealthcareProfessionalDto extends MetadataDto implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "Name cannot be null or empty.")
    @Size(min = 2, max = 70, message = "Name cannot be less than 2 or longer than 70 characters.")
    private String name;

    @NotNull(message = "Status cannot be null.")
    private boolean status;

    @NotNull(message = "Rating cannot be null.")
    @Min(value = 1, message = "Rating cannot be less than 1.")
    private Integer rating;

    @NotNull(message = "CRM cannot be null.")
    @Size(min = 4, max = 6, message = "CRM cannot be less than 4 or longer than 6 characters.")
    private Integer crm;

}
