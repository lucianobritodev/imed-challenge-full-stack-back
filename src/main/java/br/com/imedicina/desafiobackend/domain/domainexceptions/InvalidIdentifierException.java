package br.com.imedicina.desafiobackend.domain.domainexceptions;

import java.io.Serializable;

public class InvalidIdentifierException extends RuntimeException implements Serializable {

    public InvalidIdentifierException(String msg) {
        super(msg);
    }

}
