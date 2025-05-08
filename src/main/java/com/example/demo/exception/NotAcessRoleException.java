package com.example.demo.exception;

public class NotAcessRoleException extends RuntimeException {
    public NotAcessRoleException(String mensagem) {
        super(mensagem);
    }
}
