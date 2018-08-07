package br.com.springmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.springmongo.service.exception.ObjectNotFoundException;

@ControllerAdvice // indica que deve tratar erros na controller
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(final ObjectNotFoundException ex,
        final HttpServletRequest request) {

        final StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
            "Não encontrado", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
