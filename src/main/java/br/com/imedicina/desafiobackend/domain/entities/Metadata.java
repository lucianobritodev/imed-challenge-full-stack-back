package br.com.imedicina.desafiobackend.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@MappedSuperclass
public abstract class Metadata {

    @Column(name = "date_created", nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @Column(name = "date_modified", nullable = false)
    private ZonedDateTime lastModifiedAt;

    @PrePersist
    private void createdAt() {
        if (this.createdAt == null)
            this.createdAt = ZonedDateTime.now();

        if (this.lastModifiedAt == null)
            this.lastModifiedAt = ZonedDateTime.now();
    }

    @PreRemove
    @PreUpdate
    private void lastModifiedAt() {
        if (this.lastModifiedAt == null)
            this.lastModifiedAt = ZonedDateTime.now();
    }

}

