package br.com.imedicina.desafiobackend.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder(value = { "id", "name", "cnpj", "price" })
public class HealthInsuranceDto extends MetadataDto implements  Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "username cannot be null or empty.")
    @Size(min = 2, max = 70, message = "Name cannot be less than 2 characters or longer than 70 characters.")
    private String name;

    @NotBlank
    @Size(min = 14, max = 14, message = "CNPJ must contain exactly 14 digits.")
    private String cnpj;

    @NotNull(message = "Price cannot be null.")
    @Digits(integer = 5, fraction = 2, message = "Price must contain a maximum of 5 integer digits and 2 floating point digits.")
    private BigDecimal price;

}
