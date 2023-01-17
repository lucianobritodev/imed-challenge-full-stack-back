package br.com.imedicina.desafiobackend.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @JsonProperty(defaultValue = "false")
    private boolean status;

    @NotNull(message = "Rating cannot be null.")
    @Size(min = 1, max = 5, message = "Rating cannot contain a value less than 1 or greater than 5.")
    private Integer rating;


    private Integer crm;

}
