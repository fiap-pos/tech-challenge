package br.com.fiap.techchallenge.lanchonete.core.exceptions;

public class UnexpectedDomainException extends RuntimeException {

    public UnexpectedDomainException(String message) {
        super(message);
    }

}
