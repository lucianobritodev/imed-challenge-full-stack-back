package br.com.imedicina.desafiobackend.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;
import java.time.ZonedDateTime;

@Data
public abstract class MetadataDto {

    @JsonProperty(value = "date_created", access = JsonProperty.Access.READ_ONLY)
    private ZonedDateTime createdAt;

    @JsonProperty(value = "date_modified", access = JsonProperty.Access.READ_ONLY)
    private ZonedDateTime lastModifiedAt;

}
