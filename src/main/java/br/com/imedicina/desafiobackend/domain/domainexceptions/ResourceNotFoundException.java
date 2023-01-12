package br.com.imedicina.desafiobackend.domain.domainexceptions;

import javax.sql.rowset.serial.SerialException;
import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException implements Serializable {

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

}