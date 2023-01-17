package br.com.imedicina.desafiobackend.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embedded;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder(value = { "id", "username", "totalAppointment", "onlineStatus" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDto extends MetadataDto implements  Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "username cannot be null or empty.")
    @Size(min = 2, max = 70, message = "Username cannot be less than 2 characters or longer than 70 characters.")
    private String username;

    @NotBlank
    @Size(min = 5, max = 70, message = "Password cannot be less than 5 characters or longer than 70 characters.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull(message = "Total appointment cannot be null.")
    @Min(value = 1, message = "Min value acceptable is 1.")
    @JsonProperty(value = "total_appointment")
    private Integer totalAppointment;

    @NotNull(message = "Online status cannot be null.")
    @JsonProperty(value = "online_status", defaultValue = "false")
    private boolean onlineStatus;

}
