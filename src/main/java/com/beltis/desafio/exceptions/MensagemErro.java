package com.beltis.desafio.exceptions;

import org.springframework.http.HttpStatus;

public record MensagemErro(String message, HttpStatus status) {
};