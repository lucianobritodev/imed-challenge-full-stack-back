package br.com.imedicina.desafiobackend.resources.exceptions;

import br.com.imedicina.desafiobackend.domain.domainexceptions.BusinessRuleException;
import br.com.imedicina.desafiobackend.domain.domainexceptions.InvalidIdentifierException;
import br.com.imedicina.desafiobackend.domain.domainexceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;


    @Override
    protected final ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<CustomError.Field> fields = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            fields.add(new CustomError.Field(name, message));
        }

        var errorMessage = "One or more fields are invalid. Fill in correctly and try again.";
        var error = getCustomError(errorMessage, status, request);
        error.setFields(fields);

        return handleExceptionInternal(ex, error, headers, status, request);
    }

    @ExceptionHandler(InvalidIdentifierException.class)
    public ResponseEntity<Object> handleInvalidIdentifierException(InvalidIdentifierException ex, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;
        var error = getCustomError(ex.getMessage(), status, request);
        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;
        var error = getCustomError(ex.getMessage(), status, request);
        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<Object> handleBusinessRule(BusinessRuleException ex , WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        var error = getCustomError(ex.getMessage(), status, request);
        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }


    private CustomError getCustomError(String errorMessage, HttpStatus status, WebRequest request) {
        var error = new CustomError();
        error.setStatus(status.value());
        error.setDateTime(ZonedDateTime.now());
        error.setError(errorMessage);
        error.setPath(((ServletWebRequest) request).getRequest().getRequestURI());
        return error;
    }

}
