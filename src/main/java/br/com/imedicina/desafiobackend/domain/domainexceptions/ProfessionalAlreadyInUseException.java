package br.com.imedicina.desafiobackend.domain.domainexceptions;

import java.io.Serializable;

public class ProfessionalAlreadyInUseException extends RuntimeException implements Serializable {

    public ProfessionalAlreadyInUseException(String msg) {
        super(msg);
    }

}
