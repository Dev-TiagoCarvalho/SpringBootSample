package com.findmore.serverapp.pipeline;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

/**
 * This class is used to inform the Spring Framework that we are interested in Handle some exceptions.
 *
 * The @ControllerAdvice annotation here is used to inform the Spring Framework that this class is to be shared across
 * the multiple @Controller classes.
 */

@ControllerAdvice
public class EntityNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * This is the method that will handle all the EntityNotFoundException's that are throw during the runtime.
     * This method will be called every time that an EntityNotFoundException is not caught until the @Controller class,
     * this means that if a EntityNotFoundException is propagated after the @Controller class this will be the method
     * that will handle the exception.
     * @param exception The EntityNotFoundException object.
     * @param request The HTTP Request where the exception was thrown.
     * @return This method returns a ResponseEntity object that will be used by the Spring Framework to construct the
     * HTTP Response. This means that the HTTP Response will be a copy of the ResponseEntity returned by this method.
     */

    @ExceptionHandler(value= EntityNotFoundException.class)
    public ResponseEntity<Object> exceptionHandle(Exception exception, WebRequest request) {
        return ResponseEntity.status(404).body(new ExceptionResponse(404, exception.getMessage(), "EntityNotFoundException"));
    }
}
