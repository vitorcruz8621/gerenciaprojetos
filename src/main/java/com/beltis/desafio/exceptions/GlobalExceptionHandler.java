package com.beltis.desafio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.beltis.desafio.exceptions.tipos_excecoes.ExcecaoAcessoNaoAutorizado;
import com.beltis.desafio.exceptions.tipos_excecoes.ExcecaoDuplicacaoDeEntidade;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<MensagemErro> handleValidationException(ValidationException ex) {
        MensagemErro errorResponse = new MensagemErro(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<MensagemErro>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<MensagemErro> handleEntityNotFoundException(EntityNotFoundException ex) {
        MensagemErro errorResponse = new MensagemErro(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExcecaoDuplicacaoDeEntidade.class)
    public ResponseEntity<MensagemErro> handleDuplicateEntityException(ExcecaoDuplicacaoDeEntidade ex) {
        MensagemErro errorResponse = new MensagemErro(ex.getMessage(), HttpStatus.CONFLICT);
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ExcecaoAcessoNaoAutorizado.class)
    public ResponseEntity<MensagemErro> handleUnauthorizedActionException(ExcecaoAcessoNaoAutorizado ex) {
        MensagemErro errorResponse = new MensagemErro(ex.getMessage(), HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensagemErro> handleGenericException(Exception ex) {
        MensagemErro errorResponse = new MensagemErro("Um erro inesperado aconteceu. " + ex.getMessage() + ".", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
