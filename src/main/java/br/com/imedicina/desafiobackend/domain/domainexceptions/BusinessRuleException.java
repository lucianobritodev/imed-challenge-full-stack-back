package br.com.imedicina.desafiobackend.domain.domainexceptions;

import java.io.Serializable;

public class BusinessRuleException extends RuntimeException implements Serializable {

    public BusinessRuleException(String msg) {
        super(msg);
    }

}
