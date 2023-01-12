package br.com.imedicina.desafiobackend.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
public class PatientDto extends BaseDto implements Serializable {

    @NotBlank(message = "username cannot be null or empty.")
    @Size(min = 2, max = 70, message = "Username cannot be less than 2 characters or longer than 70 characters.")
    private String username;

    @NotBlank
    @Size(min = 5, max = 70, message = "Password cannot be less than 5 characters or longer than 70 characters.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull(message = "Total appointment cannot be null")
    private Integer totalAppointment;

    @NotNull(message = "Online status cannot be null")
    private boolean onlineStatus;

}
