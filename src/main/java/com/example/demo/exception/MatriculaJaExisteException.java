package com.example.demo.exception;

public class MatriculaJaExisteException extends RuntimeException {
    public MatriculaJaExisteException(String mensagem) {
        super(mensagem);
    }
}